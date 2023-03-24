package com.workshop.management.frontend;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Nav;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

@CssImport("./styles/shared-styles.css")
@Route("header")
public class MainLayout extends Composite<AppLayout> {

    private final Tabs menu;
    private final Header header;

    public MainLayout() {
        this.header = createHeader();
        this.menu = createMenu();
        getContent().setPrimarySection(AppLayout.Section.DRAWER);
        getContent().addToDrawer(this.menu);
        getContent().addToNavbar(new DrawerToggle());
        getContent().addToNavbar(this.header);
    }

    private Header createHeader() {
        Image logo = new Image("images/workshop.jpg", "My App Logo");
        logo.setHeight("60px");

        Span title = new Span("WorkShop Application");
        title.addClassName("app-title");

        Div headerWrapper = new Div(logo, title);
        headerWrapper.addClassName("header-wrapper");

        Header header = new Header();
        header.add(headerWrapper);
        return header;
    }

    private Tabs createMenu() {
        final Tab home = new Tab("Home");
        final Tab about = new Tab("About");
        final Tab contact = new Tab("Contact");

        home.add(new RouterLink("Home", HomePage.class));
        about.add(new RouterLink("About", UIClass.class));
        contact.add(new RouterLink("Contact", MainView.class));

        final Tabs tabs = new Tabs(home, about, contact);
        tabs.setOrientation(Tabs.Orientation.VERTICAL);
        return tabs;
    }

    public void setContent(Component content) {
        getContent().remove();
        getContent().addToNavbar(new DrawerToggle());
        getContent().addToNavbar(this.header);
        getContent().addToDrawer(this.menu);
        getContent().setContent(content);
    }
}

