package com.example.cafepizza.controller;

import java.util.List;

import com.example.cafepizza.model.Cafe;
import com.example.cafepizza.model.Pizza;
import com.example.cafepizza.service.CafeService;
import com.example.cafepizza.service.PizzaService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cafes")
//@Api(description="Cafe Rest Controller")
public class CafeRestController {
    private final PizzaService service;
    private final CafeService serviceCafe;

    @Autowired
    public CafeRestController(PizzaService service, CafeService serviceCafe) {
        this.service = service;
        this.serviceCafe = serviceCafe;
    }

    @GetMapping()
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ApiResponse(description = "find all cafes")
    public List<Cafe> index() {
        return serviceCafe.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Cafe findById(@PathVariable Long id) {
        return serviceCafe.findById(id).get();
    }

}
