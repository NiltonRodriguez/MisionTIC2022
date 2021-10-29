/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niltonrodriguez.SkateRental.service;

import com.niltonrodriguez.SkateRental.entity.Message;
import com.niltonrodriguez.SkateRental.repository.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author niltonrodriguez
 */
@Service
public class MessageService {
    
    @Autowired
    private MessageRepository messageRepository;
    
    public List<Message> getAll(){
        return (List<Message>) messageRepository.getAll();
    }
        
    public Optional<Message> getMessage(int id){
        return messageRepository.getMessage(id);
    }
    
    public Message save(Message message){
        if(message.getIdMessage()== null){
            return messageRepository.save(message);
        }
        else{
            Optional<Message> e = messageRepository.getMessage(message.getIdMessage());
            if(e.isEmpty()){
                return messageRepository.save(message);
            }
            else{
                return message;
            }
        }
    }
    
    public Message update(Message message){
        if(message.getIdMessage()!= null){
            Optional<Message> e = messageRepository.getMessage(message.getIdMessage());
            if(!e.isEmpty()){
                if(message.getMessageText()!=null){
                    e.get().setMessageText(message.getMessageText());
                }
                if(message.getClient()!=null){
                    e.get().setClient(message.getClient());
                }
                if(message.getSkate()!=null){
                    e.get().setSkate(message.getSkate());
                }
                messageRepository.save(e.get());
                return e.get();
            }
            else{
                return message;
            }
        }
        else{
            return message;
        }
    }
    
    public boolean delete(int id){
        boolean aBoolean = getMessage(id).map(message -> {
            messageRepository.delete(message);
            return true;
        }).orElse(aBoolean = false);

        return aBoolean;
    }
}
