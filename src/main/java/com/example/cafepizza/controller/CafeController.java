package com.example.cafepizza.controller;

import com.example.cafepizza.model.Cafe;
import com.example.cafepizza.service.CafeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/cafes")
@SessionAttributes("editCafe")
public class CafeController {
    private final CafeService service;

    @Autowired
    public CafeController(CafeService service) {
        this.service = service;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("cafes", service.findAll());
        return "cafes/cafes";
    }

    @PostMapping(value = "/delete")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteCafe(@RequestParam Long id, RedirectAttributes attributes) {
        service.deleteCafe(id);
        attributes.addFlashAttribute("deleted", id);
        return "redirect:/cafes";
    }
    @GetMapping(value = "/new")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String addCafe(@ModelAttribute ("cafe") Cafe cafe) { return "cafes/cafe";}

    @PostMapping("/create")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String createCafe(@ModelAttribute ("cafe") @Valid Cafe cafe, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "cafes/cafe";
        service.addOrUpdate(cafe);
        return "redirect:/cafes";
    }
    @GetMapping(value = "/edit")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String findCafe(@RequestParam ("id") Long id, Model model ) {
        model.addAttribute("cafe",service.findById(id).get());
        return "cafes/cafe";
    }

    @GetMapping(value = "/show")
    public String showCafeWithMenu(@RequestParam ("id") Long id, Model model ) {
        Cafe cafeChoice = service.findById(id).get();
        model.addAttribute("cafe",cafeChoice);
        model.addAttribute("pizzas",cafeChoice.getPizzaMenu());
        return "cafes/menu";
    }
}
