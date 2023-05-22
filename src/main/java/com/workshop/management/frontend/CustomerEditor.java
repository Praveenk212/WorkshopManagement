package com.workshop.management.frontend;

import com.vaadin.flow.component.HasValueAndElement;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyNotifier;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import com.workshop.management.customers.entity.Customer;
import com.workshop.management.customers.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Stream;

@SpringComponent
@UIScope
@Route("customerEdit")
public class CustomerEditor extends FormLayout implements KeyNotifier {

    private final CustomerRepository repository;

    private Customer customer;

    TextField name = new TextField("Name");
    TextField address = new TextField("Address");

    TextField postalCode = new TextField("postalCode");
    TextField city = new TextField("city");
    TextField telephoneNumber = new TextField("telephoneNumber");
    TextField emailAddress = new TextField("emailAddress");


    Button save = new Button("Save", VaadinIcon.CHECK.create());
    Button delete = new Button("Delete", VaadinIcon.TRASH.create());
    HorizontalLayout actions = new HorizontalLayout(save, delete);

    Binder<Customer> binder = new Binder<>(Customer.class);
    private ChangeHandler changeHandler;

    @Autowired
    public CustomerEditor(CustomerRepository repository) {
        this.repository = repository;

        add(name, address,postalCode,emailAddress,telephoneNumber,city, actions);
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
        setColspan(name, 2);
        setColspan(address, 2);
        setColspan(emailAddress, 2);
        setColspan(city, 2);
        setColspan(postalCode, 2);
        setColspan(telephoneNumber, 2);

        binder.bindInstanceFields(this);

        //setSpacing(true);

        save.getElement().getThemeList().add("primary");
        delete.getElement().getThemeList().add("error");

        addKeyPressListener(Key.ENTER, e -> save());

        save.addClickListener(e -> save());
        delete.addClickListener(e -> delete());
        setVisible(false);
    }

    void delete() {
        repository.delete(customer);
        changeHandler.onChange();
    }

    void save() {
        repository.save(customer);
        changeHandler.onChange();
    }

    public interface ChangeHandler {
        void onChange();
    }

    public final void editEmployee(Customer c) {
        if (c == null) {
            setVisible(false);
            return;
        }
        final boolean persisted = c.getCustomerId() != null;
        if (persisted) {
            customer = repository.findById(c.getCustomerId()).get();
        } else {
            customer = c;
        }

        binder.setBean(customer);
        setVisible(true);
        name.focus();
    }

    public void setChangeHandler(ChangeHandler h) {
        changeHandler = h;
    }
    private void setRequiredIndicatorVisible(HasValueAndElement<?, ?>... components) {
        Stream.of(components).forEach(comp -> comp.setRequiredIndicatorVisible(true));
    }
}
