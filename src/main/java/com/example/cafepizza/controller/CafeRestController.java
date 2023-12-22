package com.example.cafepizza.controller;

import com.example.cafepizza.model.Cafe;
import com.example.cafepizza.service.CafeService;
import com.example.cafepizza.service.PizzaService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Cafe service")
@RestController
@RequestMapping("/api/cafes")
public class CafeRestController {
    private final CafeService serviceCafe;

    @Autowired
    public CafeRestController(PizzaService service, CafeService serviceCafe) {
        this.serviceCafe = serviceCafe;
    }

    @GetMapping()
    @ApiResponse(description = "Return list all Cafes")
    public List<Cafe> index() {
        return serviceCafe.findAll();
    }

    @GetMapping("/{id}")
    @ApiResponse(description = "Return Cafe by id")
    public Cafe findById(@PathVariable Long id) {
        return serviceCafe.findById(id).get();
    }

}
