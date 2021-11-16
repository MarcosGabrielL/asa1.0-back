/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softsaj.AsaSpring.repositories;

import com.softsaj.AsaSpring.models.Movie;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Marcos
 */
@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer>{
    
    Optional<Movie> findMovieById(Integer id);
    
    void deleteMovieById(Integer id);
}
