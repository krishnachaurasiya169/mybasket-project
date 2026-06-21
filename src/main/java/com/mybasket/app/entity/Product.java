package com.mybasket.app.entity;


import jakarta.persistence.*;

@Entity
@Table(name="my-basket-products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String description;
    private String short_desciption;
    private double price;
    private  boolean live;
    private boolean outofStock;

//    getter setter


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title=title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShort_desciption() {
        return short_desciption;
    }

    public void setShort_desciption(String short_desciption) {
        this.short_desciption = short_desciption;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public boolean isOutofStock() {
        return outofStock;
    }

    public void setOutofStock(boolean outofStock) {
        this.outofStock = outofStock;
    }

}
