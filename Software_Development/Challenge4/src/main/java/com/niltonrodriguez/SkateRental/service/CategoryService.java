/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niltonrodriguez.SkateRental.service;

import com.niltonrodriguez.SkateRental.entity.Category;
import com.niltonrodriguez.SkateRental.repository.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author niltonrodriguez
 */
@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    public List<Category> getAll(){
        return (List<Category>) categoryRepository.getAll();
    }
        
    public Optional<Category> getCategory(int id){
        return categoryRepository.getCategory(id);
    }
    
    public Category save(Category category){
        if(category.getId() == null){
            return categoryRepository.save(category);
        }
        else{
            Optional<Category> e = categoryRepository.getCategory(category.getId());
            if(e.isEmpty()){
                return categoryRepository.save(category);
            }
            else{
                return category;
            }
        }
    }
    
    public Category update(Category category){
        if(category.getId() != null){
            Optional<Category> e = categoryRepository.getCategory(category.getId());
            if(!e.isEmpty()){
                if(category.getName()!=null){
                    e.get().setName(category.getName());
                }
                if(category.getDescription()!=null){
                    e.get().setDescription(category.getDescription());
                }
                if(category.getSkates()!=null){
                    e.get().setSkates(category.getSkates());
                }
                categoryRepository.save(e.get());
                return e.get();
            }
            else{
                return category;
            }
        }
        else{
            return category;
        }
    }
    
    public boolean delete(int id){
    boolean aBoolean = getCategory(id).map(category -> {
        categoryRepository.delete(category);
        return true;
        }).orElse(aBoolean = false);

    return aBoolean;
    }
}
