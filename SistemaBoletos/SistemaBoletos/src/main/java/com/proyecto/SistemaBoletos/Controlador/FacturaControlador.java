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

import com.proyecto.SistemaBoletos.Modelo.Factura;
import com.proyecto.SistemaBoletos.Repositorio.FacturaRepositorio;

@RestController
@RequestMapping("/App/Facturas")
@CrossOrigin(origins = "*")
public class FacturaControlador {
    
    @Autowired
    private FacturaRepositorio repositorio;

    @GetMapping("/listarFactura")
    public List<Factura> listarTodaSlasFacturas() {
        return repositorio.findAll();
    }

    @PostMapping("/guardarFactura")
    public Factura guardarFactura(@RequestBody Factura factura) {
        return repositorio.save(factura);
    }

    
    @PutMapping("/actualizarFactura/{id}")
    public Factura actualizarFactura(@PathVariable int id, @RequestBody Factura facturaActualizado) {
        Factura factura = repositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe la FACTURA NUMERO: " + id));
        
        factura.setId_embalaje(facturaActualizado.getId_embalaje());
        factura.setId_boleto(facturaActualizado.getId_boleto());
        factura.setMonto(facturaActualizado.getMonto());
        factura.setFecha_emision(facturaActualizado.getFecha_emision()); 
        factura.setDireccion(facturaActualizado.getDireccion());
        factura.setNit(facturaActualizado.getNit());
        factura.setNombre(facturaActualizado.getNombre());


        Factura facturaActual = repositorio.save(factura);
        return facturaActual;
    }


    @DeleteMapping("/eliminarFactura/{id}")
    public String eliminarFactura(@PathVariable int id) {
        Factura factura = repositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe la factura numero: " + id));
        repositorio.delete(factura);
        return "FACTURA eliminada con el id: " + id;
    }



}
