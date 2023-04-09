package com.example.demo.message.service;

import com.example.demo.message.entity.Message;

import java.util.List;

public interface MessageService {
    public List<Message> getMessages();
    public Message save(String text);
}
