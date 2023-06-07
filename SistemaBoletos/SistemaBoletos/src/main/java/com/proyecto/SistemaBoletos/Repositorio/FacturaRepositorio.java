package com.proyecto.SistemaBoletos.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.proyecto.SistemaBoletos.Modelo.Factura;

@Repository
public interface FacturaRepositorio extends JpaRepository<Factura, Integer> {
    
}
