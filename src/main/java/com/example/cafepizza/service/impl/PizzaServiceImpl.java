package com.example.cafepizza.service.impl;

import com.example.cafepizza.model.Pizza;
import com.example.cafepizza.repository.PizzaRepository;
import com.example.cafepizza.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PizzaServiceImpl implements PizzaService {
    private final PizzaRepository pizzaRepository;
    @Autowired
    public PizzaServiceImpl(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }
    @Override
    public List<Pizza> findAll() {return pizzaRepository.findAll();}
    @Override
    public void deletePizza(Long id) { pizzaRepository.deleteById(id);}
    @Override
    public Optional<Pizza> findById(Long id) {
        return pizzaRepository.findById(id);
    }
    @Override
    public void addOrUpdate(Pizza pizza) { pizzaRepository.save(pizza);}
}
