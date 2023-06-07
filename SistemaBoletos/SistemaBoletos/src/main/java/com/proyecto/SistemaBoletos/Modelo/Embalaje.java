package com.proyecto.SistemaBoletos.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;

@Entity
@Table(name = "embalaje")
public class Embalaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int cantidad_maletas;
    private Float peso_maletas;
    private Float precio_maletas;
    private Float monto;

    //CONSTRUCTOR VACIO
    public Embalaje() {
    }

    public Embalaje(int id, int cantidad_maletas, Float peso_maletas, Float precio_maletas, Float monto) {
        this.id = id;
        this.cantidad_maletas = cantidad_maletas;
        this.peso_maletas = peso_maletas;
        this.precio_maletas = precio_maletas;
        this.monto = monto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidad_maletas() {
        return cantidad_maletas;
    }

    public void setCantidad_maletas(int cantidad_maletas) {
        this.cantidad_maletas = cantidad_maletas;
    }

    public Float getPeso_maletas() {
        return peso_maletas;
    }

    public void setPeso_maletas(Float peso_maletas) {
        this.peso_maletas = peso_maletas;
    }

    public Float getPrecio_maletas() {
        return precio_maletas;
    }

    public void setPrecio_maletas(Float precio_maletas) {
        this.precio_maletas = precio_maletas;
    }

    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }

    
    

    
    
   
    

}
