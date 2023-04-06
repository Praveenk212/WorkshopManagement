//package com.workshop.management.frontend;
//
//import com.vaadin.flow.component.Component;
//import com.vaadin.flow.component.HtmlComponent;
//import com.vaadin.flow.component.UI;
//import com.vaadin.flow.component.Unit;
//import com.vaadin.flow.component.charts.themes.LumoDarkTheme;
//import com.vaadin.flow.component.html.*;
//import com.vaadin.flow.component.menubar.MenuBar;
//import com.vaadin.flow.component.orderedlayout.VerticalLayout;
//import com.vaadin.flow.router.Route;
//import com.vaadin.flow.theme.Theme;
//import com.vaadin.flow.theme.lumo.Lumo;
//
//@Route("")
//@Theme(variant = Lumo.DARK)
//public class MyHome extends VerticalLayout {
//
//    public MyHome() {
//        // Create the header
//        Div headers = new Div();
//        MenuBar menuBar = new MenuBar();
//        menuBar.addItem("Customer", e -> UI.getCurrent().navigate("customer"));
//        menuBar.addItem("Home", e -> UI.getCurrent().navigate("home"));
//
//        Header header = new Header();
//        header.add(menuBar);
//        headers.add(header);
//        //        HtmlObject header = new HtmlObject("headers");
//        //        header.add(new H1("My Home Page"));
////        header.add(createNavigation());
//
//        // Create the main content
//        Div main = new Div();
//        main.add(new Span("Main content goes here"));
//
//        // Create the footer
//        Div footers = new Div();
//        Footer footer = new Footer();
//        footer.add("This is footer section");
//        footers.add(footer);
//
//        headers.setHeightFull();
//        headers.setMaxWidth(720,Unit.PIXELS);
//        headers.setHeight(50, Unit.PIXELS);
//        main.setHeight(100, Unit.PIXELS);
//        footers.setHeight(50, Unit.PIXELS);
//        // Add the components to the layout
//        add(headers, main, footers);
//    }
//
//    private Component createNavigation() {
//        UnorderedList ul = new UnorderedList();
//        ul.add(createNavItem("Home", ""));
//        ul.add(createNavItem("About", "about"));
//        ul.add(createNavItem("Contact", "contact"));
//
//        Nav nav = new Nav(ul);
//        return nav;
//    }
//
//    private Component createNavItem(String label, String route) {
//        Anchor anchor = new Anchor(route, label);
//        ListItem item = new ListItem(anchor);
//        return item;
//    }
//
//}
//
