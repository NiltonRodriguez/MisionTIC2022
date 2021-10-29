/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niltonrodriguez.SkateRental.service;

import com.niltonrodriguez.SkateRental.entity.AdministrativeUsers;
import com.niltonrodriguez.SkateRental.repository.AdministrativeUsersRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author niltonrodriguez
 */
@Service
public class AdministrativeUsersService {
    
    @Autowired
    private AdministrativeUsersRepository adminRepository;
    
    public List<AdministrativeUsers> getAll(){
        return (List<AdministrativeUsers>) adminRepository.getAll();
    }
    
    public Optional<AdministrativeUsers> getAdmin(int id){
        return adminRepository.getAdmin(id);
    }
    
    public AdministrativeUsers save(AdministrativeUsers admin){
        if(admin.getIdUser()== null){
            return adminRepository.save(admin);
        }
        else{
            Optional<AdministrativeUsers> e = adminRepository.getAdmin(admin.getIdUser());
            if(e.isEmpty()){
                return adminRepository.save(admin);
            }
            else{
                return admin;
            }
        }
    }
    
    public AdministrativeUsers update(AdministrativeUsers admin){
        if(admin.getIdUser()!= null){
            Optional<AdministrativeUsers> e = adminRepository.getAdmin(admin.getIdUser());
            if(!e.isEmpty()){
                if(admin.getName()!=null){
                    e.get().setName(admin.getName());
                }
                if(admin.getPassword()!=null){
                    e.get().setPassword(admin.getPassword());
                }
                if(admin.getEmail()!=null){
                    e.get().setEmail(admin.getEmail());
                }
                adminRepository.save(e.get());
                return e.get();
            }
            else{
                return admin;
            }
        }
        else{
            return admin;
        }
    }
    
    public boolean delete(int id){
        boolean aBoolean = getAdmin(id).map(admin -> {
            adminRepository.delete(admin);
            return true;
        }).orElse(aBoolean = false);
        
        return aBoolean;
    }
}
