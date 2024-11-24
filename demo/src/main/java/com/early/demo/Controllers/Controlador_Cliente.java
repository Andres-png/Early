package com.early.demo.Controllers;


import com.early.demo.Entidades.Cliente;
import com.early.demo.Servicio.servicio_Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controlador_Cliente {


    @Autowired
    private servicio_Cliente serv_cli;

    @GetMapping("/lista")
    public List<Cliente> lista(){
        return serv_cli.getClientes();
    }

    @PostMapping("/agregar")
    public Cliente agregar(@RequestBody Cliente cli){
        return serv_cli.agregarCliente(cli);
    }

    @PutMapping("/editar")
    public Cliente editar(@RequestBody Cliente cli){
        return serv_cli.editarCliente(cli);
    }

    @DeleteMapping("/eliminar/{id}")
    public Cliente eliminarContraseña(@PathVariable Integer id) {
        return serv_cli.eliminarCliente(id);
    }
}
