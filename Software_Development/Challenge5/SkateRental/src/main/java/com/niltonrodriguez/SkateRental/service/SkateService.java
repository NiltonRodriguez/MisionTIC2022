/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niltonrodriguez.SkateRental.service;

import com.niltonrodriguez.SkateRental.entity.Skate;
import com.niltonrodriguez.SkateRental.repository.SkateRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author niltonrodriguez
 */
@Service
public class SkateService {
    
    @Autowired
    private SkateRepository skateRepository;
    
    public List<Skate> getAll(){
        return (List<Skate>) skateRepository.getAll();
    }
    
    public Optional<Skate> getSkate(int id){
        return skateRepository.getSkate(id);
    }
    
    public Skate save(Skate skate){
        if(skate.getId() == null){
            return skateRepository.save(skate);
        }
        else{
            Optional<Skate> e = skateRepository.getSkate(skate.getId());
            if(e.isEmpty()){
                return skateRepository.save(skate);
            }
            else{
                return skate;
            }
        }
    }
    
    public Skate update(Skate skate){
        if(skate.getId() != null){
            Optional<Skate> e = skateRepository.getSkate(skate.getId());
            if(!e.isEmpty()){
                if(skate.getName()!=null){
                    e.get().setName(skate.getName());
                }
                if(skate.getBrand()!=null){
                    e.get().setBrand(skate.getBrand());
                }
                if(skate.getYear()!=null){
                    e.get().setYear(skate.getYear());
                }
                if(skate.getDescription()!=null){
                    e.get().setDescription(skate.getDescription());
                }
                if(skate.getCategory()!=null){
                    e.get().setCategory(skate.getCategory());
                }
                skateRepository.save(e.get());
                return e.get();
            }
            else{
                return skate;
            }
        }
        else{
            return skate;
        }
    }
    
    public boolean delete(int id){
        boolean aBoolean = getSkate(id).map(skate -> {
            skateRepository.delete(skate);
            return true;
        }).orElse(aBoolean = false);
        
        return aBoolean;
    }
}
