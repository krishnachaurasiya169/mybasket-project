package com.mybasket.app.service;

import com.mybasket.app.dto.PageResponse;
import com.mybasket.app.dto.ProductDto;
import com.mybasket.app.entity.Product;

public interface ProductService  {

    public PageResponse<Product> getAll(int page, int size , String sortBy, String sortDir);
    public Product get(Integer productId);

    public ProductDto createProduct(ProductDto productDto);
    public Product updateProduct(Integer productId,Product product);

    public void deleteProduct(Integer productId);
}
