package com.mybasket.app.controller;

import com.mybasket.app.dto.UserDto;
import com.mybasket.app.entity.User;
import com.mybasket.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/get")
    public List<User> getUsers() {
        System.out.println("getting user");
//        List<String> users = List.of("ankit","saurabh","kamal");
//        User user = new User();
//        user.setEmail("test@gamil.com");
//        user.setName("test user");
//        user.setUserId(23432);
//        user.setUserImageUrl("abc.png");
         return userRepository.  findAll();
    }

    @PutMapping
    public ResponseEntity<UserDto> updateUser(@PathVariable Integer userId , @ResponseBody){

    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer userId){

    }

}