package com.example.cafepizza.controller;

import java.util.List;
import com.example.cafepizza.model.Pizza;
import com.example.cafepizza.service.CafeService;
import com.example.cafepizza.service.PizzaService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
@RequestMapping("/pizzas/api")
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
    public Pizza findById(@RequestParam Long id) {
        return service.findById(id).get();
    }

}
