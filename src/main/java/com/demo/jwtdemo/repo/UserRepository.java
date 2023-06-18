package com.demo.jwtdemo.repo;

import com.demo.jwtdemo.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface UserRepository {

    public Optional<User> getUserByEmailId(String emailId);

    public User addUser(User user);

    public List<User> getAll();

    public boolean userExists(String username);
}
