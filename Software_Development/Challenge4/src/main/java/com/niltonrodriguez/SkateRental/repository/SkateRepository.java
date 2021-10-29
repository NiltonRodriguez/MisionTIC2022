/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niltonrodriguez.SkateRental.repository;

import com.niltonrodriguez.SkateRental.entity.Skate;
import com.niltonrodriguez.SkateRental.repository.CRUD.SkateCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author niltonrodriguez
 */
@Repository
public class SkateRepository {
    
    @Autowired
    private SkateCrudRepository skateCrudRepository;
    
    public List<Skate> getAll(){
        return (List<Skate>) skateCrudRepository.findAll();
    }
    
    public Optional<Skate> getSkate(int id){
        return skateCrudRepository.findById(id);
    }
    
    public Skate save(Skate skate){
        return skateCrudRepository.save(skate);
    }
    
    public void delete(Skate skate){
        skateCrudRepository.delete(skate);
    }
}
