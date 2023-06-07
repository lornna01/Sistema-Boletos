package com.proyecto.SistemaBoletos.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "avion")  
public class Avion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String capacidad;
    private String nombre_avion;
    private String nombre_modelo;
    

    // Constructor vacío
    public Avion() {
    }

    // Constructor normal
    public Avion(int id, String capacidad, String nombre_avion, String nombre_modelo) {
        this.id = id;
        this.capacidad = capacidad;
        this.nombre_avion = nombre_avion;
        this.nombre_modelo = nombre_modelo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    public String getNombre_avion() {
        return nombre_avion;
    }

    public void setNombre_avion(String nombre_avion) {
        this.nombre_avion = nombre_avion;
    }

    public String getNombre_modelo() {
        return nombre_modelo;
    }

    public void setNombre_modelo(String nombre_modelo) {
        this.nombre_modelo = nombre_modelo;
    }

    // Getter para el atributo "Id_Avion"
   
}