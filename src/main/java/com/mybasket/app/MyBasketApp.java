package com.mybasket.app;

import com.mybasket.app.repository.CategoryRepository;
import com.mybasket.app.repository.UserRepository;
import com.mybasket.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MyBasketApp implements CommandLineRunner {

//    ye to instance hai to static k under nahi hoga
//    @Autowired

    @Autowired
    private UserService userservice;
    @Autowired
    private CategoryRepository categoryRepository;
   @Autowired
   private UserRepository userRepository;

//   @Autowired
//   @private ProductService productService;

    public static void main(String[] args) {
		SpringApplication.run(MyBasketApp.class, args);

	}

    @Override
    public void run(String... args) throws Exception {
        System.out.println("app started");


//      var product = new Product();
//      product.setTitle("iphone 17 pro max");
//      product.setPrice(150000);
//      product.setDescription("it the it very best product in the world");
//      product.setShort_description("nyc product no one can bit this product");
//      product.setLive(true);
//      product.setOutofStock(true);
//      productRepository.save(product);
//        System.out.println("project saved ");


//
//        productRepository.findByProductIdAndTitle(3,"Lays")
//                .ifPresentOrElse(product9 ->{
//                    System.out.println(product9.getTitle()+" : product found : "+product.getPrice());
//                }
//                ,
//                        ()->{
//                            System.out.println("product not found");
//                        });


//        productRepository.getAllProduct().stream().forEach(product9 -> {
//            System.out.println(product9.getTitle());
//        });




//        User user = new User();
//        user.setName("vivan");
//        user.setEmail("vivan@gmail.com");
//        user.setPassword("vivan@1232");
//        user.setUserImageUrl("viv.png");
//
//        userRepository.save(user);
//
//
//        userRepository.findById(1232).ifPresentOrElse(user1 -> {
//             userRepository.delete(user1);
//         },
//                 ()->{
//                     System.out.println("User is already deleted");
//                 });



    }
}
