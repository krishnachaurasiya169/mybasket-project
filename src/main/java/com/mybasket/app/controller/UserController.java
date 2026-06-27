package com.mybasket.app.controller;

import com.mybasket.app.entity.User;
import com.mybasket.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;




@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/get")
    @ResponseBody
    public List<User> getUsers() {
        System.out.println("getting user");
//        List<String> users = List.of("ankit","saurabh","kamal");
//        User user = new User();
//        user.setEmail("test@gamil.com");
//        user.setName("test user");
//        user.setUserId(23432);
//        user.setUserImageUrl("abc.png");

        return userRepository.findAll();
    }

}