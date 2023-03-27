package com.demo.jwtdemo.service;

import com.demo.jwtdemo.dto.AuthenticationRequestDto;
import com.demo.jwtdemo.dto.AuthenticationResponse;
import com.demo.jwtdemo.dto.RegisterRequestDto;
import com.demo.jwtdemo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService extends UserDetailsService {

}
