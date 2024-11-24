package com.early.demo.Servicio;

import com.early.demo.Entidades.Mensajero;
import com.early.demo.Repositorios.Mensajero_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class servicio_Mensajero {

    @Autowired
    private Mensajero_Repository mensajeroRepo;


    public List<Mensajero> getMensajeros() {
        return mensajeroRepo.findAll();
    }


    public Mensajero agregarMensajero(Mensajero mensajero) {
        return mensajeroRepo.save(mensajero);
    }


    public Mensajero editarMensajero(Mensajero mensajero) {
        if (mensajero == null || mensajero.getIdUsuario() == null) {
            return null;
        }

        Mensajero mensajeroExistente = mensajeroRepo.getReferenceById(mensajero.getIdUsuario());
        if (mensajeroExistente != null) {
            mensajeroExistente.setTelefono(mensajero.getTelefono());
            mensajeroExistente.setEmail(mensajero.getEmail());
            mensajeroExistente.setZona(mensajero.getZona());
            mensajeroExistente.setEstado(mensajero.getEstado());
            mensajeroExistente.setVehiculo(mensajero.getVehiculo());
            return mensajeroRepo.save(mensajeroExistente);
        }
        return null;
    }


    public Mensajero eliminarMensajero(Integer id) {
        Mensajero mensajero = mensajeroRepo.findById(id).orElse(null);

        if (mensajero != null) {
            mensajeroRepo.delete(mensajero);
            System.out.println("Mensajero con ID " + id + " eliminado.");
            return mensajero;
        } else {
            System.out.println("Mensajero con ID " + id + " no encontrado.");
            return null;
        }
    }
}
