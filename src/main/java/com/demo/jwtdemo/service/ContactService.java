package com.demo.jwtdemo.service;

import com.demo.jwtdemo.model.Contact;
import com.demo.jwtdemo.model.Interaction;

import java.util.List;
import java.util.Optional;

public interface ContactService {
    public Boolean addOrUpdateContact(String userId, Contact contact);

    public Optional<List<Contact>> getContacts(String userId);

    public Boolean addInteraction(String contactId, Interaction interaction);

    public Optional<List<Interaction>> getInteractions(String contactId);


}
