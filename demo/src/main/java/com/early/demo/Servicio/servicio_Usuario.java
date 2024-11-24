package com.early.demo.Servicio;

import com.early.demo.Entidades.Cliente;
import com.early.demo.Entidades.Emprendimiento;
import com.early.demo.Entidades.Mensajero;
import com.early.demo.Entidades.Usuario;
import com.early.demo.Repositorios.Usuario_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class servicio_Usuario {

    @Autowired
    private Usuario_Repository usuRepo;

    public List<Usuario> getUsuarios() {
        return usuRepo.findAll();
    }

    public Usuario agregarUsuario(Usuario usuario) {
        return usuRepo.save(usuario);
    }

    public Usuario editarUsuario(Usuario usuario) {
        if (usuario == null || usuario.getIdUsuario() == null) {
            return null;
        }

        Usuario usuarioExistente = usuRepo.findById(usuario.getIdUsuario()).orElse(null);

        if (usuarioExistente != null) {
            usuarioExistente.setNombre(usuario.getNombre());
            usuarioExistente.setTelefono(usuario.getTelefono());
            usuarioExistente.setEmail(usuario.getEmail());
            usuarioExistente.setContrasena(usuario.getContrasena());
            usuarioExistente.setRol(usuario.getRol());

            // Si es un cliente, actualizamos atributos específicos de Cliente
            if (usuario instanceof Cliente cliente) {
                ((Cliente) usuarioExistente).setDireccion(cliente.getDireccion());
            }

            // Si es un mensajero, actualizamos atributos específicos de Mensajero
            if (usuario instanceof Mensajero mensajero) {
                ((Mensajero) usuarioExistente).setZona(mensajero.getZona());
                ((Mensajero) usuarioExistente).setEstado(mensajero.getEstado());
                ((Mensajero) usuarioExistente).setVehiculo(mensajero.getVehiculo());
            }

            // Si es un emprendimiento, actualizamos atributos específicos de Emprendimiento
            if (usuario instanceof Emprendimiento emprendimiento) {
                ((Emprendimiento) usuarioExistente).setRepresentanteLegal(emprendimiento.getRepresentanteLegal());
                ((Emprendimiento) usuarioExistente).setNidEmprendimiento(emprendimiento.getNidEmprendimiento());
                ((Emprendimiento) usuarioExistente).setNombreEmprendimiento(emprendimiento.getNombreEmprendimiento());
                ((Emprendimiento) usuarioExistente).setDireccion(emprendimiento.getDireccion());
                ((Emprendimiento) usuarioExistente).setCategoria(emprendimiento.getCategoria());
            }

            return usuRepo.save(usuarioExistente);
        }

        return null;
    }

    public Usuario eliminarUsuario(Integer id) {
        Usuario usuario = usuRepo.findById(id).orElse(null);

        if (usuario != null) {
            usuRepo.delete(usuario);
            System.out.println("Usuario con ID " + id + " eliminado.");
            return usuario;
        } else {
            System.out.println("Usuario con ID " + id + " no encontrado.");
            return null;
        }
    }
}
