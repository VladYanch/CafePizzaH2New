package com.example.cafepizza.controller;

import com.example.cafepizza.model.Pizza;
import com.example.cafepizza.service.PizzaService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Pizza service")
@RestController
@RequestMapping("/api/pizzas")
public class PizzaRestController {
    private final PizzaService service;

    @Autowired
    public PizzaRestController(PizzaService service) {
        this.service = service;
    }

    @GetMapping()
    @ApiResponse(description = "Return list all Pizzas")
    public List<Pizza> index() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @ApiResponse(description = "Return pizza by id")
    public Pizza findById(@PathVariable Long id) {
        return service.findById(id).get();
    }
}
