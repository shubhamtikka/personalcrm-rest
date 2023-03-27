package com.demo.jwtdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public class RegisterRequestDto {

        private String firstName;
        private String lastName;
        private String emailId;
        private String password;
    }
