package com.proyecto.SistemaBoletos.Modelo;



import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "factura")
public class Factura {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String nit;
    private String direccion;
    private Date fecha_emision;
    private Float monto;
       
    @ManyToOne
    @JoinColumn(name = "id_boleto")
    private Boleto id_boleto;

    
    @ManyToOne
    @JoinColumn(name = "id_embalaje")
    private Embalaje id_embalaje;


    //CONSTRUCTOR
    public Factura() {
    }

//CONSTRUCTOR
    public Factura(int id, String nombre, String nit, String direccion, Date fecha_emision, Float monto,
            Boleto id_boleto, Embalaje id_embalaje) {
        this.id = id;
        this.nombre = nombre;
        this.nit = nit;
        this.direccion = direccion;
        this.fecha_emision = fecha_emision;
        this.monto = monto;
        this.id_boleto = id_boleto;
        this.id_embalaje = id_embalaje;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFecha_emision() {
        return fecha_emision;
    }

    public void setFecha_emision(Date fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }

    public Boleto getId_boleto() {
        return id_boleto;
    }

    public void setId_boleto(Boleto id_boleto) {
        this.id_boleto = id_boleto;
    }

    public Embalaje getId_embalaje() {
        return id_embalaje;
    }

    public void setId_embalaje(Embalaje id_embalaje) {
        this.id_embalaje = id_embalaje;
    }




    

}
    