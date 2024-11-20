package com.early.demo.Controllers;


import com.early.demo.Entidades.Usuario;
import com.early.demo.Servicio.servicio_Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controlador_Usuario {

    @Autowired
    private servicio_Usuario serv_usu;

    @GetMapping("/lista")
    public List<Usuario> lista(){
        return serv_usu.getPersona();
    }

    @PostMapping("/agregar")
    public Usuario agregar(@RequestBody Usuario usu){
        return serv_usu.agregarUsuario(usu);
    }

    @PutMapping("/editar")
    public Usuario editar(@RequestBody Usuario usu){
        return serv_usu.editarUsuario(usu);
    }

    @DeleteMapping("/eliminar/{id}")
    public Usuario eliminarContraseña(@PathVariable int id) {
        return serv_usu.eliminarUsuario(id);
    }

}
