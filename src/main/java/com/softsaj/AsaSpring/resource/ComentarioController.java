/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softsaj.AsaSpring.resource;

import com.softsaj.AsaSpring.models.Comentario;
import com.softsaj.AsaSpring.services.ComentarioService;
import java.net.URI;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author Marcos
 */
@RestController
@RequestMapping("/comentarios")
public class ComentarioController {
    
     @Autowired
    private ComentarioService vs;
     
     
     //Getting lista de comentarios by videos
      @GetMapping("/movie/{idmovie}")
    public ResponseEntity<List<Comentario>> getComentarioByIdMovie (@PathVariable("idmovie") String idmovie) {
         List<Comentario> comentarios = vs.findAllByIdMovie(idmovie);
       return new ResponseEntity<>(comentarios, HttpStatus.OK);
    }
   
    
    //Getting lista de comentarios by Cinefilo
      @GetMapping("/cinefilo/{idcinefilo}")
    public ResponseEntity<List<Comentario>> getComentarioByIdCinefilo 
        (@PathVariable("idcinefilo") String idcinefilo) {
         List<Comentario> comentarios = vs.findAllByIdCinefilo (idcinefilo);
        return new ResponseEntity<>(comentarios, HttpStatus.OK);
    }
        
    //Getting comentario by id
     @GetMapping("/comentario/{id}")
    public ResponseEntity<Comentario> getComentarioById (@PathVariable("id") Integer id) {
        Comentario comentario = vs.findComentarioById(id);
        return new ResponseEntity<>(comentario, HttpStatus.OK);
    }   
    
    //Add comentario em video By Cinefilo
    //@PostMapping("/comentario/add/{idmovie}/inefilo/{idcinefilo}")
    @PostMapping("/comentario/add/{idmovie}")
    public ResponseEntity<Comentario> addMovie(
            @PathVariable("idmovie") String idmovie, @RequestBody Comentario comentario) {
       
        Comentario newComentario = vs.addComentario(idmovie, comentario);
        URI uri = ServletUriComponentsBuilder.
                fromCurrentRequest().path("/comentario/{id}").buildAndExpand(comentario.getId()).toUri();
        
        return new ResponseEntity<>(newComentario, HttpStatus.CREATED);
    }
    
    //Update comentario por id em video por idvideo
     @PutMapping("/comentario/movie/{idmovie}/update/{id}")
    public ResponseEntity<Comentario> updateComentario(
            @PathVariable("id") Integer id,
            @PathVariable("idmovie") String idmovie,
            @RequestBody Comentario moviedto) {
        Comentario comentario = vs.findComentarioById(id);
        comentario.setAvaliação(moviedto.getAvaliação());
        comentario.setCritica(moviedto.getCritica());
        Comentario updateComentario = vs.updateComentario(comentario);//s
        return new ResponseEntity<>(updateComentario, HttpStatus.OK);
    }
    
    @Transactional
    @DeleteMapping("/comentario/delete/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable("id") Integer id) {
        vs.deleteComentario(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
 
}
