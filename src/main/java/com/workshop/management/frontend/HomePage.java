package com.workshop.management.frontend;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLayout;

@Route("/home")
public class HomePage extends VerticalLayout implements RouterLayout {

    public HomePage() {
        setSizeFull();
        MenuBar menuBar = new MenuBar();
        menuBar.addItem("Customer", e -> UI.getCurrent().navigate("customer"));
        menuBar.addItem("Home", e -> UI.getCurrent().navigate("home"));
        Header header = new Header();
        header.add(menuBar);
        add(header);
        setHorizontalComponentAlignment(Alignment.CENTER, header);

    }
}

