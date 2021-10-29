/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niltonrodriguez.SkateRental.repository.CRUD;

import com.niltonrodriguez.SkateRental.entity.Reservation;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author niltonrodriguez
 */
public interface ReservationJpaRepository extends JpaRepository<Reservation, Serializable>{
    
    /* Get the total of reservations in a date range*/
    List<Reservation> findByStartDateBetween(Date start, Date end);
    
    /* Get the count of reservations for each status */
    List<Reservation> findAllByStatus(String Status);
    
    /* Get each client and the count of its reservations */
    @Query("SELECT r.client, COUNT(r.client) AS total FROM Reservation r" +
            " GROUP BY r.client ORDER BY total DESC")
    List<Object[]> totalReserveByClient();
}
