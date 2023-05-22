package com.workshop.management.frontend;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import com.workshop.management.customers.entity.Customer;
import com.workshop.management.customers.repository.CustomerRepository;
import com.workshop.management.workshops.entity.MaintenanceJob;
import com.workshop.management.workshops.repository.MaintenanceRepository;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Route("workshops")
public class WorkshopsView extends HomePage {

    private final MaintenanceRepository maintenanceRepository;

    private final WorkshopsEditor editor;

    final Grid<MaintenanceJob> grid;

    final TextField filter;

    private final Button addNewBtn;

    public WorkshopsView(MaintenanceRepository repo, WorkshopsEditor editor) {
        this.maintenanceRepository = repo;
        this.editor = editor;
        this.grid = new Grid<>(MaintenanceJob.class);
        this.filter = new TextField();
        this.addNewBtn = new Button("New Job", VaadinIcon.PLUS.create());

        HorizontalLayout actions = new HorizontalLayout(filter, addNewBtn);
        add(actions, grid, editor);

        grid.setHeight("200px");
        grid.setSortableColumns("id", "startTime", "endTime","description","actualStartTime","actualEndTime","notes","status");
        grid.getColumnByKey("id").setWidth("50px").setFlexGrow(0);

        filter.setPlaceholder("Filter by id");

        filter.setValueChangeMode(ValueChangeMode.EAGER);
        filter.addValueChangeListener(e -> listJob(e.getValue()));

        grid.asSingleSelect().addValueChangeListener(e -> {
            editor.editJob(e.getValue());
        });

        addNewBtn.addClickListener(e -> editor.editJob(new MaintenanceJob( null,null,"",null,null,"","")));

        editor.setChangeHandler(() -> {
            editor.setVisible(false);
            listJob(filter.getValue());
        });

        listJob(null);
    }


    void listJob(String filterText) {
        if (StringUtils.isEmpty(filterText)) {
            grid.setItems(maintenanceRepository.findAll());
        } else {
            List<MaintenanceJob> maintenanceJobs = new ArrayList<>();
            Optional<MaintenanceJob> customer = maintenanceRepository.findById(Integer.parseInt(filterText));
            maintenanceJobs.add(customer.get());
            grid.setItems(maintenanceJobs);
        }
    }
}
