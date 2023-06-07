package com.proyecto.SistemaBoletos.Controlador;


import java.util.List;

import com.proyecto.SistemaBoletos.SistemaBoletosApplication;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.proyecto.SistemaBoletos.Modelo.Reserva;
import com.proyecto.SistemaBoletos.Repositorio.ReservaRepositorio;

@RestController
@RequestMapping("/App/Reservas")
@CrossOrigin(origins = "*")
public class ReservaControlador {
    
    @Autowired
    private ReservaRepositorio repositorio;

    @GetMapping("/listarReserva")
    public List<Reserva> listarTodaSlasReservas() {
        return repositorio.findAll();
    }

    @PostMapping("/guardarReserva")
    public Reserva guardarReserva(@RequestBody Reserva reserva) {
        return repositorio.save(reserva);
    }

    
    @PutMapping("/actualizarReserva/{id}")
    public Reserva actualizarReserva(@PathVariable int id, @RequestBody Reserva reservaActualizado) {
        Reserva reserva = repositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe reserva con el numero:" + id));
        
        reserva.setId_vuelo(reservaActualizado.getId_vuelo());
        reserva.setId_pasajero(reservaActualizado.getId_pasajero());
        reserva.setAsiento(reservaActualizado.getAsiento());
        reserva.setClase_vuelo(reservaActualizado.getClase_vuelo());
        

        Reserva reservaActual = repositorio.save(reserva);
        return reservaActual;
    }


    @DeleteMapping("/eliminarReserva/{id}")
    public String eliminarReserva(@PathVariable int id) {
        Reserva reserva = repositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe LA RESERVA con el id: " + id));
        repositorio.delete(reserva);
        return "Reserva eliminada con el id: " + id + " DISFRUTE SU VIAJE";
    }




}
