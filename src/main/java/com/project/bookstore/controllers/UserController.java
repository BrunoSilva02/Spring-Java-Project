package com.project.bookstore.controllers;

import com.project.bookstore.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:8080/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<Object> getUsers(){
        System.out.println("users");
        return userService.getUsers();
    }



    @GetMapping("/test")
    public void test(){
        System.out.println("test");
        userService.test();
    }
}
