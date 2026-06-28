package com.mybasket.app.controller;

import com.mybasket.app.entity.Product;
import com.mybasket.app.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
@RestController
@RequestMapping("/products")

public class ProductController {

 private ProductRepository productRepository;
 public ProductController(ProductRepository productRepository){
     this.productRepository = productRepository;
 }

    //    resource : hmara products
//    to get all product
//    @RequestMapping(method = RequestMethod.GET) hr baar mapping kro phir method kon si lena kai uske liye @GetMapping mean jo http method chahiye @woMapping
//    @ResponseBody means jaha pr hogya ye uski body return krega instead spring boot give the new annotation that known as @RestController

    @GetMapping
    public List<Product> getProducts(){
     List<Product> all = productRepository.findAll();
     return all;

    }
//get single product


//    @RequestMapping( value = "/{productId}", method = RequestMethod.GET)
//    @ResponseBody


//    is mapping me direct url type kr doo
    @GetMapping("/{productId}")
    public Product getSingleProduct(@PathVariable("productId")Integer productId){
 Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
 return product;
 }

}
