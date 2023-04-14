package com.example.demo.message.controller;

import com.example.demo.message.controller.form.MessageForm;
import com.example.demo.message.entity.Message;
import com.example.demo.message.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/messages")
public class MessageController {

  final private MessageService messageService;

  @GetMapping("/welcome")
  public String welcome(Model model) {
    model.addAttribute("message", "Hello, Welcome to Spring Boot!");
    return "welcome";
  }

  @GetMapping("/lists")
  public ResponseEntity<List<Message>> getMessages() {
    List<Message> messages = messageService.getMessages();
    return ResponseEntity.ok(messages);
  }

  @PostMapping("")
  public Message saveMessage(@RequestBody MessageForm data) {
    Message saved = messageService.save(data.getText());
    return saved;
  }
}
