package com.example.cafepizza.controller;

import com.example.cafepizza.PizzeriaData;
import com.example.cafepizza.model.Cafe;
import com.example.cafepizza.model.Pizza;
import com.example.cafepizza.service.CafeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = {CafeController.class}, excludeAutoConfiguration = SecurityAutoConfiguration.class)
public class CafeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CafeService cafeService;

    @Autowired
    ObjectMapper objectMapper;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void indexTest() throws Exception {
        List<Cafe> cafes = new ArrayList<>();
        cafes.add(new Cafe());

        when(cafeService.findAll()).thenReturn(cafes);

        mockMvc.perform(get("/cafes"))
                .andExpect(status().isOk())
                .andExpect(view().name("cafes/cafes"))
                .andExpect(model().attributeExists("cafes"))
                .andExpect(model().attribute("cafes", cafes));

        verify(cafeService, times(1)).findAll();
        verifyNoMoreInteractions(cafeService);
    }
    @Test
    public void deleteCafeTest() throws Exception {
        Long cafeId = 1L;

        mockMvc.perform(post("/cafes/delete")
                .param("id", String.valueOf(cafeId)))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/cafes"));

        verify(cafeService, times(1)).deleteCafe(cafeId);
        verifyNoMoreInteractions(cafeService);
    }
    @Test
    void addCafeTest() throws Exception {

        mockMvc.perform(get("/cafes/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("cafes/cafe"))
                .andExpect(model().attributeExists("cafe"));

        verifyNoMoreInteractions(cafeService);
    }
    @Test
    void createCafeTest() throws Exception {
        Cafe cafe = PizzeriaData.createCafe();

        mockMvc.perform(post("/cafes/create")
                .flashAttr("cafe", cafe))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/cafes"));

        verify(cafeService, times(1)).addOrUpdate(cafe);
        verifyNoMoreInteractions(cafeService);
    }
    @Test
    void findCafeTest() throws Exception {
        Cafe cafe = PizzeriaData.createCafe();
        Long cafeId = cafe.getId();

        when(cafeService.findById(cafeId)).thenReturn(Optional.of(cafe));

        mockMvc.perform(get("/cafes/edit")
                .param("id", String.valueOf(cafeId)))
                .andExpect(status().isOk())
                .andExpect(view().name("cafes/cafe"))
                .andExpect(model().attributeExists("cafe"))
                .andExpect(model().attribute("cafe", cafe));

        verify(cafeService, times(1)).findById(cafeId);
        verifyNoMoreInteractions(cafeService);
    }
    @Test
    public void showCafeWithMenuTest() throws Exception {
        Cafe cafe = PizzeriaData.createCafe();
        List<Pizza> menu = new ArrayList<>();
        menu.add(mock(Pizza.class));
        cafe.setPizzaMenu(menu);

        when(cafeService.findById(cafe.getId())).thenReturn(Optional.of(cafe));

        mockMvc.perform(get("/cafes/show")
                .param("id", String.valueOf(cafe.getId())))
                .andExpect(status().isOk())
                .andExpect(view().name("cafes/menu"))
                .andExpect(model().attributeExists("cafe"))
                .andExpect(model().attribute("cafe", cafe))
                .andExpect(model().attributeExists("pizzas"))
                .andExpect(model().attribute("pizzas", menu));

        verify(cafeService, times(1)).findById(cafe.getId());
        verifyNoMoreInteractions(cafeService);
    }
}