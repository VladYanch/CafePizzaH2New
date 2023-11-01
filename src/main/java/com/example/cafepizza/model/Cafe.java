package com.example.cafepizza.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "cafe")
public class Cafe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "{validation.cafe.name}")
    @Length(max = 20, message = "{validation.cafe.name.length}")
    private String name;

    @NotBlank(message = "{validation.cafe.city}")
    @Length(max = 20, message = "{validation.cafe.city.length}")
    private String city;

    @NotBlank(message = "{validation.cafe.address}")
    @Length(max = 30, message = "{validation.cafe.address.length}")
    private String address;

    @Email(message = "{validation.cafe.email}")
    @NotBlank(message = "{validation.cafe.email}")
    @Length(max = 25, message = "{validation.cafe.email.length}")
    private String email;

    @NotBlank(message = "{validation.cafe.phone}")
    @Length(max = 20, message = "{validation.cafe.phone.length}")
    private String phone;

    @NotBlank(message = "{validation.cafe.open}")
    @Length(max = 5, message = "{validation.cafe.open.length}")
    private String open;

    @NotBlank(message = "{validation.cafe.close}")
    @Length(max = 5, message = "{validation.cafe.close.length}")
    private String close;

    @OneToMany(mappedBy = "cafe",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Pizza> pizzaMenu = new ArrayList<>();
}
