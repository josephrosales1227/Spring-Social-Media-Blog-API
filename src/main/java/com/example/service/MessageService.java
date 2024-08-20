package com.example.service;
import com.example.repository.MessageRepository;
import com.example.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import javax.transaction.Transactional;
@Service
@Transactional
public class MessageService {
    MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository msgRep) {
        this.messageRepository = msgRep;
    }

    public List<Message> getMessages() {
        return messageRepository.findAll();
    }

    public Message createMessage(Message msg) {
        return messageRepository.save(msg);
    }

    public Message getMessageById(String id) {
        return messageRepository.findMessageByMessageId(Integer.parseInt(id));
    }
    public String deleteMessage(String id) {
        Message msg = messageRepository.findMessageByMessageId(Integer.parseInt(id));
        if(msg != null) {
            messageRepository.delete(msg);
            return "1";
        }
        return "";
    }
    
    public List<Message> getMessagesByAccountId(String accountId) {
        return messageRepository.findMessagesByPostedBy(Integer.parseInt(accountId));
    }

    public String updateMessage(String messageId, Message msg) {
        Message foundMessage = messageRepository.findMessageByMessageId(Integer.parseInt(messageId));
        if(foundMessage != null) {
            foundMessage.setMessageText(msg.getMessageText());
            messageRepository.save(foundMessage);
            return "1";
        }
        return "";
    }
}
