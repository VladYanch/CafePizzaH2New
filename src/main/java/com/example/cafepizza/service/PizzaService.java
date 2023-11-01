package com.example.cafepizza.service;

import com.example.cafepizza.model.Pizza;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

public interface PizzaService {
    List<Pizza> findAll();
    void deletePizza(Long id);
    Optional<Pizza> findById(Long id);
    void addOrUpdate(Pizza pizza);
}
