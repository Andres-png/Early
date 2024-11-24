package com.early.demo.Controllers;


import com.early.demo.Entidades.Solicitud;
import com.early.demo.Servicio.servicio_Solicitud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/solicitud")
public class Controlador_Solicitud {

    @Autowired
    private servicio_Solicitud serv_soli;

    @GetMapping("/lista")
    public List<Solicitud> lista() {
        return serv_soli.getSolicitudes();
    }

    @PostMapping("/agregar")
    public Solicitud agregar(@RequestBody Solicitud sol) {
        return serv_soli.agregarSolicitud(sol);
    }

    @PutMapping("/editar")
    public Solicitud editar(@RequestBody Solicitud sol) {
        return serv_soli.editarSolicitud(sol);
    }

    @DeleteMapping("/eliminar/{id}")
    public Solicitud eliminarContraseña(@PathVariable Integer id) {
        return serv_soli.eliminarSolicitud(id);
    }
}

