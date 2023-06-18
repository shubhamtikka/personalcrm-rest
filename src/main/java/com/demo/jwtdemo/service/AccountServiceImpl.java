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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private  PasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private  AuthenticationManager authenticationManager;
    @Override
    public AuthenticationResponse register(RegisterRequestDto registerRequestDto) {
        User user = User.builder()
                .firstName(registerRequestDto.getFirstName())
                .lastName(registerRequestDto.getLastName())
                .emailId(registerRequestDto.getEmailId())
                .password(passwordEncoder.encode(registerRequestDto.getPassword()))
                .role(Role.USER)
                .build();

        userRepository.addUser(user);
        String jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse
                .builder()
                .token(jwtToken)
                .build();
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequestDto authRequestDto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequestDto.getEmailId(), authRequestDto.getPassword()
                )
        );

        UserDetails user = userRepository.getUserByEmailId(authRequestDto.getEmailId()).get();

        String jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse
                .builder()
                .token(jwtToken)
                .build();
    }

    @Override
    public boolean userExists(String username) {
        return userRepository.userExists(username);
    }
}
