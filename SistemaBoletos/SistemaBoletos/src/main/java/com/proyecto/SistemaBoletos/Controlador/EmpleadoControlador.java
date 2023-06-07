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

 import com.proyecto.SistemaBoletos.Modelo.Empleado;
 import com.proyecto.SistemaBoletos.Repositorio.EmpleadoRepositorio;

@RestController
@RequestMapping("/App/Empleados")
//SIN UTILIZAR EL FRONTEND
//@CrossOrigin(origins = "*")
//URL UTILIZADA EN EL FRONTEND
@CrossOrigin(origins = "http://localhost:4200/")
public class EmpleadoControlador {
 
    @Autowired
    private EmpleadoRepositorio repositorio;
 
    @GetMapping("/listarEmpleado")
    public List<Empleado> listarTodoSlosEmpleados() {
        return repositorio.findAll();
    }


    @PostMapping("/guardarEmpleado")
    public Empleado guardarEmpleado(@RequestBody Empleado empleado) {
        return repositorio.save(empleado);
    }


    @PutMapping("/actualizarEmpleado/{id}")
    public Empleado actualizarEmpleado(@PathVariable int id, @RequestBody Empleado empleadoActualizado) {
        Empleado empleado = repositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe el Empleado con el id:" + id));
        empleado.setCargo(empleadoActualizado.getCargo());
        empleado.setNacionalidad(empleadoActualizado.getNacionalidad());
        empleado.setGenero(empleadoActualizado.getGenero());
        empleado.setDireccion(empleadoActualizado.getDireccion());
        empleado.setTelefono(empleadoActualizado.getTelefono());
        empleado.setFecha_nacimiento(empleadoActualizado.getFecha_nacimiento());
        empleado.setNombre(empleadoActualizado.getNombre());

        Empleado empleadoActual = repositorio.save(empleado);
        return empleadoActual;
    }


    @DeleteMapping("/eliminarEmpleado/{id}")
    public String eliminarEmpleado(@PathVariable int id) {
        Empleado empleado = repositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe el EMPLEADO con el id: " + id));
        repositorio.delete(empleado);
        return "EMPLEADO eliminado con el id: " + id + " nombre: " + empleado.getNombre();
    }



}
 



