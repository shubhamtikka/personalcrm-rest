package com.demo.jwtdemo.service;

import com.demo.jwtdemo.model.Contact;
import com.demo.jwtdemo.model.Interaction;
import com.demo.jwtdemo.repo.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService{

    @Autowired
    ContactRepository contactRepository;

    @Override
    public Boolean addOrUpdateContact(String userId, Contact contact) {
        return contactRepository.addOrUpdateContact(userId, contact).wasAcknowledged();
    }


    @Override
    public Optional<List<Contact>> getContacts(String userId) {
        return Optional.ofNullable(contactRepository.getContacts(userId));
    }



    @Override
    public Boolean addInteraction(String contactId, Interaction interaction) {
        if(interaction.getDateTime() == null) {
            interaction.setDateTime(LocalDateTime.now());
        }
        return contactRepository.addInteraction(contactId, interaction).wasAcknowledged();
    }

    @Override
    public Optional<List<Interaction>> getInteractions(String contactId) {
        return Optional.ofNullable(contactRepository.getInteractions(contactId));
    }
}
