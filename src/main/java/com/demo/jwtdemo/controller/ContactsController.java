package com.demo.jwtdemo.controller;

import com.demo.jwtdemo.model.Contact;
import com.demo.jwtdemo.model.Interaction;
import com.demo.jwtdemo.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/{userId}/contacts")
public class ContactsController {

    @Autowired
    ContactService contactService;

    @PutMapping
    public ResponseEntity<Boolean> addContact (
            @PathVariable String userId,
            @RequestBody Contact contact
    ) {
        boolean result = contactService.addOrUpdateContact(userId, contact);
        return ResponseEntity.ok(result);
    }

    @GetMapping
    public ResponseEntity<List<Contact>> getContacts (
            @PathVariable String userId
    ) {
        Optional<List<Contact>> contacts = contactService.getContacts(userId);
        if(contacts.isPresent()) {
            return ResponseEntity.ok(contacts.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("{contactId}/interactions")
    public ResponseEntity<Boolean> addInteraction (
            @PathVariable String contactId,
            @RequestBody Interaction interaction
            ) {
        Boolean result = contactService.addInteraction(contactId, interaction);
        return ResponseEntity.ok(result);
    }

    @GetMapping("{contactId}/interactions")
    public ResponseEntity<List<Interaction>>  getInteractions (
            @PathVariable String contactId
    ) {
        Optional<List<Interaction>> interactions = contactService.getInteractions(contactId);

        if(interactions.isPresent()) {
            return ResponseEntity.ok(interactions.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
