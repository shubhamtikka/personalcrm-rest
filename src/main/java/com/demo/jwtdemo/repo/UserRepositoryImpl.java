package com.demo.jwtdemo.repo;

import com.demo.jwtdemo.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository{
    List<User> userList = new ArrayList<>();
    @Override
    public Optional<User> getUserByEmailId(String emailId) {
        return userList.stream().filter(user -> user.getEmailId().equals(emailId)).findFirst();
    }

    @Override
    public User addUser(User user) {
        userList.add(user);
        return user;
    }

    @Override
    public List<User> getAll() {
        return userList;
    }

    @Override
    public boolean userExists(String username) {
        return userList.stream().filter(user -> user.getUsername().equals(username)).findFirst().isPresent();
    }
}
