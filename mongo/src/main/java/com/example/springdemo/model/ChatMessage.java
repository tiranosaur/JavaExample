package com.example.springdemo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document("chat_message")
public class ChatMessage {
    @Id
    @Field(name = "_id")
    private String id;
    @Field(name = "msg")
    private String message;
}
