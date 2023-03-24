package com.workshop.management.frontend;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("/home")
public class HomePage extends VerticalLayout {

    public HomePage() {
        // Set up the page layout
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        setSpacing(true);
        setPadding(true);

        // Add a header
        Label header = new Label("Welcome to Ship Management");
        header.getStyle().set("font-size", "xx-large");
        add(header);

        // Add some instructions
        Label instructions = new Label("Select an option from the menu to get started.");
        instructions.getStyle().set("font-size", "large");
        add(instructions);

        // Add a menu with clickable actions
        MenuBar menuBar = new MenuBar();
        MenuItem ships = menuBar.addItem("Ships", (ComponentEventListener<ClickEvent<MenuItem>>) null);

        MenuItem routes = menuBar.addItem("Routes", (ComponentEventListener<ClickEvent<MenuItem>>) null);

        add(menuBar);
    }
}

