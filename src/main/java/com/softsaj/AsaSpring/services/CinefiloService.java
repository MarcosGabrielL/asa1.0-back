/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softsaj.AsaSpring.services;

import com.softsaj.AsaSpring.exception.UserNotFoundException;
import com.softsaj.AsaSpring.models.Cinefilo;
import com.softsaj.AsaSpring.repositories.CinefiloRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Marcos
 */
@Service
public class CinefiloService {
    
    @Autowired
    private CinefiloRepository rp;
    
     public List<Cinefilo> findAll() {
        return rp.findAll();
    }
     
     public Cinefilo findCienfiloById(Integer id) {
        return rp.findCinefiloById(id)
                .orElseThrow(() -> new UserNotFoundException("Cinefilo by id " + id + " was not found"));
    }
     
     public Cinefilo addCinefilo(Cinefilo cinefilo) {
        return rp.save(cinefilo);
    }
     
      public Cinefilo updateCinefilo(Cinefilo cinefilo) {
        return rp.save(cinefilo);
    }
      
      public void deleteCinefilo(Integer id){
        try{
          rp.deleteCinefiloById(id);  
        }catch(DataIntegrityViolationException e){
            throw new DataIntegrityViolationException(
                    "Não foi possivel deletar o Cinefilo");
        }
    }
}
