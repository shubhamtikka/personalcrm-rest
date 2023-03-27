package com.demo.jwtdemo.service;

import com.demo.jwtdemo.config.JwtService;
import com.demo.jwtdemo.dto.AuthenticationRequestDto;
import com.demo.jwtdemo.dto.AuthenticationResponse;
import com.demo.jwtdemo.dto.RegisterRequestDto;
import com.demo.jwtdemo.model.Role;
import com.demo.jwtdemo.model.User;
import com.demo.jwtdemo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.getUserByEmailId(username).orElseThrow(()->
                new UsernameNotFoundException("Username not found: "+username )
        );
    }


}
