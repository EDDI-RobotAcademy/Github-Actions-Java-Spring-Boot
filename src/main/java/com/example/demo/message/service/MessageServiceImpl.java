package com.example.demo.message.service;

import com.example.demo.aspect.SecurityCheck;
import com.example.demo.message.entity.Message;
import com.example.demo.message.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

  final private MessageRepository repository;
  //final private PlatformTransactionManager transactionManager;

  @Transactional(readOnly = true)
  public List<Message> getMessages() {
    return repository.findAll();
  }

  @SecurityCheck
  //@Transactional(noRollbackFor = UnsupportedOperationException.class)
  public Message save(String text) {

    Message message = repository.save(new Message(text));

    //log.info("message[id={}] saved", message.getId());
    updateLog();
    //log.info("message service result: " + message);

    return message;
  }

  private void updateLog() {
    throw new UnsupportedOperationException("Not Implementation!");
  }
}
