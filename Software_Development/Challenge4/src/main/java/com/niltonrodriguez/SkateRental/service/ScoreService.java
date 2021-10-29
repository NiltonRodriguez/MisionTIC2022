/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niltonrodriguez.SkateRental.service;

import com.niltonrodriguez.SkateRental.entity.Score;
import com.niltonrodriguez.SkateRental.repository.ScoreRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author niltonrodriguez
 */
@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;
    
    public List<Score> getAll(){
        return (List<Score>) scoreRepository.getAll();
    }
        
    public Optional<Score> getScore(int id){
        return scoreRepository.getScore(id);
    }
    
    public Score save(Score message){
        if(message.getIdScore()== null){
            return scoreRepository.save(message);
        }
        else{
            Optional<Score> e = scoreRepository.getScore(message.getIdScore());
            if(e.isEmpty()){
                return scoreRepository.save(message);
            }
            else{
                return message;
            }
        }
    }
    
    public Score update(Score score){
        if(score.getIdScore()!= null){
            Optional<Score> e = scoreRepository.getScore(score.getIdScore());
            if(!e.isEmpty()){
                if(score.getScore()!=null){
                    e.get().setScore(score.getScore());
                }
                if(score.getMessage()!=null){
                    e.get().setMessage(score.getMessage());
                }
                if(score.getReservation()!=null){
                    e.get().setReservation(score.getReservation());
                }
                scoreRepository.save(e.get());
                return e.get();
            }
            else{
                return score;
            }
        }
        else{
            return score;
        }
    }
    
    public boolean delete(int id){
    boolean aBoolean = getScore(id).map(score -> {
        scoreRepository.delete(score);
        return true;
    }).orElse(aBoolean = false);

    return aBoolean;
    }
}
