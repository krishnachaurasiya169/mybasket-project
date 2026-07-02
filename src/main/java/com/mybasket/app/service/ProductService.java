package com.mybasket.app.service;

import com.mybasket.app.dto.ProductDto;
import com.mybasket.app.entity.Product;

import java.util.List;

public interface ProductService  {

    public List<Product> getAll();
    public Product get(Integer productId);

    public ProductDto createProduct(ProductDto productDto);
    public Product updateProduct(Integer productId,Product product);

    public void deleteProduct(Integer productId);
}
