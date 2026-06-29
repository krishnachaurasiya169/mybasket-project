package com.mybasket.app.service.impl;

import com.mybasket.app.entity.Product;
import com.mybasket.app.repository.ProductRepository;
import com.mybasket.app.service.ProductService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {


    private ProductRepository productRepository;
    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public Product updateProduct(Integer productId, Product product) {
        var oldProduct =  productRepository.findById(productId).orElseThrow(()->new RuntimeException("product not found"));
        oldProduct.setTitle(product.getTitle());
        oldProduct.setDescription(product.getDescription());
        oldProduct.setShort_description(product.getShort_description());
        oldProduct.setPrice(product.getPrice());
        oldProduct.setLive(product.isLive());
        return productRepository.save(oldProduct);
    }

    @Override
    public void deleteProduct(Integer productId) {
        var product = productRepository.findById(productId).orElseThrow(()->new RuntimeException("product not found"));
        productRepository.delete(product);
    }


    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product get(Integer productId) {
        return productRepository.findById(productId).orElseThrow(()->new RuntimeException("product not found"));
    }

    @Override
    public Product createProduct (Product product) {
        return productRepository.save(product) ;
    }
}
