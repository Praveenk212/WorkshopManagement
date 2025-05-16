# Stage 0: Build Node.js dependencies
FROM node:18 AS node-build
WORKDIR /WorkshopManagement
COPY package.json package-lock.json* ./
RUN npm install

# Stage 1: Build the application using Gradle
FROM gradle:8.1.1-jdk17 as builder
WORKDIR /WorkshopManagement

# Copy Gradle files
COPY build.gradle settings.gradle gradlew ./
COPY gradle ./gradle

# Copy source code
COPY src ./src

# Copy node_modules from node-build
COPY --from=node-build /WorkshopManagement/node_modules ./node_modules

# Build the app
RUN ./gradlew bootJar

# Stage 2: Create a lightweight image using the JAR from the previous step
FROM eclipse-temurin:17-jdk
WORKDIR /WorkshopManagement

# Copy the JAR file from builder
COPY --from=builder /WorkshopManagement/build/libs/*.jar app.jar

# Copy node_modules if needed at runtime
COPY --from=builder /WorkshopManagement/node_modules ./node_modules

# Expose port (Vaadin default: 8080)
EXPOSE 1235

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]