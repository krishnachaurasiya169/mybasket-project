package com.mybasket.app.service;

import com.mybasket.app.entity.Product;

import java.util.List;

public interface ProductService  {

    public List<Product> getAll();
    public Product get(Integer productId);

    public Product createProduct(Product product);
    public Product updateProduct(Integer productId,Product product);

    public void deleteProduct(Integer productId);
}
