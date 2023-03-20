package com.workshop.management.frontend;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.workshop.management.customers.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

@Route("")
public class UIClass extends VerticalLayout {

    @Autowired
    private CustomerService myService;


    public UIClass() {

        TextField textField = new TextField("Enter your name:");
        Button button = new Button("Say hello", event -> Notification.show("Hello, " + myService.getMessage(textField.getValue())));
        add(textField, button);
    }
}
