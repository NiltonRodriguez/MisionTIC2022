/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niltonrodriguez.SkateRental.repository.CRUD;

import com.niltonrodriguez.SkateRental.entity.Category;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author niltonrodriguez
 */
public interface CategoryCrudRepository extends CrudRepository<Category, Integer>{
    
}
