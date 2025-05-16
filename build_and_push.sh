#!/bin/bash

VERSION=$(date +%Y%m%d-%H%M)
IMAGE_NAME="praveenk212/vaadin-app:$VERSION"

echo "🔧 Building JAR..."
./gradlew bootJar || exit 1

echo "🐳 Building Docker image: $IMAGE_NAME"
docker build -t $IMAGE_NAME .

echo "🚀 Pushing Docker image: $IMAGE_NAME"
docker push $IMAGE_NAME

echo "✅ Done: $IMAGE_NAME"
