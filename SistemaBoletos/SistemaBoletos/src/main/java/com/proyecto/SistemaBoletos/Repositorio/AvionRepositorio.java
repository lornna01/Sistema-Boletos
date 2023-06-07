package com.proyecto.SistemaBoletos.Repositorio;

import com.proyecto.SistemaBoletos.SistemaBoletosApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.SistemaBoletos.Modelo.Avion;

@Repository
public interface AvionRepositorio extends JpaRepository<Avion, Integer> {
    
}

