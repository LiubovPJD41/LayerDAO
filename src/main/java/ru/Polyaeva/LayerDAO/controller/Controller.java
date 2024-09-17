package ru.Polyaeva.LayerDAO.controller;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.Polyaeva.LayerDAO.repository.OrderRepositoryImpl;


import java.util.List;

@RestController
@RequestMapping("/products/fetch-product")
public class Controller {
    private final OrderRepositoryImpl repository;

    @Autowired
    public Controller(OrderRepositoryImpl repository) {
        this.repository = repository;
    }

    @GetMapping
    public String getProductName(@RequestParam String name) {
        List<String> orders = this.repository.getProductName(name);
        if (orders.isEmpty()) {
            return "Not found.";
        }
        return Strings.join(orders, ',');
    }
}
