package com.softsaj.AsaSpring.models;

import java.util.Objects;
import javax.persistence.*;
/**
 *
 * @author Marcos
 */

@Entity
@Table(name = "cinefilo")
public class Cinefilo {

@Id      
private int id;
@Column(nullable = false, unique = true, length = 45)
private String user;
@Column(nullable = false)
     @Column(nullable = false, unique = true, length = 45)
private String email;
@Column(nullable = false, length = 64)
private String nome;
@Column(nullable = true, length = 64)  
private String telefone;
@Column(nullable = true, length = 64)
private String idade;
@Column(nullable = true, length = 64)
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
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.id;
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
        final Cinefilo other = (Cinefilo) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
}
