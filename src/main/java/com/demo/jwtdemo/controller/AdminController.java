package com.demo.jwtdemo.controller;

import com.demo.jwtdemo.model.User;
import com.demo.jwtdemo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/admin")
public class AdminController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getAll() {
        return userRepository.getAll();
    }

    @GetMapping()
    public String sayHello() {
        return "Hello!";
    }
}
