package com.early.demo.Entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "clientes")
public class Cliente extends Usuario {
    @Column(nullable = false, length = 255)
    private String direccion;

    @OneToMany(mappedBy = "cliente")
    private List<Solicitud> solicitudes;

    public Cliente() {

    }

    public Cliente(String direccion, List<Solicitud> solicitudes) {
        this.direccion = direccion;
        this.solicitudes = solicitudes;
    }

    public Cliente(Integer idUsuario, String nombre, String telefono, String email, String contrasena, LocalDate fechaCreacion, String rol, String direccion, List<Solicitud> solicitudes) {
        super(idUsuario, nombre, telefono, email, contrasena, fechaCreacion, rol);
        this.direccion = direccion;
        this.solicitudes = solicitudes;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "direccion='" + direccion + '\'' +
                ", solicitudes=" + solicitudes +
                '}';
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Solicitud> getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(List<Solicitud> solicitudes) {
        this.solicitudes = solicitudes;
    }
}

