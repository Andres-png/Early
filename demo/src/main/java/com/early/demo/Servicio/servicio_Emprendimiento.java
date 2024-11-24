package com.early.demo.Servicio;

import com.early.demo.Entidades.Emprendimiento;
import com.early.demo.Repositorios.Emprendimiento_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class servicio_Emprendimiento {

    @Autowired
    private Emprendimiento_Repository emprendimientoRepo;


    public List<Emprendimiento> getEmprendimientos() {
        return emprendimientoRepo.findAll();
    }


    public Emprendimiento agregarEmprendimiento(Emprendimiento emprendimiento) {
        return emprendimientoRepo.save(emprendimiento);
    }


    public Emprendimiento editarEmprendimiento(Emprendimiento emprendimiento) {
        if (emprendimiento == null || emprendimiento.getIdUsuario() == null) {
            return null;
        }

        Emprendimiento emprendimientoExistente = emprendimientoRepo.getReferenceById(emprendimiento.getIdUsuario());
        if (emprendimientoExistente != null) {
            // Actualizar los atributos específicos de Emprendimiento
            emprendimientoExistente.setTelefono(emprendimiento.getTelefono());
            emprendimientoExistente.setEmail(emprendimiento.getEmail());
            emprendimientoExistente.setDireccion(emprendimiento.getDireccion());
            emprendimientoExistente.setNombreEmprendimiento(emprendimiento.getNombreEmprendimiento());
            emprendimientoExistente.setNidEmprendimiento(emprendimiento.getNidEmprendimiento());
            emprendimientoExistente.setRepresentanteLegal(emprendimiento.getRepresentanteLegal());
            emprendimientoExistente.setCategoria(emprendimiento.getCategoria());
            return emprendimientoRepo.save(emprendimientoExistente);
        }
        return null;
    }


    public Emprendimiento eliminarEmprendimiento(Integer id) {
        Emprendimiento emprendimiento = emprendimientoRepo.findById(id).orElse(null);

        if (emprendimiento != null) {
            emprendimientoRepo.delete(emprendimiento);
            System.out.println("Emprendimiento con ID " + id + " eliminado.");
            return emprendimiento;
        } else {
            System.out.println("Emprendimiento con ID " + id + " no encontrado.");
            return null;
        }
    }
}

