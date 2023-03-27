package com.demo.jwtdemo.service;

import com.demo.jwtdemo.dto.AuthenticationRequestDto;
import com.demo.jwtdemo.dto.AuthenticationResponse;
import com.demo.jwtdemo.dto.RegisterRequestDto;

public interface AccountService {
    public AuthenticationResponse register(RegisterRequestDto registerRequestDto);
    public AuthenticationResponse authenticate(AuthenticationRequestDto authRequestDto);
}
