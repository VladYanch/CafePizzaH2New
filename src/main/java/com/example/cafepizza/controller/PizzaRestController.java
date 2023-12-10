package com.example.cafepizza.controller;

import java.util.List;
import com.example.cafepizza.model.Pizza;
import com.example.cafepizza.service.CafeService;
import com.example.cafepizza.service.PizzaService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pizzas")
//@Api(description="Pizza Rest Controller")
public class PizzaRestController {
    private final PizzaService service;
    private final CafeService serviceCafe;

    @Autowired
    public PizzaRestController(PizzaService service, CafeService serviceCafe) {
        this.service = service;
        this.serviceCafe = serviceCafe;
    }

    @GetMapping()
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ApiResponse(description = "find all Pizzas")
    public List<Pizza> index() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Pizza findById(@PathVariable Long id) {
//        System.out.println(id);
        return service.findById(id).get();
    }

    @DeleteMapping("/{id}")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deletePizza(@PathVariable Long id) {
        service.deletePizza(id);
    }
}
