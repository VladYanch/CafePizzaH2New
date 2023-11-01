package com.example.cafepizza.service;

import com.example.cafepizza.PizzeriaData;
import com.example.cafepizza.model.Cafe;
import com.example.cafepizza.repository.CafeRepository;
import com.example.cafepizza.service.impl.CafeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@SpringBootTest
class CafeServiceImplTestMockito {
    @Mock
    private CafeRepository repository;

    @Autowired
    private CafeServiceImpl service;
    private static List<Cafe> cafes;

    @Autowired
    private static Cafe cafe;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        service = new CafeServiceImpl(repository);
        Cafe cafe = PizzeriaData.createCafe();

        Cafe cafe2 = new Cafe();
        cafe2.setId(2L);
        cafe2.setName("Milano im Westend");
        cafe2.setCity("Munster");
        cafe2.setAddress("Wilhelmstr. 26");
        cafe2.setPhone("+49 0251 25962555");
        cafe2.setEmail("mail@milano-westend.de");
        cafe2.setOpen("09-00");
        cafe2.setClose("21-00");

        cafes = Arrays.asList(cafe, cafe2);
    }
    @Test
    void findAllCafesTest() {
        when(repository.findAll()).thenReturn(cafes);
        List<Cafe> result = service.findAll();
        assertEquals(cafes.size(), result.size());
        verify(repository, times(1)).findAll();
    }
    @Test
    void deleteCafeTest() {
        service.deleteCafe(1L);
        verify(repository, times(1)).deleteById(1L);
    }
    @Test
    void findByIdTest() {
        Cafe cafe = PizzeriaData.createCafe();
        when(repository.findById(1L)).thenReturn(Optional.of(cafe));
        assertEquals("Pomodoro", service.findById(1L).get().getName());
    }
    @Test
    void addOrUpdate() {
        Cafe cafe = PizzeriaData.createCafe();
        cafe.setId(2L);
        assertTrue(cafe.getId() == 2L);
        service.addOrUpdate(cafe);
        verify(repository, times(1)).save(cafe);
    }
}