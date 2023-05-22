package com.workshop.management.frontend;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import com.workshop.management.ships.entity.Ship;
import com.workshop.management.ships.repository.ShipRepository;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Route("ship")
public class ShipView extends HomePage {

    private final ShipRepository shipRepository;

    private final ShipEditor editor;

    final Grid<Ship> grid;

    final TextField filter;

    private final Button addNewBtn;

    public ShipView(ShipRepository repo, ShipEditor editor) {
        this.shipRepository = repo;
        this.editor = editor;
        this.grid = new Grid<>(Ship.class);
        this.filter = new TextField();
        this.addNewBtn = new Button("New Ship", VaadinIcon.PLUS.create());

        HorizontalLayout actions = new HorizontalLayout(filter, addNewBtn);
        add(actions, grid, editor);

        grid.setHeight("200px");
        grid.setSortableColumns("ownerId", "imonumber", "brand","type");
        grid.getColumnByKey("ownerId").setWidth("50px").setFlexGrow(0);

        filter.setPlaceholder("Filter by id");

        filter.setValueChangeMode(ValueChangeMode.EAGER);
        filter.addValueChangeListener(e -> listShips(e.getValue()));

        grid.asSingleSelect().addValueChangeListener(e -> {
            editor.editShip(e.getValue());
        });

        addNewBtn.addClickListener(e -> editor.editShip(new Ship( "","","")));

        editor.setChangeHandler(() -> {
            editor.setVisible(false);
            listShips(filter.getValue());
        });

        listShips(null);
    }


    void listShips(String filterText) {
        if (StringUtils.isEmpty(filterText)) {
            grid.setItems(shipRepository.findAll());
        } else {
            List<Ship> Ships = new ArrayList<>();
            Optional<Ship> Ship = shipRepository.findById(Integer.parseInt(filterText));
            Ships.add(Ship.get());
            grid.setItems(Ships);
        }
    }
}
