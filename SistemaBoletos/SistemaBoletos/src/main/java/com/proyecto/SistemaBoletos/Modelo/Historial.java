package com.proyecto.SistemaBoletos.Modelo;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;

@Entity
@Table(name = "historial")  
public class Historial {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String evento;
    private Date fecha;
    private String usuario;
    
    

    
    public Historial() {
    }



    


    public Historial(int id, String evento, Date fecha, String usuario) {
        this.id = id;
        this.evento = evento;
        this.fecha = fecha;
        this.usuario = usuario;
    }






    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }



    public String getEvento() {
        return evento;
    }



    public void setEvento(String evento) {
        this.evento = evento;
    }



    


    public String getUsuario() {
        return usuario;
    }



    public void setUsuario(String usuario) {
       this.usuario = usuario;
    }






    public Date getFecha() {
        return fecha;
    }






    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    

    

 
  
    


}
