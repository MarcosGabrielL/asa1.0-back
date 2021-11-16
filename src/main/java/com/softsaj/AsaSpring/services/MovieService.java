/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softsaj.AsaSpring.services;

import com.softsaj.AsaSpring.exception.UserNotFoundException;
import com.softsaj.AsaSpring.models.Movie;
import com.softsaj.AsaSpring.repositories.MovieRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Marcos
 */
@Service
public class MovieService {
    
    @Autowired
    private MovieRepository rp;
    
     public List<Movie> findAll() {
        return rp.findAll();
    }
     
      public Movie findMovieById(Integer id) {
        return rp.findMovieById(id)
                .orElseThrow(() -> new UserNotFoundException("Movie by id " + id + " was not found"));
    }
    
      public Movie addMovie(Movie movie) {
           movie.setId(UUID.randomUUID().hashCode());

        return rp.save(movie);
    }
    
    public Movie updateMovie(Movie employee) {
        return rp.save(employee);
    }

    public void deleteMovie(Integer id){
        try{
          rp.deleteMovieById(id);  
        }catch(DataIntegrityViolationException e){
            throw new DataIntegrityViolationException(
                    "Não foi possivel deletar o Filme");
        }
    }
}
