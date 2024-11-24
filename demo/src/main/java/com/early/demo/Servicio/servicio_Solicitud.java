package com.early.demo.Servicio;

import com.early.demo.Entidades.Solicitud;
import com.early.demo.Repositorios.Solicitud_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class servicio_Solicitud {

        @Autowired
        private Solicitud_Repository solicitudRepo;


        public List<Solicitud> getSolicitudes() {
            return solicitudRepo.findAll();
        }


        public Solicitud agregarSolicitud(Solicitud solicitud) {
            return solicitudRepo.save(solicitud);
        }


        public Solicitud editarSolicitud(Solicitud solicitud) {
            if ( solicitud == null || solicitud.getIdSolicitud() == 0 ) {
                return null;
            }

            Solicitud solicitudExistente = solicitudRepo.getReferenceById(solicitud.getIdSolicitud());
            if (solicitudExistente != null) {
                // Actualizar los atributos específicos de Solicitud
                solicitudExistente.setFechaCreacion(solicitud.getFechaCreacion());
                solicitudExistente.setEstadoSolicitud(solicitud.getEstadoSolicitud());
                solicitudExistente.setCliente(solicitud.getCliente());
                solicitudExistente.setEmprendimiento(solicitud.getEmprendimiento());
                solicitudExistente.setMensajero(solicitud.getMensajero());
                return solicitudRepo.save(solicitudExistente);
            }
            return null;
        }


        public Solicitud eliminarSolicitud(int id) {
            Solicitud solicitud = solicitudRepo.findById(id).orElse(null);

            if (solicitud != null) {
                solicitudRepo.delete(solicitud);
                System.out.println("Solicitud con ID " + id + " eliminada.");
                return solicitud;
            } else {
                System.out.println("Solicitud con ID " + id + " no encontrada.");
                return null;
            }
        }


}
