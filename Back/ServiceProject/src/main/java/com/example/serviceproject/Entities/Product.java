package com.example.serviceproject.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer idProduct;

    private  String name;

    private String description;
    private double price;
    private  Integer quantity;
    private String UrlImg;
    @Min(value = 0, message = "Le rating doit être supérieur ou égal à 0")
    @Max(value = 5, message = "Le rating doit être inférieur ou égal à 5")
    private Integer rating;
    @ManyToOne
    private Warehouse warehouse;



}
