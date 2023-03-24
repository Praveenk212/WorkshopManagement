package com.workshop.management.frontend;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

@Route("home2")
public class HomePage2 extends VerticalLayout {

    public HomePage2() {
        // add header with company logo and navigation links
        HorizontalLayout header = new HorizontalLayout();
        header.setDefaultVerticalComponentAlignment(Alignment.CENTER);
        Image logo = new Image("img/workshop.jpg", "My Ship Workshop Management System");
        header.add(logo);
        header.add(new RouterLink("Home", HomePage.class));
        header.add(new RouterLink("About", HomePage.class));
        header.add(new RouterLink("Contact", HomePage.class));
        add(header);

        // add key features section with brief descriptions and links to more details
        VerticalLayout featuresSection = new VerticalLayout();
        H3 featuresHeader = new H3("Key Features");
        featuresSection.add(featuresHeader);

        Span feature1 = new Span("Inventory management");
        feature1.addClickListener(e -> UI.getCurrent().navigate(HomePage.class));
        featuresSection.add(feature1);

        Span feature2 = new Span("Maintenance tracking");
        feature2.addClickListener(e -> UI.getCurrent().navigate(HomePage.class));
        featuresSection.add(feature2);

        Span feature3 = new Span("Personnel management");
        feature3.addClickListener(e -> UI.getCurrent().navigate(HomePage.class));
        featuresSection.add(feature3);

        add(featuresSection);

        // add search bar and quick access buttons
        HorizontalLayout searchBar = new HorizontalLayout();
        searchBar.setDefaultVerticalComponentAlignment(Alignment.CENTER);
        TextField searchField = new TextField("Search");
        Button searchButton = new Button("Go");
        searchBar.add(searchField, searchButton);
        add(searchBar);

        // add latest news and updates section
        VerticalLayout newsSection = new VerticalLayout();
        H3 newsHeader = new H3("Latest News and Updates");
        newsSection.add(newsHeader);
        Span news1 = new Span("New inventory management features now available!");
        newsSection.add(news1);
        Span news2 = new Span("Improved personnel management module now live!");
        newsSection.add(news2);
        add(newsSection);

        // add call-to-action button
        Button ctaButton = new Button("Get started now!");
        ctaButton.addClickListener(e -> UI.getCurrent().navigate(UIClass.class));
        add(ctaButton);

        // add social media links
        HorizontalLayout socialMedia = new HorizontalLayout();
        socialMedia.setDefaultVerticalComponentAlignment(Alignment.CENTER);
        socialMedia.add(new Icon(VaadinIcon.FACEBOOK), new Icon(VaadinIcon.TWITTER), new Icon(VaadinIcon.ALIGN_CENTER));
                // set spacing and alignment
                setSpacing(true);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
    }
}