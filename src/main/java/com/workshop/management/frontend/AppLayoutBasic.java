package com.workshop.management.frontend;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;

@Route("/new")
public class AppLayoutBasic extends AppLayout {

    public AppLayoutBasic()
    {
        DrawerToggle toggle = new DrawerToggle();
        H1 title = new H1("Workshop");
        title.getStyle().set("font-size","var(--lumo-font-size-l)").set("margin","0");

        Tab customer = new Tab("Customer");
        Tab home = new Tab("Home");
        Tabs tabs = new Tabs(customer,home);

        addToDrawer(tabs);
        addToNavbar(toggle,title);
    }
}
