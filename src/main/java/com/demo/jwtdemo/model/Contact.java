package com.demo.jwtdemo.model;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@Builder
@Document("Contacts")
public class Contact {

    @Id
    private String userId;

    private String name;
    private String contact;
    private String emailId;
    private LocalDate birthDay;
    @DBRef(lazy = true)
    private List<Interaction> interactions;


}
