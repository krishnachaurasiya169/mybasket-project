package com.mybasket.app;

import com.mybasket.app.entity.Category;
import com.mybasket.app.entity.Product;
import com.mybasket.app.entity.User;
import com.mybasket.app.repository.CategoryRepository;
import com.mybasket.app.repository.ProductRepository;
import com.mybasket.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyBasketApp implements CommandLineRunner {

    @Autowired
    private UserService userservice;

//    ye to instance hai to static k under nahi hoga
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;


    public static void main(String[] args) {
		SpringApplication.run(MyBasketApp.class, args);

	}

    @Override
    public void run(String... args) throws Exception {
        System.out.println("app started");

 var user = new User();
 user.setUserId(1232);
 user.setName("abhinav");
 user.setEmail("abhinav@dev.ac.in");
userservice.saveUser(user);

//      var product = new Product();
//      product.setTitle("lays");
//      product.setPrice(10000);
//      product.setDescription("it the it very best product");
//      product.setShort_desciption("nyc product");
//      product.setLive(true);
//      product.setOutofStock(true);
//     productRepository.save(product);
//        System.out.println("project saved ");



        productRepository.findByIdAndTitle(3,"Lays")
                .ifPresentOrElse(product ->{
                    System.out.println(product.getTitle()+" : product found : "+product.getPrice());
                }
                ,
                        ()->{
                            System.out.println("product not found");
                        }
                        );




    }
}
