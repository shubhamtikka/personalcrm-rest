package com.demo.jwtdemo.repo;

import com.demo.jwtdemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository{
    List<User> userList = new ArrayList<>();

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Optional<User> getUserByEmailId(String emailId) {
        Query query = new Query(Criteria.where("emailId").is(emailId));
        User user = mongoTemplate.findOne(query, User.class);
        return Optional.ofNullable(user);
    }

    @Override
    public User addUser(User user) {
        return mongoTemplate.save(user);
    }

    @Override
    public List<User> getAll() {
        return mongoTemplate.findAll(User.class);
    }

    @Override
    public boolean userExists(String emailId) {
        Query query = new Query(Criteria.where("emailId").is(emailId));
        return mongoTemplate.exists(query, User.class);
    }
}
