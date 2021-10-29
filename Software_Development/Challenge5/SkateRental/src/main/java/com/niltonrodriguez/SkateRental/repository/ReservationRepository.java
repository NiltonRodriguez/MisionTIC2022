/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niltonrodriguez.SkateRental.repository;

import com.niltonrodriguez.SkateRental.entity.Client;
import com.niltonrodriguez.SkateRental.entity.Reservation;
import com.niltonrodriguez.SkateRental.entity.custom.ClientsCount;
import com.niltonrodriguez.SkateRental.repository.CRUD.ReservationCrudRepository;
import com.niltonrodriguez.SkateRental.repository.CRUD.ReservationJpaRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/**
 *
 * @author niltonrodriguez
 */
@Repository
public class ReservationRepository {
    
    @Autowired
    private ReservationCrudRepository reservationCrudRepository;
    
    @Autowired
    private ReservationJpaRepository jpaRepository;
    
    public List<Reservation> getAll(){
        return (List<Reservation>) reservationCrudRepository.findAll();
    }
    
    public Optional<Reservation> getReservation(int id){
        return reservationCrudRepository.findById(id);
    }
    
    public Reservation save(Reservation reservation){
        return reservationCrudRepository.save(reservation);
    }
    
    public void delete(Reservation reservation){
        reservationCrudRepository.delete(reservation);
    }
    
    /* Get reservations for a date range */
    public List<Reservation> getByDates(Date start, Date end){
        return jpaRepository.findByStartDateBetween(start, end);
    }
    
    /* Get the compairson or reservations between status*/
    public List<Reservation> getReservationsByStatus(String status){
        return jpaRepository.findAllByStatus(status);
    }

    /* Get the clients and the total of reservations per client */   
    public List<Object[]> countByClient(){
        return jpaRepository.totalReserveByClient();
    }
}
