package com.early.demo.Controllers;


import com.early.demo.Entidades.Mensajero;
import com.early.demo.Servicio.servicio_Mensajero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mensajero")
public class Controlador_Mensajero {

    @Autowired
    private servicio_Mensajero serv_mensa;

    @GetMapping("/lista")
    public List<Mensajero> lista() {
        return serv_mensa.getMensajeros();
    }

    @PostMapping("/agregar")
    public Mensajero agregar(@RequestBody Mensajero mensa) {
        return serv_mensa.agregarMensajero(mensa);
    }

    @PutMapping("/editar")
    public Mensajero editar(@RequestBody Mensajero mensa) {
        return serv_mensa.editarMensajero(mensa);
    }

    @DeleteMapping("/eliminar/{id}")
    public Mensajero eliminarContraseña(@PathVariable Integer id) {
        return serv_mensa.eliminarMensajero(id);
    }
}
