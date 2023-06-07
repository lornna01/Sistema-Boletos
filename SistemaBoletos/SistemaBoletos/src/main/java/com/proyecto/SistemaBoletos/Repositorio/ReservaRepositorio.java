package com.proyecto.SistemaBoletos.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.proyecto.SistemaBoletos.Modelo.Reserva;

@Repository
public interface ReservaRepositorio extends JpaRepository<Reserva, Integer> {
    
}
