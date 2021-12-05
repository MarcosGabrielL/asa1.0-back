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

import org.joda.time.DateTime;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.joda.time.*;
import org.joda.time.Seconds;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;
import org.joda.time.Months;
import org.joda.time.Hours;
import org.joda.time.DateTime;
import org.joda.time.Days;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

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
 
    
    @GetMapping("/util/TempoDecorrido/{horacomentad}")
    public ResponseEntity<String> getTempoDecorrido (@PathVariable("horacomentad") String horacomentad) {
        
        Locale locale = new Locale("pt","BR");
        SimpleDateFormat formattime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale);
        DateTime date = null;
        String tempo = new String();
        Period period = new Period();
        PeriodFormatter formatter = new PeriodFormatterBuilder().toFormatter();
            try{
                date = new DateTime(formattime.parse(horacomentad));
            }catch(Exception e){
                
            }finally{
                DateTime agora = new DateTime(new Date());

        
        
        period = new Period(date, agora);
        formatter = new PeriodFormatterBuilder().toFormatter();
        if(period.getYears()>0){
            if(period.getYears()==1){
                formatter = new PeriodFormatterBuilder()
                    .appendYears().appendSuffix(" Ano atrás").toFormatter();
            }else{
                formatter = new PeriodFormatterBuilder()
                    .appendYears().appendSuffix(" Anos atrás").toFormatter();
            }
        }else{
            if(period.getMonths()>0){
                if(period.getMonths()==1){
                formatter = new PeriodFormatterBuilder()
                    .appendMonths().appendSuffix(" Mês atrás").toFormatter();
            }else{
                formatter = new PeriodFormatterBuilder()
                    .appendMonths().appendSuffix(" Meses atrás").toFormatter();
            }
            }else{
                if(period.getDays()>0){
                    if(period.getDays()==1){
                formatter = new PeriodFormatterBuilder()
                    .appendDays().appendSuffix(" Dia atrás").toFormatter();
            }else{
                formatter = new PeriodFormatterBuilder()
                    .appendDays().appendSuffix(" Dias atrás").toFormatter();
            }
                }else{
                    if(period.getHours()>0){
                        if(period.getHours()==1){
                            formatter = new PeriodFormatterBuilder()
                                .appendHours().appendSuffix(" Hora atrás").toFormatter();
                        }else{
                            formatter = new PeriodFormatterBuilder()
                                .appendHours().appendSuffix(" Horas atrás").toFormatter();
                        }
                    }else{
                        if(period.getMinutes()>0){
                            if(period.getMinutes()==1){
                            formatter = new PeriodFormatterBuilder()
                                .appendMinutes().appendSuffix(" Minuto atrás").toFormatter();
                        }else{
                            formatter = new PeriodFormatterBuilder()
                                .appendMinutes().appendSuffix(" Minutos atrás").toFormatter();
                        }
                        }else{
                            if(period.getMillis()>0){
                                formatter = new PeriodFormatterBuilder()
                                .appendLiteral(" Agora Mesmo").toFormatter();
                            }else{
                                tempo = "?";
                            }
                        }
                    }
                }
            }
        }
 }  
    tempo = formatter.print(period);
         
                        
        return new ResponseEntity<>(tempo, HttpStatus.OK);
    } 


     @GetMapping("/util/HoraServidor")
    public ResponseEntity<String> getTempoDecorrido () {
        // Pega data/hora atual
        LocalDateTime agora = LocalDateTime.now();
        // formata a data
        DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String dataFormatada = formatterData.format(agora);
     return new ResponseEntity<>(dataFormatada, HttpStatus.OK);
    } 
}
