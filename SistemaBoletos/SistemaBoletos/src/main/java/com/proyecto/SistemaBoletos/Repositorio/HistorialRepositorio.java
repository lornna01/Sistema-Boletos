package com.proyecto.SistemaBoletos.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.proyecto.SistemaBoletos.Modelo.Historial;

@Repository
public interface HistorialRepositorio extends JpaRepository<Historial, Integer> {
    
}

