package com.fooddelivery.foodcatalogue.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String foodDescription;
    private boolean isVeg;
    private Integer price;
    private int restaurantId;

    @Column(nullable = false, columnDefinition = "INT DEFAULT 0")
    private int quantity;
}
