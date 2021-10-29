/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niltonrodriguez.SkateRental.service;

import com.niltonrodriguez.SkateRental.entity.Client;
import com.niltonrodriguez.SkateRental.repository.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author niltonrodriguez
 */
@Service
public class ClientService {
    
    @Autowired
    private ClientRepository clientRepository;
    
    public List<Client> getAll(){
        return (List<Client>) clientRepository.getAll();
    }
        
    public Optional<Client> getClient(int id){
        return clientRepository.getClient(id);
    }
    
    public Client save(Client client){
        if(client.getIdClient()== null){
            return clientRepository.save(client);
        }
        else{
            Optional<Client> e = clientRepository.getClient(client.getIdClient());
            if(e.isEmpty()){
                return clientRepository.save(client);
            }
            else{
                return client;
            }
        }
    }
    
    public Client update(Client client){
        if(client.getIdClient()!= null){
            Optional<Client> e = clientRepository.getClient(client.getIdClient());
            if(!e.isEmpty()){
                if(client.getEmail()!=null){
                    e.get().setEmail(client.getEmail());
                }
                if(client.getPassword()!=null){
                    e.get().setPassword(client.getPassword());
                }
                if(client.getName()!=null){
                    e.get().setName(client.getName());
                }
                if(client.getAge()!=null){
                    e.get().setAge(client.getAge());
                }
                clientRepository.save(e.get());
                return e.get();
            }
            else{
                return client;
            }
        }
        else{
            return client;
        }
    }
    
    public boolean delete(int id){
        boolean aBoolean = getClient(id).map(client -> {
            clientRepository.delete(client);
            return true;
        }).orElse(aBoolean = false);
        
        return aBoolean;
    }
}
