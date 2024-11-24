package com.early.demo.Servicio;

import com.early.demo.Entidades.Paquete;
import com.early.demo.Repositorios.Paquete_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class servicio_Paquete {

    @Autowired
    private Paquete_Repository paqueteRepo;


    public List<Paquete> getPaquetes() {
        return paqueteRepo.findAll();
    }


    public Paquete agregarPaquete(Paquete paquete) {
        return paqueteRepo.save(paquete);
    }


    public Paquete editarPaquete(Paquete paquete) {
        if (paquete == null || paquete.getIdPaquete() == null) {
            return null;
        }

        Paquete paqueteExistente = paqueteRepo.getReferenceById(paquete.getIdPaquete());
        if (paqueteExistente != null) {
            // Actualizar los atributos del paquete
            paqueteExistente.setEstadoPaquete(paquete.getEstadoPaquete());
            paqueteExistente.setPeso(paquete.getPeso());
            paqueteExistente.setCosto(paquete.getCosto());
            paqueteExistente.setNombreReceptor(paquete.getNombreReceptor());
            paqueteExistente.setSolicitud(paquete.getSolicitud());
            paqueteExistente.setMensajero(paquete.getMensajero());
            return paqueteRepo.save(paqueteExistente);
        }
        return null;
    }


    public Paquete eliminarPaquete(Integer id) {
        Paquete paquete = paqueteRepo.findById(id).orElse(null);

        if (paquete != null) {
            paqueteRepo.delete(paquete);
            System.out.println("Paquete con ID " + id + " eliminado.");
            return paquete;
        } else {
            System.out.println("Paquete con ID " + id + " no encontrado.");
            return null;
        }
    }
}

