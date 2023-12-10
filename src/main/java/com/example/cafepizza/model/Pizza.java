package com.example.cafepizza.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@Entity
@Table(name = "pizza")
public class Pizza {

    public Pizza() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "{validation.pizza.name}")
    @Length(max = 25, message = "{validation.pizza.name.length}")
    private String name;

    @NotBlank(message = "{validation.pizza.size}")
    @Length(max = 10, message = "{validation.pizza.size.length}")
    private String size;

    @NotBlank(message = "{validation.pizza.key_ingredients}")
    @Length(max = 50, message = "{validation.pizza.key_ingredients.length}")
    @Column(name = "key_ingredients")
    private String keyIngredients;

    @Min(value = 0, message = "{validation.pizza.price}")
    @Max(value = 1000, message = "{validation.pizza.price.value}")
    private double price;

    @NotBlank(message = "{validation.pizza.image}")
    @Length(max = 25, message = "{validation.pizza.image.length}")
    private String image;

    @JsonIgnore
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "cafe_id")
    private Cafe cafe;

}