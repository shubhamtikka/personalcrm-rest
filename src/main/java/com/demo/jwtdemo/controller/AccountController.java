package com.demo.jwtdemo.controller;

import com.demo.jwtdemo.dto.AuthenticationRequestDto;
import com.demo.jwtdemo.dto.AuthenticationResponse;
import com.demo.jwtdemo.dto.RegisterRequestDto;
import com.demo.jwtdemo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/account")
public class AccountController {
    @Autowired
    AccountService accountService;

    @PostMapping("register")
    public ResponseEntity<?> register(
            @RequestBody RegisterRequestDto registerRequestDto
    ) {
        if (accountService.userExists(registerRequestDto.getEmailId())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User already exists");
        }
        return ResponseEntity.ok(accountService.register(registerRequestDto));
    }

    @PostMapping("login")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequestDto authRequestDto
    ) {
        return ResponseEntity.ok(accountService.authenticate(authRequestDto));
    }
    @GetMapping("sayHello") // To test CORS
    public ResponseEntity<String> authenticate() {
        return ResponseEntity.ok("Hello world!!");
    }


}
