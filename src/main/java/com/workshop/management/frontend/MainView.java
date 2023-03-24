package com.workshop.management.frontend;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.Router;

@Route("")
public class MainView extends VerticalLayout {

    public MainView() {
        // Create a menu bar with links to different views
        MenuBar menuBar = new MenuBar();
        menuBar.addItem("Home", event -> UI.getCurrent().navigate(""));
        menuBar.addItem("Save Customer", event -> UI.getCurrent().navigate("customer"));
        add(menuBar);

        // Set up the router for the views

    }
}

