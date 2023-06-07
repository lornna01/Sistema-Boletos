package com.proyecto.SistemaBoletos.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reserva")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String clase_vuelo;
    private String asiento;
   
    @ManyToOne
    @JoinColumn(name = "id_vuelo")
    private Vuelo id_vuelo;

    @ManyToOne
    @JoinColumn(name = "id_pasajero")
    private Pasajero id_pasajero;

    //Constructor
    public Reserva() {
    }

    public Reserva(int id, String clase_vuelo, String asiento, Vuelo id_vuelo, Pasajero id_pasajero) {
        this.id = id;
        this.clase_vuelo = clase_vuelo;
        this.asiento = asiento;
        this.id_vuelo = id_vuelo;
        this.id_pasajero = id_pasajero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClase_vuelo() {
        return clase_vuelo;
    }

    public void setClase_vuelo(String clase_vuelo) {
        this.clase_vuelo = clase_vuelo;
    }

    public String getAsiento() {
        return asiento;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

    public Vuelo getId_vuelo() {
        return id_vuelo;
    }

    public void setId_vuelo(Vuelo id_vuelo) {
        this.id_vuelo = id_vuelo;
    }

    public Pasajero getId_pasajero() {
        return id_pasajero;
    }

    public void setId_pasajero(Pasajero id_pasajero) {
        this.id_pasajero = id_pasajero;
    }



    
    

}
