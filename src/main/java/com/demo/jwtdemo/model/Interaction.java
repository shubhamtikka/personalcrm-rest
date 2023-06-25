package com.demo.jwtdemo.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@Document("Interactions")
public class Interaction {

    @Id
    private String contactId;
    private LocalDateTime dateTime;
    private String interactionSummery;
}
