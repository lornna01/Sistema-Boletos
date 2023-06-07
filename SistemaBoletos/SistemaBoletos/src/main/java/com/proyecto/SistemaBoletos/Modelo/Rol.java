package com.proyecto.SistemaBoletos.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id_Rol;
    private String nombre_rol;


     //CONSTRUCTOR
    public Rol() {
        }

         //CONSTRUCTOR
    public Rol(int id_Rol, String nombre_rol) {
        Id_Rol = id_Rol;
        this.nombre_rol = nombre_rol;
    }

    public int getId_Rol() {
        return Id_Rol;
    }

    public void setId_Rol(int id_Rol) {
        Id_Rol = id_Rol;
    }

    public String getNombre_rol() {
        return nombre_rol;
    }

    public void setNombre_rol(String nombre_rol) {
        this.nombre_rol = nombre_rol;
    }


    
}
