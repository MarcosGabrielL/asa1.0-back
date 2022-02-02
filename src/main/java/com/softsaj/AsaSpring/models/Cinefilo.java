/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softsaj.AsaSpring.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author Marcos
 */
@Entity
@Table(name = "cinefilos")
public class Cinefilo {
    
@Id    
private int id;
@Column(nullable = false, unique = true, length = 45)
private String user;
@Column(nullable = false, unique = true, length = 45)
private String email;
@Column(nullable = false)
private String nome;
@Column(nullable = true)    
private String telefone;
@Column(nullable = true)  
private String idade;
@Column(nullable = true)  
private String foto;

    public Cinefilo() {
        super();
    }

    public Cinefilo(int id, String user, String email, String nome, String telefone, String idade, String foto) {
        this.id = id;
        this.user = user;
        this.email = email;
        this.nome = nome;
        this.telefone = telefone;
        this.idade = idade;
        this.foto = foto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
    

}
