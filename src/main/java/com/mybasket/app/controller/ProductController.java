package com.mybasket.app.controller;

import com.mybasket.app.entity.Product;
import com.mybasket.app.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
//    iss  mapping me direct url type kr doo
    @GetMapping("/{productId}")
//    @pathvariable is will fetch the value of productId from the httpmethod
    public Product getSingleProduct(@PathVariable("productId")Integer productId){
 Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
 return product;
 }
//create product;
//    @RequestMapping(method = RequestMethod.POST)
//    or
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        System.out.println("product name : "+product.getTitle());
        System.out.println("Create product");
        Product savedEntity = productRepository.save(product);
        return new ResponseEntity<>(savedEntity,HttpStatus.CREATED);
    }


//    update product
    @PutMapping("/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable("productId") Integer productId , @RequestBody Product product){
        System.out.println("update the data");
//      fetch the existing products
      var oldProduct =  productRepository.findById(productId).orElseThrow(()->new RuntimeException("product not found"));
       oldProduct.setTitle(product.getTitle());
       oldProduct.setDescription(product.getDescription());
       oldProduct.setShort_description(product.getShort_description());
      oldProduct.setPrice(product.getPrice());
       oldProduct.setLive(product.isLive());
       oldProduct.setOutofStock(product.isOutofStock());
       var savedProduct = productRepository.save(oldProduct);
       return new ResponseEntity<>(savedProduct,HttpStatus.OK);

    }
}
