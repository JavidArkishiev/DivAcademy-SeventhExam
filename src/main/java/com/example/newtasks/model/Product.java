package com.example.newtasks.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "product")
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,
            generator = "product_generator")
    @SequenceGenerator(name = "product_generator",
            sequenceName = "product_sequence", allocationSize = 1)
    private Integer id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "price",nullable = false)
    private Double price;


}
