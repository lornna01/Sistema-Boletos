package com.proyecto.SistemaBoletos.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre_usuario;
    private String password;
    
    @ManyToOne
    @JoinColumn(name = "id_rol")
    private Rol id_rol;

    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleado id_empleado;

    //constructor
    public Usuario() {
    }

    

    //constructor
    public Usuario(int id, String nombre_usuario, String password, Rol id_rol, Empleado id_empleado) {
        this.id = id;
        this.nombre_usuario = nombre_usuario;
        this.password = password;
        this.id_rol = id_rol;
        this.id_empleado = id_empleado;
    }



    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }



    public String getNombre_usuario() {
        return nombre_usuario;
    }



    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }



    public String getPassword() {
        return password;
    }



    public void setPassword(String password) {
        this.password = password;
    }



    public Rol getId_rol() {
        return id_rol;
    }



    public void setId_rol(Rol id_rol) {
        this.id_rol = id_rol;
    }



    public Empleado getId_empleado() {
        return id_empleado;
    }



    public void setId_empleado(Empleado id_empleado) {
        this.id_empleado = id_empleado;
    }

    
    


}
