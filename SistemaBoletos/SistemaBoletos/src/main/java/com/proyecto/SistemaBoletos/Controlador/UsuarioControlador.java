package com.proyecto.SistemaBoletos.Controlador;

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

import com.proyecto.SistemaBoletos.Modelo.Usuario;
import com.proyecto.SistemaBoletos.Repositorio.UsuarioRepositorio;

@RestController
@RequestMapping("/Usuarios")
@CrossOrigin(origins = "*")
public class UsuarioControlador {
    

    @Autowired
    private UsuarioRepositorio repositorio;

    @GetMapping("/listarUsuarios")
    public List<Usuario> listarTodoSlosUsuarios() {
        return repositorio.findAll();
    }

    @PostMapping("/guardarUsuario")
    public Usuario guardarUsuario(@RequestBody Usuario usuario) {
        return repositorio.save(usuario);
    }

    @PutMapping("/actualizarUsuario/{id}")
    public Usuario actualizarUsuario(@PathVariable int id, @RequestBody Usuario usuarioActualizado) {
        Usuario usuario = repositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe USUARIO con el numero: " + id));
        usuario.setId_empleado(usuarioActualizado.getId_empleado());
        usuario.setId_rol(usuarioActualizado.getId_rol());
        usuario.setPassword(usuarioActualizado.getPassword());
        usuario.setNombre_usuario(usuarioActualizado.getNombre_usuario());
        

        Usuario usuarioActual = repositorio.save(usuario);
        return usuarioActual;
    }


    @DeleteMapping("/eliminarUsuario/{id}")
    public String eliminarUsuario(@PathVariable int id) {
        Usuario usuario = repositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe USUARIO con el id: " + id));
        repositorio.delete(usuario);
        return "USUARIO eliminado con el id: " + id + " DISFRUTE SU VIAJE";
    }


}