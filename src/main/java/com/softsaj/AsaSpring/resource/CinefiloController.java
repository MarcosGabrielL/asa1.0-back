/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softsaj.AsaSpring.resource;

import com.softsaj.AsaSpring.models.Cinefilo;
import com.softsaj.AsaSpring.services.CinefiloService;
import java.net.URI;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author Marcos
 */
//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/cinefilos")
public class CinefiloController {
    
     @Autowired
    private CinefiloService vs;
     
    @GetMapping
    public ResponseEntity<List<Cinefilo>> getAll() {
        List<Cinefilo> movies =  vs.findAll();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }
    
    //GEt Cinefilo
     @GetMapping("/cinefilo/{id}")
    public ResponseEntity<Cinefilo> getCienfiloById (@PathVariable("id") Long id) {
        Cinefilo cinefilo = vs.findCienfiloById(id);
        return new ResponseEntity<>(cinefilo, HttpStatus.OK);
    }
    
    @PostMapping("/cinefilo/add")
    public ResponseEntity<Cinefilo> addCinefilo(@RequestBody Cinefilo movie) {
       
        Cinefilo newCinefilo = vs.addCinefilo(movie);
        URI uri = ServletUriComponentsBuilder.
                fromCurrentRequest().path("/cinefilo/{id}").buildAndExpand(movie.getId()).toUri();
        
        return new ResponseEntity<>(newCinefilo, HttpStatus.CREATED);
    }
    
    //Update nome,telefone,idade,foto;
    @PutMapping("/cinefilo/update/{id}")
    public ResponseEntity<Cinefilo> updateCinefilo(@PathVariable("id") Long id, @RequestBody Cinefilo newcinefilo) {
        Cinefilo cinefilo = vs.findCienfiloById(id);
      //  cinefilo.setNome(newcinefilo.getNome());
      //  cinefilo.setTelefone(newcinefilo.getTelefone());
//cinefilo.setIdade(newcinefilo.getIdade());
      //  cinefilo.setFoto(newcinefilo.getFoto());
        Cinefilo updateCinefilo = vs.updateCinefilo(cinefilo);//s
        return new ResponseEntity<>(updateCinefilo, HttpStatus.OK);
    }
    
    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCinefilo(@PathVariable("id") Long id) {
        vs.deleteCinefilo(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
