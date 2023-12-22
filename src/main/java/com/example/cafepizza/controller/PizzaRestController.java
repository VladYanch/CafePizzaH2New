package com.example.cafepizza.controller;

import java.util.List;
import com.example.cafepizza.model.Pizza;
import com.example.cafepizza.service.CafeService;
import com.example.cafepizza.service.PizzaService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pizzas")
public class PizzaRestController {
    private final PizzaService service;
    private final CafeService serviceCafe;

    @Autowired
    public PizzaRestController(PizzaService service, CafeService serviceCafe) {
        this.service = service;
        this.serviceCafe = serviceCafe;
    }

    @GetMapping()
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ApiResponse(description = "Return list all Pizzas")
    public List<Pizza> index() {
        return service.findAll();
    }

    @GetMapping("/{id}")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ApiResponse(description = "Return pizza by id")
    public Pizza findById(@PathVariable Long id) {
        return service.findById(id).get();
    }
}
