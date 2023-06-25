package com.demo.jwtdemo.repo;

import com.demo.jwtdemo.model.Contact;
import com.demo.jwtdemo.model.Interaction;
import com.mongodb.client.result.UpdateResult;

import java.util.List;

public interface ContactRepository {

    public UpdateResult addOrUpdateContact(String userId, Contact contact);

    public List<Contact> getContacts(String userId);

    public UpdateResult addInteraction(String contactId, Interaction interaction);

    public List<Interaction> getInteractions(String contactId);

}
