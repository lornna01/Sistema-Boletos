package com.proyecto.SistemaBoletos.Controlador;

import com.proyecto.SistemaBoletos.SistemaBoletosApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import org.springframework.web.server.ResponseStatusException;

// // import com.Reserva.Exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional; // Importación corregida

import com.proyecto.SistemaBoletos.Modelo.Rol;
import com.proyecto.SistemaBoletos.Repositorio.RolRepositorio;

@RestController
@RequestMapping("/Roles")
@CrossOrigin(origins = "*")

public class RolControlador {
    
    @Autowired
    private RolRepositorio repositorio;

    @GetMapping("/listarRoles")
    public List<Rol> listarTodoSlosRoles() {
        return repositorio.findAll();
    }

    @PostMapping("/guardarRol")
    public Rol guardarRol(@RequestBody Rol rol) {
        return repositorio.save(rol);
    }


    @PutMapping("/actualizarRol/{id}")
    public Rol actualizarRol(@PathVariable int id, @RequestBody Rol rolActualizado) {
        Rol rol = repositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe ROL con el numero: " + id));
        
        rol.setNombre_rol(rolActualizado.getNombre_rol());
        

        Rol rolActual = repositorio.save(rol);
        return rolActual;
    }


    @DeleteMapping("/eliminarRol/{id}")
    public String eliminarRol(@PathVariable int id) {
        Rol rol = repositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe ROL con el id: " + id));
        repositorio.delete(rol);
        return "ROL eliminado con el id: " + id + " DISFRUTE SU VIAJE";
    }




}