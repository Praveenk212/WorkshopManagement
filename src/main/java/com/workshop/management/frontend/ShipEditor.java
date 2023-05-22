package com.workshop.management.frontend;

import com.vaadin.flow.component.HasValueAndElement;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyNotifier;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import com.workshop.management.customers.entity.Customer;
import com.workshop.management.customers.repository.CustomerRepository;
import com.workshop.management.ships.entity.Ship;
import com.workshop.management.ships.repository.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.stream.Stream;

@SpringComponent
@UIScope
@Route("shipEdit")
public class ShipEditor extends FormLayout implements KeyNotifier {

    private final ShipRepository repository;

    private final CustomerRepository customerRepository;

    private Ship ship;

    TextField imonumber = new TextField("Imonumber");

    TextField brand = new TextField("Brand");

    TextField type = new TextField("Type");

    TextField ownerId = new TextField("ownerId");

    Button save = new Button("Save", VaadinIcon.CHECK.create());
    Button delete = new Button("Delete", VaadinIcon.TRASH.create());

    Binder<Ship> binder = new Binder<>(Ship.class);

    private ChangeHandler changeHandler;

    @Autowired
    public ShipEditor(ShipRepository repository, CustomerRepository customerRepository) {
        this.repository = repository;
        this.customerRepository = customerRepository;

        add(ownerId,imonumber, brand,type,save,delete);
        setRequiredIndicatorVisible(ownerId,imonumber, brand,type);
        addClassName("center");
        // Max width of the Form
        setMaxWidth("500px");

        // Allow the form layout to be responsive.
        // On device widths 0-490px we have one column.
        // Otherwise, we have two columns.
        setResponsiveSteps(
                new ResponsiveStep("0", 1, ResponsiveStep.LabelsPosition.TOP),
                new ResponsiveStep("490px", 2, ResponsiveStep.LabelsPosition.TOP));
        setColspan(imonumber, 2);
        setColspan(brand, 2);
        setColspan(type, 2);
        setColspan(ownerId,2);

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
        repository.delete(ship);
        changeHandler.onChange();
    }

    void save() {
        Optional<Integer> ownerId = Optional.ofNullable(ship.getOwnerId());
        if(ownerId.isPresent()) {
            Customer customer = customerRepository.getById(ownerId.get());
            if(customer!=null) {
                repository.save(ship);
            }
        }
        changeHandler.onChange();
    }

    public interface ChangeHandler {
        void onChange();
    }

    public final void editShip(Ship c) {
        if (c == null ) {
            setVisible(false);
            return;
        }
        final boolean persisted = c.getOwnerId() != null;
        if (persisted) {
            ship = repository.findById(c.getOwnerId()).get();
        } else {
            ship = c;
        }

        binder.setBean(ship);
        setVisible(true);
        imonumber.focus();
    }

    public void setChangeHandler(ChangeHandler h) {
        changeHandler = h;
    }
    private void setRequiredIndicatorVisible(HasValueAndElement<?, ?>... components) {
        Stream.of(components).forEach(comp -> comp.setRequiredIndicatorVisible(true));
    }
}
