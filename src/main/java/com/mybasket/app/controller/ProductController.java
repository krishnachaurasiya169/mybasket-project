package com.mybasket.app.controller;

import com.mybasket.app.dto.PageResponse;
import com.mybasket.app.dto.ProductDto;
import com.mybasket.app.entity.FileMetaData;
import com.mybasket.app.entity.Product;
import com.mybasket.app.service.FileStorageService;
import com.mybasket.app.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;

//@Controller
@RestController
@RequiredArgsConstructor
@RequestMapping("/products")

public class ProductController {

    //    business logic "service" package me
    private final ProductService productService;

    //    FileMetaData Service
    private final FileStorageService fileStorageService;

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

    //    create product;
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

    //controller method to upload product image

    @PostMapping("/{productId}/image")
    public ResponseEntity<FileMetaData> uploadProductImage(
            @PathVariable("productId") Integer productId,
            @RequestParam("productImage") MultipartFile file
    ) throws IOException {
//        System.out.println(file.getOriginalFilename());

        Product product = productService.get(productId);
        FileMetaData fileMetaData = fileStorageService.uploadFile(file);
        product.setImage(fileMetaData);

//        image validation

        System.out.println(file.getContentType());

        if (!file.getContentType().equalsIgnoreCase("image/png") && !file.getContentType().equalsIgnoreCase("image/jpeg")) {
            throw new BadRequestException("Invalid file type !");
        }


        // file upload code
        productService.updateProduct(productId, product);
        return ResponseEntity.ok(fileMetaData);
    }


    @GetMapping("/{productId}/image")
    public ResponseEntity<Resource> serveFile(
            @PathVariable("productId") Integer productId
    ) throws MalformedURLException, BadRequestException {
        Product product = productService.get(productId);
        FileMetaData fileMetaData = product.getImage();

        Resource resource = fileStorageService.loadFile(fileMetaData);

        String contentType = fileMetaData.getFileType();
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(
                        HttpHeaders.CONTENT_DISPOSITION,
                        "inline; filename=\"" + resource.getFilename() + "\""
                )
                .body(resource);

    }


}


















//package com.mybasket.app.controller;
//
//import com.mybasket.app.dto.PageResponse;
//import com.mybasket.app.dto.ProductDto;
//import com.mybasket.app.entity.FileMetaData;
//import com.mybasket.app.entity.Product;
//import com.mybasket.app.service.FileStorageService;
//import com.mybasket.app.service.ProductService;
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import org.apache.coyote.BadRequestException;
//import org.springframework.core.io.Resource;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.net.MalformedURLException;
//
////@Controller
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/products")
//
//    public class ProductController {
//
////    business logic "service" package me
//    private final ProductService productService;
//
////    FileMetaData Service
//    private final FileStorageService fileStorageService;
//
////    resource : hmara products
////    to get all product k liye
////    @RequestMapping(method = RequestMethod.GET) hr baar mapping kro phir method kon si lena kai uske liye @GetMapping mean jo http method chahiye @woMapping
////    @ResponseBody means jaha pr hogya ye uski body return krega instead spring boot give the new annotation that known as @RestController
//
//     @GetMapping
//     public PageResponse<Product> getProducts(
////             pagination concept laga hai
//          @RequestParam(value = "page",defaultValue = "0")   int page,
//          @RequestParam(value = "size",defaultValue = "10")  int size,
//          @RequestParam("sortBy") String sortBy,
//          @RequestParam(value = "sortDir", defaultValue="asc") String sortDir
//     ){
//         return productService.getAll(page,size,sortBy,sortDir);
//     }
//
////     get single product
////    @RequestMapping( value = "/{productId}", method = RequestMethod.GET)
////    @ResponseBody
////    iss  mapping me direct url type kr doo
//    @GetMapping("/{productId}")
////    @pathvariable is will fetch the value of productId from the httpmethod
//    public Product getSingleProduct(@PathVariable("productId")Integer productId){
//    return productService.get(productId) ;
//    }
//
////    create product;
////    @RequestMapping(method = RequestMethod.POST)
////    or
//    @PostMapping
//    public ResponseEntity<ProductDto> createProduct(@Valid @RequestBody ProductDto productDto){
////        System.out.println("product name : "+product.getTitle());
////        System.out.println("Create product");
//        ProductDto savedEntity = productService.createProduct(productDto);
//        return new ResponseEntity<>(savedEntity,HttpStatus.CREATED);
//    }
//
////    update product
//    @PutMapping("/{productId}")
//    public ResponseEntity<Product> updateProduct(@PathVariable("productId") Integer productId , @RequestBody Product product){
//        System.out.println("update the data");
////      fetch the existing products
//      var savedProduct =  productService.updateProduct(productId,product);
//            return new ResponseEntity<>(savedProduct,HttpStatus.OK);
//    }
//
////    delete product
//    @DeleteMapping
//    public ResponseEntity<Void> deleteProduct(@PathVariable Integer productId){
//         productService.deleteProduct(productId);
//         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//
//    //controller method to upload product image
//
//    @PostMapping("/{productId}/image")
//    public ResponseEntity<FileMetaData> uploadProductImage(
//            @PathVariable("productId") Long productId,
//            @RequestParam("productImage") MultipartFile file
//    ) throws IOException {
////        System.out.println(file.getOriginalFilename());
//
//        Product product = productService.get(productId);
//        FileMetaData fileMetaData = fileStorageService.uploadFile(file);
//        product.setImage(fileMetaData);
//
////        image validation
//
//        System.out.println(file.getContentType());
//
//        if (!file.getContentType().equalsIgnoreCase("image/png") && !file.getContentType().equalsIgnoreCase("image/jpeg")) {
//            throw new BadRequestException("Invalid file type !");
//        }
//
//
//        // file upload code
//        productService.udpateProduct(productId, product);
//        return ResponseEntity.ok(fileMetaData);
//    }
//
//
//    @GetMapping("/{productId}/image")
//    public ResponseEntity<Resource> serveFile(
//            @PathVariable("productId") Long productId
//    ) throws MalformedURLException, BadRequestException {
//        Product product = productService.get(productId);
//        FileMetaData fileMetaData = product.getImage();
//
//        Resource resource = fileStorageService.loadFile(fileMetaData);
//
//        String contentType = fileMetaData.getFileType();
//        return ResponseEntity.ok()
//                .contentType(MediaType.parseMediaType(contentType))
//                .header(
//                        HttpHeaders.CONTENT_DISPOSITION,
//                        "inline; filename=\"" + resource.getFilename() + "\""
//                )
//                .body(resource);
//
//    }
//
//
//}
