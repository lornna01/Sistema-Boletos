package com.proyecto.SistemaBoletos.Controlador;

import com.proyecto.SistemaBoletos.SistemaBoletosApplication;

import java.util.List;

import org.apache.catalina.connector.Response;
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
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.SistemaBoletos.Modelo.Historial;
import com.proyecto.SistemaBoletos.Repositorio.HistorialRepositorio;

@RestController
@RequestMapping("/App/Historial")
@CrossOrigin(origins = "*")
public class HistorialControlador {



    @Autowired
    private HistorialRepositorio repositorio;

    @GetMapping("/listarHistorial")
    public List<Historial> listarTodoElHistorial() {
        return repositorio.findAll();
    }

    @PostMapping("/guardarHistorial")
    public Historial guardarHistorial(@RequestBody Historial historial) {
        return repositorio.save(historial);
    }



    
}
