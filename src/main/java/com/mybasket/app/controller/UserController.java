package com.mybasket.app.controller;

import com.mybasket.app.dto.UserDto;
import com.mybasket.app.entity.User;
import com.mybasket.app.repository.UserRepository;
import com.mybasket.app.service.UserService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService2 userService2;

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


//     update
//    ki user hi admin hai aur update admin hi karega
    @PreAuthorize("hasRole('ADMIN')")
    //     update
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Integer userId, @RequestBody UserDto userDto) {
        // Use lowercase 'userService2' (the injected bean), not uppercase 'UserService2'
        UserDto userDto1 = userService2.updateUser(userId, userDto);
        return new ResponseEntity<>(userDto1, HttpStatus.OK);
    }


//   delete
//   ki user hi admin hai aur  delete admin hi karega
     @PreAuthorize("hasRole('ADMIN')")
//   delete
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer userId){
        userService2.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}