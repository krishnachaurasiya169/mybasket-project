package com.mybasket.app.service.impl;

import com.mybasket.app.dto.PageResponse;
import com.mybasket.app.dto.ProductDto;
import com.mybasket.app.entity.Product;
import com.mybasket.app.repository.ProductRepository;
import com.mybasket.app.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service  ;

@Service
@RequiredArgsConstructor

public class ProductServiceImpl implements ProductService {


    private final ProductRepository productRepository;

    private  final ModelMapper modelMapper;

    @Override
    public Product updateProduct(Integer productId, Product product) {
        var oldProduct =  productRepository.findById(productId).orElseThrow(()->new RuntimeException("product not found"));
        oldProduct.setTitle(product.getTitle());
        oldProduct.setDescription(product.getDescription());
        oldProduct.setShort_description(product.getShort_description());
        oldProduct.setPrice(product.getPrice());
        oldProduct.setLive(product.isLive());
        oldProduct.setImage(product.getImage());
        return productRepository.save(oldProduct);
    }

    @Override
    public void deleteProduct(Integer productId) {
        var product = productRepository.findById(productId).orElseThrow(()->new RuntimeException("product not found"));
        productRepository.delete(product);
    }


    @Override
    public PageResponse<Product> getAll(int page,int size,String sortBy,String sortDir) {
//        findAll() method me pageable bhi pass kr skte hai aur sort bhi , aur direction   hai
//        pageable ko kaise passs kare pageable ek interface hai iska direct object nahi bana skte
//        toh hm pageRequest ka object use karenge aur isme of() method hota hai

        Sort sort = sortDir.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                :Sort.by(sortBy).ascending();
        Pageable pageable = PageRequest.of(page, size,sort);
       Page<Product>pageProduct = productRepository.findAll(pageable);
       return PageResponse.of(pageProduct);
    }

    @Override
    public Product get(Integer productId) {
        return productRepository.findById(productId).orElseThrow(()->new RuntimeException("product not found"));
    }

    @Override
    public ProductDto createProduct (ProductDto productDto) {
        var product = modelMapper.map(productDto,Product.class);
        var saveProduct = productRepository.save(product);
        return modelMapper.map(saveProduct,ProductDto.class) ;
    }
}
