package com.proyecto.SistemaBoletos.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.SistemaBoletos.Modelo.Pasajero;

@Repository
public interface PasajeroRepositorio extends JpaRepository<Pasajero, Integer>{
    
}
