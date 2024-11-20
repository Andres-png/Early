package com.early.demo.Servicio;

import com.early.demo.Entidades.Usuario;
import com.early.demo.Repositorios.Usuario_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



    @Service
    public class servicio_Usuario {

        @Autowired
        private Usuario_Repository usu_repo;


        public List<Usuario> getPersona() {
            return usu_repo.findAll();
        }

        public Usuario agregarUsuario(Usuario usu) {
            return usu_repo.save(usu);
        }

        public Usuario editarUsuario(Usuario usu) {
            if (usu == null || usu.getId() == null) {
                return null;
            }

            Usuario us = usu_repo.getReferenceById(usu.getId());
            if (us != null) {
                us.setNombre(usu.getNombre());
                us.setContraseña(usu.getContraseña());
                us.setDireccion(usu.getDireccion());
                us.setEstado(usu.getEstado());
                us.setEmail_celular(usu.getEmail_celular());
                us.setRol(usu.getRol());
                us.setZona(usu.getZona());
                us.setVehiculo(usu.getVehiculo());

                return usu_repo.save(us);
            }
            return null; }


        public Usuario eliminarUsuario(int id) {
            Usuario usu = usu_repo.findById(id).orElse(null);

            if (usu != null) {
                usu_repo.delete(usu);
                System.out.println("Persona con ID " + id + " eliminada.");
                return usu;
            } else {
                System.out.println("Persona con ID " + id + " no encontrada.");
                return null;
            }
        }
}
