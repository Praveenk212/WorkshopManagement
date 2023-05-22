package com.workshop.management.frontend;

import com.vaadin.flow.component.HasValueAndElement;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyNotifier;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import com.workshop.management.ships.entity.Ship;
import com.workshop.management.ships.repository.ShipRepository;
import com.workshop.management.workshops.entity.MaintenanceJob;
import com.workshop.management.workshops.repository.MaintenanceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.stream.Stream;

@SpringComponent
@UIScope
@Route("editWorkshop")
public class WorkshopsEditor extends FormLayout implements KeyNotifier {

    private final MaintenanceRepository repository;

    private final ShipRepository shipRepository;

    private MaintenanceJob maintenanceJob;
  //"id", "startTime", "endTime","description","actualStartTime","actualEndTime","notes","status"
   TextField ownerId = new TextField("ownerId");
    DatePicker startTime = new DatePicker("startTime");
    DatePicker endTime = new DatePicker("endTime");
    TextField description = new TextField("description");
    DatePicker actualStartTime = new DatePicker("actualStartTime");
    DatePicker actualEndTime = new DatePicker("actualEndTime");
    TextField notes = new TextField("notes");
    TextField status = new TextField("status");

//    Object ship = new TextField("ship");


    Button save = new Button("Save", VaadinIcon.CHECK.create());
    Button delete = new Button("Delete", VaadinIcon.TRASH.create());
    HorizontalLayout actions = new HorizontalLayout(save, delete);

    Binder<MaintenanceJob> binder = new Binder<>(MaintenanceJob.class);

    private ChangeHandler changeHandler;

    @Autowired
    public WorkshopsEditor(MaintenanceRepository repository, ShipRepository shipRepository) {
        this.repository = repository;
        this.shipRepository = shipRepository;

        add(ownerId,startTime, endTime,description,actualStartTime,actualEndTime,notes,status, actions);
        setRequiredIndicatorVisible(ownerId, startTime, endTime,description,actualStartTime,actualEndTime,notes,status);
        addClassName("center");
        // Max width of the Form
        setMaxWidth("500px");

        // Allow the form layout to be responsive.
        // On device widths 0-490px we have one column.
        // Otherwise, we have two columns.
        setResponsiveSteps(
                new ResponsiveStep("0", 1, ResponsiveStep.LabelsPosition.TOP),
                new ResponsiveStep("490px", 2, ResponsiveStep.LabelsPosition.TOP));
        setColspan(startTime, 2);
        setColspan(endTime, 2);
        setColspan(description, 2);
        setColspan(actualStartTime, 2);
        setColspan(actualEndTime, 2);
        setColspan(notes, 2);
        setColspan(status, 2);
        setColspan(ownerId, 2);

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
        repository.delete(maintenanceJob);
        changeHandler.onChange();
    }

    void save() {
        Optional<Ship> ship = shipRepository.findById(Integer.parseInt(ownerId.getValue()));
        if(ship.isPresent()) {
            maintenanceJob.setShip(ship.get());
            repository.save(maintenanceJob);
        }else
        {
            repository.save(maintenanceJob);
        }
        changeHandler.onChange();
    }

    public interface ChangeHandler {
        void onChange();
    }

    public final void editJob(MaintenanceJob c) {
        if (c == null) {
            setVisible(false);
            return;
        }
        final boolean persisted = c.getId() != null;
        if (persisted && ownerId.getValue()!="") {
            Optional<Ship> ship = shipRepository.findById(Integer.parseInt(ownerId.getValue()));
            if(ship.isPresent()) {
                c.setShip(ship.get());
                maintenanceJob = repository.findById(c.getId()).get();
            }else{
                maintenanceJob = c;
            }
        } else {
            maintenanceJob = c;
        }

        binder.setBean(maintenanceJob);
        setVisible(true);
        ownerId.focus();
    }

    public void setChangeHandler(ChangeHandler h) {
        changeHandler = h;
    }
    private void setRequiredIndicatorVisible(HasValueAndElement<?, ?>... components) {
        Stream.of(components).forEach(comp -> comp.setRequiredIndicatorVisible(true));
    }
}
