package com.example.cafepizza.controller;

import com.example.cafepizza.model.Pizza;
import com.example.cafepizza.service.CafeService;
import com.example.cafepizza.service.PizzaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//@Log4j2
@Controller
@RequestMapping("/pizzas")
@SessionAttributes("editPizza")
public class PizzaController {
    private final PizzaService service;
    private final CafeService serviceCafe;

    @Autowired
    public PizzaController(PizzaService service, CafeService serviceCafe) {
        this.service = service;
        this.serviceCafe = serviceCafe;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("pizzas", service.findAll());
        return "pizzas/pizzas";
    }
    @PostMapping(value = "/delete")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deletePizza(@RequestParam Long id, RedirectAttributes attributes) {
        service.deletePizza(id);
        attributes.addFlashAttribute("deleted", id);
        return "redirect:/pizzas";
    }
    @GetMapping(value = "/new")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String addPizza(@ModelAttribute ("pizza") Pizza pizza, Model model) {
        pizza.setImage("/img/marherita.jpeg");
        pizza.setName("New Pizza");
        model.addAttribute("cafes", serviceCafe.findAll());
        return "pizzas/new";
    }
    @PostMapping("/create")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
        public String createPizza(@ModelAttribute ("pizza") @Valid Pizza pizza, BindingResult bindingResult,
                               Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("pizza", pizza);
            model.addAttribute("cafes", serviceCafe.findAll());
            return "pizzas/pizza";
        }
        service.addOrUpdate(pizza);
        return "redirect:/pizzas";
    }
    @GetMapping(value = "/edit")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String findPizza(@RequestParam ("id") Long id, Model model) {
        model.addAttribute("pizza",service.findById(id).get());
        model.addAttribute("cafes",serviceCafe.findAll());
        return "pizzas/pizza";
    }
}
