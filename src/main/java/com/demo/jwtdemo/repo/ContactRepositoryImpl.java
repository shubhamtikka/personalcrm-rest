package com.demo.jwtdemo.repo;

import com.demo.jwtdemo.model.Contact;
import com.demo.jwtdemo.model.Interaction;
import com.demo.jwtdemo.model.User;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ContactRepositoryImpl implements ContactRepository{
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public UpdateResult addOrUpdateContact(String userId, Contact contact) {
        Query query = new Query(Criteria.where("_id").is(userId));
        Update update = new Update().push("contacts", contact);
        return mongoTemplate.updateFirst(query, update, User.class);
    }

    @Override
    public List<Contact> getContacts(String userId) {
        Query query = new Query(Criteria.where("_id").is(userId));
        query.fields().include("contacts");
        User user = mongoTemplate.findOne(query, User.class);
        return user != null ? user.getContacts() : new ArrayList<>();
    }

    @Override
    public UpdateResult addInteraction(String contactId, Interaction interaction) {
        Query query = new Query(Criteria.where("contacts._id").is(contactId));
        Update update = new Update().push("contacts.$.interactions", interaction);
        return mongoTemplate.updateFirst(query, update, User.class);
    }

    @Override
    public List<Interaction> getInteractions(String contactId) {  Query query = new Query(Criteria.where("contacts._id").is(contactId));
        query.fields().include("contacts.$");
        Contact contact = mongoTemplate.findOne(query, Contact.class);
        if (contact != null) {
            return contact.getInteractions();
        }
        return new ArrayList<>();
    }
}
