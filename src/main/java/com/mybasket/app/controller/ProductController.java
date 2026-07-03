package com.mybasket.app.controller;

import com.mybasket.app.dto.PageResponse;
import com.mybasket.app.dto.ProductDto;
import com.mybasket.app.entity.Product;
import com.mybasket.app.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@Controller
@RestController
@RequestMapping("/products")

    public class ProductController {
//    business logic service hai
    private ProductService productService;

//    constructor banayenge
    public ProductController(ProductService productService) {
        this.productService = productService;

    }
//    resource : hmara products
//    to get all product k liye
//    @RequestMapping(method = RequestMethod.GET) hr baar mapping kro phir method kon si lena kai uske liye @GetMapping mean jo http method chahiye @woMapping
//    @ResponseBody means jaha pr hogya ye uski body return krega instead spring boot give the new annotation that known as @RestController

     @GetMapping
     public PageResponse<Product> getProducts(
//             pagination concept laga hai
          @RequestParam(value = "page",defaultValue = "0")   int page,
          @RequestParam(value = "size",defaultValue = "10")  int size,
          @RequestParam("sortBy") String sortBy,
          @RequestParam(value = "sortDir", defaultValue="asc") String sortDir
     ){
         return productService.getAll(page,size,sortBy,sortDir);
     }

//     get single product
//    @RequestMapping( value = "/{productId}", method = RequestMethod.GET)
//    @ResponseBody
//    iss  mapping me direct url type kr doo
    @GetMapping("/{productId}")
//    @pathvariable is will fetch the value of productId from the httpmethod
    public Product getSingleProduct(@PathVariable("productId")Integer productId){
    return productService.get(productId) ;
    }
//create product;
//    @RequestMapping(method = RequestMethod.POST)
//    or
    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@Valid @RequestBody ProductDto productDto){
//        System.out.println("product name : "+product.getTitle());
//        System.out.println("Create product");
        ProductDto savedEntity = productService.createProduct(productDto);
        return new ResponseEntity<>(savedEntity,HttpStatus.CREATED);
    }


//    update product
    @PutMapping("/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable("productId") Integer productId , @RequestBody Product product){
        System.out.println("update the data");
//      fetch the existing products

      var savedProduct =  productService.updateProduct(productId,product);
            return new ResponseEntity<>(savedProduct,HttpStatus.OK);

    }


//    delete product
    @DeleteMapping
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer productId){
         productService.deleteProduct(productId);
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
