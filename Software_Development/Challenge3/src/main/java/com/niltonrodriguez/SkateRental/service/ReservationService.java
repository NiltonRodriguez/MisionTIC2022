/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niltonrodriguez.SkateRental.service;

import com.niltonrodriguez.SkateRental.entity.Client;
import com.niltonrodriguez.SkateRental.entity.Reservation;
import com.niltonrodriguez.SkateRental.entity.custom.ClientsCount;
import com.niltonrodriguez.SkateRental.entity.custom.StatusCount;
import com.niltonrodriguez.SkateRental.repository.ReservationRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author niltonrodriguez
 */
@Service
public class ReservationService {
    
    @Autowired
    private ReservationRepository reservationRepository;
    
    public List<Reservation> getAll(){
        return (List<Reservation>) reservationRepository.getAll();
    }
        
    public Optional<Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);
    }
    
    public Reservation save(Reservation message){
        if(message.getIdReservation()== null){
            return reservationRepository.save(message);
        }
        else{
            Optional<Reservation> e = reservationRepository.getReservation(
                    message.getIdReservation());
            if(e.isEmpty()){
                return reservationRepository.save(message);
            }
            else{
                return message;
            }
        }
    }
    
    public Reservation update(Reservation reservation){
        if(reservation.getIdReservation()!= null){
            Optional<Reservation> e = reservationRepository.getReservation(
                    reservation.getIdReservation());
            if(!e.isEmpty()){
                if(reservation.getStartDate()!=null){
                    e.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    e.get().setStatus(reservation.getStatus());
                }
                if(reservation.getClient()!=null){
                    e.get().setClient(reservation.getClient());
                }
                if(reservation.getSkate()!=null){
                    e.get().setSkate(reservation.getSkate());
                }
                if(reservation.getScore()!=null){
                    e.get().setScore(reservation.getScore());
                }
                reservationRepository.save(e.get());
                return e.get();
            }
            else{
                return reservation;
            }
        }
        else{
            return reservation;
        }
    }
    
    public boolean delete(int id){
        boolean aBoolean = getReservation(id).map(reservation -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse(aBoolean = false);

        return aBoolean;
    }
    
    /* Function to get the reservations in a date range*/
    public List<Reservation> getByDates(String start, String end) throws ParseException{
        Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(start);
        Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(end);
        return (List<Reservation>) reservationRepository.getByDates(date1, date2);
    }
    
    /* Function to get the count of the completed and cancelled status */
    public StatusCount getStatusCount(){
        List<Reservation> completed = reservationRepository.getReservationsByStatus("completed");
        List<Reservation> cancelled = reservationRepository.getReservationsByStatus("cancelled");
        StatusCount count = new StatusCount(completed.size(), cancelled.size());
        return count;
    }
    
    /* Generate the list of top clients */
    public List<ClientsCount> countByClient(){
        /*return reservationRepository.countByClient();*/
        List<ClientsCount> clientCount = new ArrayList<>();
        List<Object[]> results = reservationRepository.countByClient();
        for(Object[] object: results){
            Client client = (Client) object[0];
            Long total = (Long) object[1];
            ClientsCount new_count = new ClientsCount(total, client);
            clientCount.add(new_count);
        }
        return clientCount;
    }
    
}
