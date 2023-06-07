package com.proyecto.SistemaBoletos.Controlador;

import com.proyecto.SistemaBoletos.SistemaBoletosApplication;
import java.util.List;

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


import com.proyecto.SistemaBoletos.Modelo.Boleto;
import com.proyecto.SistemaBoletos.Repositorio.BoletoRepositorio;

@RestController
@RequestMapping("/App/Boletos")
@CrossOrigin(origins = "*")
public class BoletoControlador {
    
    @Autowired
    private BoletoRepositorio repositorio;

    @GetMapping("/listarBoleto")
    public List<Boleto> listarTodaSlosBoletos() {
        return repositorio.findAll();
    }

    @PostMapping("/guardarBoleto")
    public Boleto guardarReserva(@RequestBody Boleto boleto) {
        return repositorio.save(boleto);
    }

    @PutMapping("/actualizarBoleto/{id}")
    public Boleto actualizarBoleto(@PathVariable int id, @RequestBody Boleto boletoActualizado) {
        Boleto boleto = repositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe el BOLETO con el id:" + id));
        boleto.setId_reserva(boletoActualizado.getId_reserva());
        boleto.setHora_prechequeo(boletoActualizado.getHora_prechequeo());
        boleto.setPrecio_boleto(boletoActualizado.getPrecio_boleto());
        boleto.setFecha_validacion(boletoActualizado.getFecha_validacion());
        boleto.setFecha_emision(boletoActualizado.getFecha_emision());

        Boleto boletoActual = repositorio.save(boleto);
        return boletoActual;
    }


    @DeleteMapping("/eliminarBoleto/{id}")
    public String eliminarBoleto(@PathVariable int id) {
        Boleto boleto = repositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe el avion con el id: " + id));
        repositorio.delete(boleto);
        return "BOLETO eliminado con el id: " + id + " con fecha de emision: " + boleto.getFecha_emision();
    }



}
