package com.example.cafepizza;

import com.example.cafepizza.model.Cafe;

public class PizzeriaData {
    public static Cafe createCafe() {
        Cafe cafe = new Cafe();
        cafe.setId(1L);
        cafe.setName("Pomodoro");
        cafe.setCity("Odessa");
        cafe.setAddress("Glushko");
        cafe.setEmail("1@ua");
        cafe.setPhone("+38 222 333");
        cafe.setOpen("10:00");
        cafe.setClose("22:00");
        return cafe;
    }
}
