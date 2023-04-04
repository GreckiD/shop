package com.pro.shop.front;

import com.pro.shop.users.User;
import com.pro.shop.users.UsersRepository;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;


@Route(value = "")
@SpringComponent
@UIScope
public class MainView extends VerticalLayout {

    @Autowired
    public MainView(UsersRepository usersRepository) {
        Grid<User> grid = new Grid<>(User.class);
        grid.setItems(usersRepository.findAll());
        grid.addColumn(User::getLogin);
        grid.addColumn(User::getEmail);
        add(grid);
    }

}