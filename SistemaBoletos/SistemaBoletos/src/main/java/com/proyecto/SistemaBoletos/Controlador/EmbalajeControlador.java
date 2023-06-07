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



import com.proyecto.SistemaBoletos.Modelo.Embalaje;
import com.proyecto.SistemaBoletos.Repositorio.EmbalajeRepositorio;


@RestController
@RequestMapping("/App/Embalajes")
@CrossOrigin(origins = "*")
public class EmbalajeControlador {
    @Autowired
    private EmbalajeRepositorio repositorio;

    @GetMapping("/listarEmbalaje")
    public List<Embalaje> listarTodoSlosEmbalajes() {
        return repositorio.findAll();
    }


    @PostMapping("/guardarEmbalaje")
    public Embalaje guardarEmbalaje(@RequestBody Embalaje embalaje) {
        return repositorio.save(embalaje);
    }

    @PutMapping("/actualizarEmbalaje/{id}")
    public Embalaje actualizarEmbalaje(@PathVariable int id, @RequestBody Embalaje embalajeActualizado) {
        Embalaje embalaje = repositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe el embalaje con el id:" + id));
        embalaje.setMonto(embalajeActualizado.getMonto());
        embalaje.setPrecio_maletas(embalajeActualizado.getPrecio_maletas());
        embalaje.setPeso_maletas(embalajeActualizado.getPeso_maletas());
        embalaje.setCantidad_maletas(embalajeActualizado.getCantidad_maletas());
        

        Embalaje embalajeActual = repositorio.save(embalaje);
        return embalajeActual;
    }


    @DeleteMapping("/eliminarEmbalaje/{id}")
    public String eliminarEmbalaje(@PathVariable int id) {
        Embalaje embalaje = repositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe el embalaje con el id: " + id));
        repositorio.delete(embalaje);
        return "Embalaje eliminado con el id: " + id + " precio: " + embalaje.getPrecio_maletas();
    }





}
