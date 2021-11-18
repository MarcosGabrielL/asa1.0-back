/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softsaj.AsaSpring.repositories;


import com.softsaj.AsaSpring.models.Comentario;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Marcos
 */
@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Integer>{

    //@Query("SELECT u FROM Comentario u WHERE u.idmovie = ?1")
    public List<Comentario> findAllByIdmovie(String idmovie);
    //@Query("SELECT u FROM Comentario u WHERE u.idcinefilo = ?1")
    public List<Comentario> findAllByIdcinefilo(String idcinefilo);
    
    Optional<Comentario> findComentarioById(Integer id);
    
    void deleteComentarioById(Integer id);
    
}