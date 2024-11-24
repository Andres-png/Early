package com.early.demo.Controllers;


import com.early.demo.Entidades.Emprendimiento;
import com.early.demo.Servicio.servicio_Emprendimiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprendimiento")
public class Controlador_Emprendimiento {

    @Autowired
    private servicio_Emprendimiento serv_empren;

    @GetMapping("/lista")
    public List<Emprendimiento> lista() {
        return serv_empren.getEmprendimientos();
    }

    @PostMapping("/agregar")
    public Emprendimiento agregar(@RequestBody Emprendimiento empre) {
        return serv_empren.agregarEmprendimiento(empre);
    }

    @PutMapping("/editar")
    public Emprendimiento editar(@RequestBody Emprendimiento empre) {
        return serv_empren.editarEmprendimiento(empre);
    }

    @DeleteMapping("/eliminar/{id}")
    public Emprendimiento eliminarContraseña(@PathVariable Integer id) {
        return serv_empren.eliminarEmprendimiento(id);
    }
}

