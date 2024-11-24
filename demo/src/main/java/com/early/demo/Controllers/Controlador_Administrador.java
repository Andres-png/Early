package com.early.demo.Controllers;

import com.early.demo.Entidades.Administrador;
import com.early.demo.Entidades.Usuario;
import com.early.demo.Servicio.servicio_Administrador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class Controlador_Administrador {

    @Autowired
    private servicio_Administrador serv_admi;

    @GetMapping("/lista")
    public List<Administrador> lista() {
        return serv_admi.getUsuarios();
    }

    @PostMapping("/agregar")
    public Administrador agregar(@RequestBody Administrador admi) {
        return serv_admi.agregarUsuario(admi);
    }

    @PutMapping("/editar")
    public Administrador editar(@RequestBody Administrador admi) {
        return serv_admi.editarUsuario(admi);
    }

    @DeleteMapping("/eliminar/{id}")
    public Administrador eliminarContraseña(@PathVariable long id) {
        return serv_admi.eliminarAdministrador(id);
    }
}

