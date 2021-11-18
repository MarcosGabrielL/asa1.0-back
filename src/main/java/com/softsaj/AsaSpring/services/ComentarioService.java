/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softsaj.AsaSpring.services;

import com.softsaj.AsaSpring.exception.UserNotFoundException;
import com.softsaj.AsaSpring.models.Comentario;
import com.softsaj.AsaSpring.repositories.ComentarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Marcos
 */
@Service
public class ComentarioService {
    
    @Autowired
    private ComentarioRepository rp;
    
    public List<Comentario> findAllByIdMovie(String id_movie) {
        return rp.findAllByIdmovie(id_movie);
    }
    
    public List<Comentario> findAllByIdCinefilo (String idcinefilo) {
        return rp.findAllByIdcinefilo(idcinefilo);
    }
    
     public Comentario findComentarioById(Integer id) {
        return rp.findComentarioById(id)
                .orElseThrow(() -> new UserNotFoundException("Comentario by id " + id + " was not found"));
    }
     
     public Comentario addComentario(String idmovie, Comentario comentario) {
         
        comentario.setIdmovie(idmovie);
        return rp.save(comentario);
    }
     
     public Comentario updateComentario(Comentario comentario) {
        return rp.save(comentario);
    }
     
      public void deleteComentario(Integer id){
        try{
          rp.deleteComentarioById(id);  
        }catch(DataIntegrityViolationException e){
            throw new DataIntegrityViolationException(
                    "Não foi possivel deletar o Comentario");
        }
    }
}
