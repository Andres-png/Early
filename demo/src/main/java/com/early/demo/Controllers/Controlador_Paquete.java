package com.early.demo.Controllers;


import com.early.demo.Entidades.Paquete;
import com.early.demo.Servicio.servicio_Paquete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controlador_Paquete {

    @Autowired
    private servicio_Paquete serv_paq;

    @GetMapping("/lista")
    public List<Paquete> lista(){
        return serv_paq.getPaquetes();
    }

    @PostMapping("/agregar")
    public Paquete agregar(@RequestBody Paquete paq){
        return serv_paq.agregarPaquete(paq);
    }

    @PutMapping("/editar")
    public Paquete editar(@RequestBody Paquete paq){
        return serv_paq.editarPaquete(paq);
    }

    @DeleteMapping("/eliminar/{id}")
    public Paquete eliminarContraseña(@PathVariable Integer id) {
        return serv_paq.eliminarPaquete(id);
    }
}
