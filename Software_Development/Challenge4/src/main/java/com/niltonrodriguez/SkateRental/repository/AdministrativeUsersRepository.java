/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niltonrodriguez.SkateRental.repository;

import com.niltonrodriguez.SkateRental.entity.AdministrativeUsers;
import com.niltonrodriguez.SkateRental.repository.CRUD.AdministrativeUsersCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/**
 *
 * @author niltonrodriguez
 */
@Repository
public class AdministrativeUsersRepository {
    @Autowired
    private AdministrativeUsersCrudRepository adminCrudRepository;
    
    public List<AdministrativeUsers> getAll(){
        return (List<AdministrativeUsers>) adminCrudRepository.findAll();
    }
    
    public Optional<AdministrativeUsers> getAdmin(int id){
        return adminCrudRepository.findById(id);
    }
    
    public AdministrativeUsers save(AdministrativeUsers admin){
        return adminCrudRepository.save(admin);
    }
    
    public void delete(AdministrativeUsers admin){
        adminCrudRepository.delete(admin);
    }
}
