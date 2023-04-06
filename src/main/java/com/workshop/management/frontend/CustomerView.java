package com.workshop.management.frontend;

import com.workshop.management.customers.entity.Customer;
import com.workshop.management.customers.repository.CustomerRepository;
import org.springframework.util.StringUtils;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Route("customer")
public class CustomerView extends HomePage {

    private final CustomerRepository customerRepository;

    private final CustomerEditor editor;

    final Grid<Customer> grid;

    final TextField filter;

    private final Button addNewBtn;

    public CustomerView(CustomerRepository repo, CustomerEditor editor) {
        this.customerRepository = repo;
        this.editor = editor;
        this.grid = new Grid<>(Customer.class);
        this.filter = new TextField();
        this.addNewBtn = new Button("New Customer", VaadinIcon.PLUS.create());

        HorizontalLayout actions = new HorizontalLayout(filter, addNewBtn);
        add(actions, grid, editor);

        grid.setHeight("200px");
        grid.setSortableColumns("customerId", "name", "address","city","postalCode","telephoneNumber","emailAddress");
        grid.getColumnByKey("customerId").setWidth("50px").setFlexGrow(0);

        filter.setPlaceholder("Filter by id");

        filter.setValueChangeMode(ValueChangeMode.EAGER);
        filter.addValueChangeListener(e -> listEmployees(e.getValue()));

        grid.asSingleSelect().addValueChangeListener(e -> {
            editor.editEmployee(e.getValue());
        });

        addNewBtn.addClickListener(e -> editor.editEmployee(new Customer( "","","","","","")));

        editor.setChangeHandler(() -> {
            editor.setVisible(false);
            listEmployees(filter.getValue());
        });

        listEmployees(null);
    }


    void listEmployees(String filterText) {
        if (StringUtils.isEmpty(filterText)) {
            grid.setItems(customerRepository.findAll());
        } else {
            List<Customer> customers = new ArrayList<>();
            Optional<Customer> customer = customerRepository.findById(Integer.parseInt(filterText));
            customers.add(customer.get());
            grid.setItems(customers);
        }
    }
}
