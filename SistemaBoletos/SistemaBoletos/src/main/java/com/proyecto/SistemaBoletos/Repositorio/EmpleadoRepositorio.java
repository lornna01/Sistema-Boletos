package com.proyecto.SistemaBoletos.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.SistemaBoletos.Modelo.Empleado;

@Repository
public interface EmpleadoRepositorio extends JpaRepository<Empleado, Integer> {
    
}

