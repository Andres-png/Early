package com.early.demo.Servicio;


import com.early.demo.Entidades.Administrador;
import com.early.demo.Entidades.Usuario;
import com.early.demo.Repositorios.Administrador_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class servicio_Administrador {

    @Autowired
    private Administrador_Repository admRepo;

    public List<Administrador> getUsuarios() {
        return admRepo.findAll();
    }

    public Administrador agregarUsuario(Administrador admin) {
        return admRepo.save(admin);
    }

    public Administrador editarUsuario(Administrador admi) {
        if (admi == null || admi.getIdAdmin() == null) {
            return null;
        }

        Administrador admin = admRepo.getReferenceById(admi.getIdAdmin());
        if (admin != null) {
            admin.setTelefono(admi.getTelefono());
            admin.setEmail(admi.getEmail());
            return admRepo.save(admin);
        }
        return null; }

    public Administrador eliminarAdministrador(Long id) {
        Administrador admin = admRepo.findById(id).orElse(null);

        if (admin != null) {
            admRepo.delete(admin);
            System.out.println("Usuario con ID " + id + " eliminado.");
            return admin;
        } else {
            System.out.println("Usuario con ID " + id + " no encontrado.");
            return null;
        }
    }
}
