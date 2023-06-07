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

 import com.proyecto.SistemaBoletos.Modelo.Pasajero;
 import com.proyecto.SistemaBoletos.Repositorio.PasajeroRepositorio;

@RestController
@RequestMapping("/App/Pasajeros")
@CrossOrigin(origins = "*")
public class PasajeroControlador {
 
    @Autowired
    private PasajeroRepositorio repositorio;
 
    @GetMapping("/listarPasajero")
    public List<Pasajero> listarTodoSlosPasajeros() {
        return repositorio.findAll();
    }

    @PostMapping("/guardarPasajero")
    public Pasajero guardarPasajero(@RequestBody Pasajero pasajero) {
        return repositorio.save(pasajero);
    }

    
    @PutMapping("/actualizarPasajero/{id}")
    public Pasajero actualizarPasajero(@PathVariable int id, @RequestBody Pasajero pasajeroActualizado) {
        Pasajero pasajero = repositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe el PASAJERO con el id:" + id));
        
        pasajero.setNacionalidad(pasajeroActualizado.getNacionalidad());
        pasajero.setGenero(pasajeroActualizado.getGenero());
        pasajero.setDireccion(pasajeroActualizado.getDireccion());
        pasajero.setTelefono(pasajeroActualizado.getTelefono());
        pasajero.setFecha_nacimiento(pasajeroActualizado.getFecha_nacimiento());
        pasajero.setNombre(pasajeroActualizado.getNombre());
             
        Pasajero pasajeroActual = repositorio.save(pasajero);
        return pasajeroActual;
    }


    @DeleteMapping("/eliminarPasajero/{id}")
    public String eliminarPasajero(@PathVariable int id) {
        Pasajero pasajero = repositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe el PASAJERO con el id: " + id));
        repositorio.delete(pasajero);
        return "PASAJERO eliminado con el id: " + id + " nombre: " + pasajero.getNombre();
    }


}
