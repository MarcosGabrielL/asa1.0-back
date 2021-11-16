/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softsaj.AsaSpring.resource;

import com.softsaj.AsaSpring.models.Movie;
import com.softsaj.AsaSpring.services.MovieService;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping("/movies")
public class MovieController {
    
     @Autowired
    private MovieService vs;
    
    @GetMapping
    public ResponseEntity<List<Movie>> getAll() {
        List<Movie> movies =  vs.findAll();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }
    
    @GetMapping("/movie/{id}")
    public ResponseEntity<Movie> getMovieById (@PathVariable("id") Integer id) {
        Movie movie = vs.findMovieById(id);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }
    
    @PostMapping("/movie/add")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
       
        Movie newMovie = vs.addMovie(movie);
        URI uri = ServletUriComponentsBuilder.
                fromCurrentRequest().path("/movie/{id}").buildAndExpand(movie.getId()).toUri();
        
        return new ResponseEntity<>(newMovie, HttpStatus.CREATED);
    }

    @PutMapping("/movie/update/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable("id") Integer id, @RequestBody Movie moviedto) {
        Movie movie = vs.findMovieById(id);
        movie.setNo_of_Votes(moviedto.getNo_of_Votes());
        movie.setRate(moviedto.getRate());
        movie.setStar1(moviedto.getStar1());
        movie.setStar2(moviedto.getStar2());
        movie.setStar3(moviedto.getStar3());
        movie.setStar4(moviedto.getStar4());
        movie.setStar5(moviedto.getStar5());
        Movie updateMovie = vs.updateMovie(moviedto);//s
        return new ResponseEntity<>(updateMovie, HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable("id") Integer id) {
        vs.deleteMovie(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
}
