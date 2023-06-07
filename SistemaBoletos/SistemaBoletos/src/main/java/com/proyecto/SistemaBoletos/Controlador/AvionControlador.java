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


import com.proyecto.SistemaBoletos.Modelo.Avion;
import com.proyecto.SistemaBoletos.Repositorio.AvionRepositorio;

@RestController
@RequestMapping("/App/Aviones")
//@CrossOrigin(origins = "*")
//URL UTILIZADA EN EL FRONTEND
@CrossOrigin(origins = "http://localhost:4200/")
public class AvionControlador {

    @Autowired
    private AvionRepositorio repositorio;

    @GetMapping("/listarAviones")
    public List<Avion> listarTodoSlosAviones() {
        return repositorio.findAll();
    }

    @PostMapping("/guardarAvion")
    public Avion guardarAvion(@RequestBody Avion avion) {
        return repositorio.save(avion);
    }


    @PutMapping("/actualizarAvion/{id}")
    public Avion actualizarAvion(@PathVariable int id, @RequestBody Avion avionActualizado) {
        Avion avion = repositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe el avion con el id:" + id));

        avion.setNombre_modelo(avionActualizado.getNombre_modelo());
        avion.setNombre_avion(avionActualizado.getNombre_avion());
        avion.setCapacidad(avionActualizado.getCapacidad());

        Avion avionActual = repositorio.save(avion);
        return avionActual;
    }


    @DeleteMapping("/eliminarAvion/{id}")
    public String eliminarAvion(@PathVariable int id) {
        Avion avion = repositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe el avion con el id: " + id));
        repositorio.delete(avion);
        return "Avion eliminado con el id: " + id + " nombre: " + avion.getNombre_avion();
    }





}

