package com.infotitans.dailydevotional.business.service;

import com.infotitans.dailydevotional.data.entity.Author;
import com.infotitans.dailydevotional.data.entity.Message;
import com.infotitans.dailydevotional.data.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<Message> getAllMessages(){
        List<Message>messages = new ArrayList<>();
        this.messageRepository.findAll().forEach(messages::add);
        return messages;
    }

    public Optional<Message> findMessageById(Long messageId){
        return messageRepository.findById(messageId);
    }

    public Message addNewMessage(Message message){
        return messageRepository.save(message);
    }
}
