package com.mybasket.app.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.AnyDiscriminatorImplicitValues;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name="my-basket-category")
public class Category {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String url;

    private String title;

    private String imageurl;

    @ManyToMany(mappedBy = "categories")
    private Set<Product> products = new LinkedHashSet<>();


}
