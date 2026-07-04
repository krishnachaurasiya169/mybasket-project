package com.mybasket.app.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name="my-basket-products")
@Getter
@Setter
public class Product extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;


    private String title;
    private String description;
    private String short_description;
    private double price;
    private boolean live;
    private boolean outofStock;


    @OneToOne(fetch = FetchType.EAGER)
    private  FileMetaData image;


    @ManyToMany
    private Set<Category> categories = new LinkedHashSet<>();


}
