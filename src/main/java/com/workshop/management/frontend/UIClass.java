package com.workshop.management.frontend;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.workshop.management.customers.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

@Route("")
public class UIClass extends VerticalLayout {

  @Autowired
  private CustomerService myService;

  public UIClass() {
    add(new H1("Hello, World!"));
    add(new Span("This is a Vaadin UI with Spring Boot."));
    add(new Button("Click me", event -> {
      String message = myService.getMessage("Rahul");
      Notification.show(message);
    }));
  }
}
