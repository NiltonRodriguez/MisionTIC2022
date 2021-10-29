/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niltonrodriguez.SkateRental.controller;

import com.niltonrodriguez.SkateRental.entity.AdministrativeUsers;
import com.niltonrodriguez.SkateRental.service.AdministrativeUsersService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author niltonrodriguez
 */
@RestController
@RequestMapping("/api/Admin")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST,
            RequestMethod.PUT, RequestMethod.DELETE})
public class AdministrativeUsersController {
    
    @Autowired
    private AdministrativeUsersService adminService;
    
    @GetMapping("/all")
    public List<AdministrativeUsers> getAdmin(){
        return adminService.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<AdministrativeUsers> getAdmin(@PathVariable("id") int id){
        return adminService.getAdmin(id);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public AdministrativeUsers save(@RequestBody AdministrativeUsers admin){
        return adminService.save(admin);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public AdministrativeUsers update(@RequestBody AdministrativeUsers admin){
        return adminService.update(admin);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return adminService.delete(id);
    }
}
