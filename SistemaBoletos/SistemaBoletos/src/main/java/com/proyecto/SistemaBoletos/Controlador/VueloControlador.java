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

import com.proyecto.SistemaBoletos.Modelo.Vuelo;
import com.proyecto.SistemaBoletos.Repositorio.VueloRepositorio;

@RestController
@RequestMapping("/App/Vuelos")
@CrossOrigin(origins = "*")
public class VueloControlador {
    

    @Autowired
    private VueloRepositorio repositorio;

    @GetMapping("/listarVuelos")
    public List<Vuelo> listarTodoSlosVuelos() {
        return repositorio.findAll();
    }

    @PostMapping("/guardarVuelo")
    public Vuelo guardarVuelo(@RequestBody Vuelo vuelo) {
        return repositorio.save(vuelo);
    }

    @PutMapping("/actualizarVuelo/{id}")
    public Vuelo actualizarVuelo(@PathVariable int id, @RequestBody Vuelo vueloActualizado) {
        Vuelo vuelo = repositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe el VUELO con el id:" + id));
        
        vuelo.setNumero_puerta(vueloActualizado.getNumero_puerta());
        vuelo.setHora_revision(vueloActualizado.getHora_revision());
        vuelo.setHora_llegada(vueloActualizado.getHora_llegada());
        vuelo.setFecha_llegada(vueloActualizado.getFecha_llegada());
        vuelo.setDestino(vueloActualizado.getDestino());
        vuelo.setHora_salida(vueloActualizado.getHora_salida());
        vuelo.setFecha_salida(vueloActualizado.getFecha_salida());
        vuelo.setOrigen(vueloActualizado.getOrigen());


        Vuelo vueloActual = repositorio.save(vuelo);
        return vueloActual;
    }


    @DeleteMapping("/eliminarVuelo/{id}")
    public String eliminarVuelo(@PathVariable int id) {
        Vuelo vuelo = repositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe el VUELO con el id: " + id));
        repositorio.delete(vuelo);
        return "VUELO eliminado con el id: " + id + "DE: " + vuelo.getOrigen() + " A: " + vuelo.getDestino();

    }







}
