package com.workshop.management.frontend;

import com.vaadin.flow.component.HasValueAndElement;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.workshop.management.customers.entity.Customer;
import com.workshop.management.customers.repository.CustomerRepository;
import com.workshop.management.customers.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Stream;

@Route("/customer")
public class UIClass extends FormLayout {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerService myService;


    public UIClass(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
        myService = new CustomerService(customerRepository);
        // Add a header
        Label header = new Label("Welcome");
        header.getStyle().set("font-size", "xx-large");
        add(header);
        TextField name = new TextField("Name:");
        TextField address = new TextField("Address:");
        TextField postalCode = new TextField("postalCode:");
        TextField city = new TextField("city:");
        TextField telephoneNumber = new TextField("telephoneNumber:");
        TextField emailAddress = new TextField("emailAddress:");
        setRequiredIndicatorVisible(name, telephoneNumber, emailAddress, postalCode,
                city,address);

        addClassName("center");
        // Max width of the Form
        setMaxWidth("500px");

        // Allow the form layout to be responsive.
        // On device widths 0-490px we have one column.
        // Otherwise, we have two columns.
        setResponsiveSteps(
                new FormLayout.ResponsiveStep("0", 1, FormLayout.ResponsiveStep.LabelsPosition.TOP),
                new FormLayout.ResponsiveStep("490px", 2, FormLayout.ResponsiveStep.LabelsPosition.TOP));

        // These components always take full width
        setColspan(name, 2);
        setColspan(address, 2);
        setColspan(emailAddress, 2);
        setColspan(city, 2);
        setColspan(postalCode, 2);
        setColspan(telephoneNumber, 2);
        Button button = new Button("Saved to customer", event ->
        {
            Customer customer = new Customer();
            customer.setAddress(address.getValue());
            customer.setName(name.getValue());
            customer.setCity(city.getValue());
            customer.setPostalCode(postalCode.getValue());
            customer.setTelephoneNumber(telephoneNumber.getValue());
            customer.setEmailAddress(emailAddress.getValue());
            myService.saveCustomer(customer);
            Notification.show(customer.toString());
            name.clear();
            address.clear();
            city.clear();
            postalCode.clear();
            telephoneNumber.clear();
            emailAddress.clear();
        });
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        button.addClickShortcut(Key.ENTER);
        UI.getCurrent().navigate("");
        add(name, address, postalCode, city, telephoneNumber, emailAddress, button);
    }
    private void setRequiredIndicatorVisible(HasValueAndElement<?, ?>... components) {
        Stream.of(components).forEach(comp -> comp.setRequiredIndicatorVisible(true));
    }
}
