/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niltonrodriguez.SkateRental.service;

import com.niltonrodriguez.SkateRental.entity.Reservation;
import com.niltonrodriguez.SkateRental.repository.ReservationRepository;
import java.util.List;
import java.util.Optional;
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
}
