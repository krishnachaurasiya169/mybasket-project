package com.mybasket.app.repository;

import com.mybasket.app.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
//yadi repository k under koi bhi method na ho to by default CRUD operation se
public interface ProductRepository extends JpaRepository<Product,Integer> {
//   1st type of creating custom method/query methods
    //    implemention of these method are automatically
//   use only column name of table then make the methods
    List<Product> findByTitle(String title);

    List<Product> findByLive(Boolean live);

    List<Product> findByOutofStock(Boolean outofstock);

//    java 8 ka feature hai
    Optional <Product> findByProductIdAndTitle(Integer productId , String title);



// 2nd types of custom methods
//    isme actual query likhe
//    this jpql --- jakarta persistent query langauage
// ye entity pr lagta hai , entity kon hai Product hai

@Query("select p from Product p ")
    List<Product> getAllProduct();

    @Query("select p  from Product p where p.id=?1")
 Product getProductByTitle(String title);


}
