package com.mybasket.app.repository;

import com.mybasket.app.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Integer> {
//    custom method/query methods

    //    implemention of these method are automatically
    List<Product> findByTitle(String title);

    List<Product> findByLive(Boolean live);

    List<Product> findByOutofStock(Boolean outofstock);

//    java 8 ka feature hai
    Optional <Product> findByIdAndTitle(Integer id , String title);
}
