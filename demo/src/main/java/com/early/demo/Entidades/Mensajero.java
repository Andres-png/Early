package com.early.demo.Entidades;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "mensajeros")
public class Mensajero extends Usuario {
    @Column(nullable = false, length = 100)
    private String zona;

    @Column(nullable = false, length = 50)
    private String estado;

    @Column(nullable = false, length = 100)
    private String vehiculo;

    @OneToMany(mappedBy = "mensajero")
    private List<Solicitud> solicitudes;

    @OneToMany(mappedBy = "mensajero")
    private List<Paquete> paquetes;

    public Mensajero() {

    }

    public Mensajero(String zona, String estado, String vehiculo, List<Solicitud> solicitudes, List<Paquete> paquetes) {
        this.zona = zona;
        this.estado = estado;
        this.vehiculo = vehiculo;
        this.solicitudes = solicitudes;
        this.paquetes = paquetes;
    }

    public Mensajero(Integer idUsuario, String nombre, String telefono, String email, String contrasena, LocalDate fechaCreacion, String rol, String zona, String estado, String vehiculo, List<Solicitud> solicitudes, List<Paquete> paquetes) {
        super(idUsuario, nombre, telefono, email, contrasena, fechaCreacion, rol);
        this.zona = zona;
        this.estado = estado;
        this.vehiculo = vehiculo;
        this.solicitudes = solicitudes;
        this.paquetes = paquetes;
    }

    @Override
    public String toString() {
        return "Mensajero{" +
                "zona='" + zona + '\'' +
                ", estado='" + estado + '\'' +
                ", vehiculo='" + vehiculo + '\'' +
                ", solicitudes=" + solicitudes +
                ", paquetes=" + paquetes +
                '}';
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }

    public List<Solicitud> getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(List<Solicitud> solicitudes) {
        this.solicitudes = solicitudes;
    }

    public List<Paquete> getPaquetes() {
        return paquetes;
    }

    public void setPaquetes(List<Paquete> paquetes) {
        this.paquetes = paquetes;
    }
}
