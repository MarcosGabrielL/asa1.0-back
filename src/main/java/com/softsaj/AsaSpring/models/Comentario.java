/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softsaj.AsaSpring.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
/**
 *
 * @author Marcos
 */
@Entity
public class Comentario implements Serializable {
    
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)    
private int id;
@Column(nullable = false)
private String critica;
@Column(nullable = false)
private String id_movie;
@Column(nullable = false)
private String ID_Cinefilo;
@Column(nullable = false)
private String Data;
@Column(nullable = false)
private String Avaliação;
private String curtidas_1_estrela;
private String curtidas_2_estrela;
private String curtidas_3_estrela;
private String curtidas_4_estrela;
private String curtidas_5_estrela;
private String score;

    public Comentario() {
        super();
    }
    
    public Comentario(int id, String critica, String id_movie, String ID_Cinefilo, String Data, String Avaliação, String curtidas_1_estrela, String curtidas_2_estrela, String curtidas_3_estrela, String curtidas_4_estrela, String curtidas_5_estrela, String score) {
        this.id = id;
        this.critica = critica;
        this.id_movie = id_movie;
        this.ID_Cinefilo = ID_Cinefilo;
        this.Data = Data;
        this.Avaliação = Avaliação;
        this.curtidas_1_estrela = curtidas_1_estrela;
        this.curtidas_2_estrela = curtidas_2_estrela;
        this.curtidas_3_estrela = curtidas_3_estrela;
        this.curtidas_4_estrela = curtidas_4_estrela;
        this.curtidas_5_estrela = curtidas_5_estrela;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCritica() {
        return critica;
    }

    public void setCritica(String critica) {
        this.critica = critica;
    }

    public String getId_movie() {
        return id_movie;
    }

    public void setId_movie(String id_movie) {
        this.id_movie = id_movie;
    }

    public String getID_Cinefilo() {
        return ID_Cinefilo;
    }

    public void setID_Cinefilo(String ID_Cinefilo) {
        this.ID_Cinefilo = ID_Cinefilo;
    }

    public String getData() {
        return Data;
    }

    public void setData(String Data) {
        this.Data = Data;
    }

    public String getAvaliação() {
        return Avaliação;
    }

    public void setAvaliação(String Avaliação) {
        this.Avaliação = Avaliação;
    }

    public String getCurtidas_1_estrela() {
        return curtidas_1_estrela;
    }

    public void setCurtidas_1_estrela(String curtidas_1_estrela) {
        this.curtidas_1_estrela = curtidas_1_estrela;
    }

    public String getCurtidas_2_estrela() {
        return curtidas_2_estrela;
    }

    public void setCurtidas_2_estrela(String curtidas_2_estrela) {
        this.curtidas_2_estrela = curtidas_2_estrela;
    }

    public String getCurtidas_3_estrela() {
        return curtidas_3_estrela;
    }

    public void setCurtidas_3_estrela(String curtidas_3_estrela) {
        this.curtidas_3_estrela = curtidas_3_estrela;
    }

    public String getCurtidas_4_estrela() {
        return curtidas_4_estrela;
    }

    public void setCurtidas_4_estrela(String curtidas_4_estrela) {
        this.curtidas_4_estrela = curtidas_4_estrela;
    }

    public String getCurtidas_5_estrela() {
        return curtidas_5_estrela;
    }

    public void setCurtidas_5_estrela(String curtidas_5_estrela) {
        this.curtidas_5_estrela = curtidas_5_estrela;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Comentario other = (Comentario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
}
