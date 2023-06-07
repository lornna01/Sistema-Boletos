package com.proyecto.SistemaBoletos.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.proyecto.SistemaBoletos.Modelo.Vuelo;

@Repository
public interface VueloRepositorio extends JpaRepository<Vuelo, Integer> {
    
}