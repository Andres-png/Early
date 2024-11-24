package com.early.demo.Entidades;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "emprendimientos")
public class Emprendimiento extends Usuario {
    @Column(nullable = false, length = 100)
    private String representanteLegal;

    @Column(nullable = false, length = 20, unique = true)
    private String nidEmprendimiento;

    @Column(nullable = false, length = 100)
    private String nombreEmprendimiento;

    @Column(nullable = false, length = 255)
    private String direccion;

    @Column(nullable = false, length = 50)
    private String categoria;

    @OneToMany(mappedBy = "emprendimiento")
    private List<Solicitud> solicitudes;

    public Emprendimiento() {

    }

    public Emprendimiento(String representanteLegal, String nidEmprendimiento, String nombreEmprendimiento, String direccion, String categoria, List<Solicitud> solicitudes) {
        this.representanteLegal = representanteLegal;
        this.nidEmprendimiento = nidEmprendimiento;
        this.nombreEmprendimiento = nombreEmprendimiento;
        this.direccion = direccion;
        this.categoria = categoria;
        this.solicitudes = solicitudes;
    }

    public Emprendimiento(Long idUsuario, String nombre, String telefono, String email, String contrasena, LocalDate fechaCreacion, String rol, String representanteLegal, String nidEmprendimiento, String nombreEmprendimiento, String direccion, String categoria, List<Solicitud> solicitudes) {
        super(idUsuario, nombre, telefono, email, contrasena, fechaCreacion, rol);
        this.representanteLegal = representanteLegal;
        this.nidEmprendimiento = nidEmprendimiento;
        this.nombreEmprendimiento = nombreEmprendimiento;
        this.direccion = direccion;
        this.categoria = categoria;
        this.solicitudes = solicitudes;
    }

    @Override
    public String toString() {
        return "Emprendimiento{" +
                "representanteLegal='" + representanteLegal + '\'' +
                ", nidEmprendimiento='" + nidEmprendimiento + '\'' +
                ", nombreEmprendimiento='" + nombreEmprendimiento + '\'' +
                ", direccion='" + direccion + '\'' +
                ", categoria='" + categoria + '\'' +
                ", solicitudes=" + solicitudes +
                '}';
    }

    public String getRepresentanteLegal() {
        return representanteLegal;
    }

    public void setRepresentanteLegal(String representanteLegal) {
        this.representanteLegal = representanteLegal;
    }

    public String getNidEmprendimiento() {
        return nidEmprendimiento;
    }

    public void setNidEmprendimiento(String nidEmprendimiento) {
        this.nidEmprendimiento = nidEmprendimiento;
    }

    public String getNombreEmprendimiento() {
        return nombreEmprendimiento;
    }

    public void setNombreEmprendimiento(String nombreEmprendimiento) {
        this.nombreEmprendimiento = nombreEmprendimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public List<Solicitud> getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(List<Solicitud> solicitudes) {
        this.solicitudes = solicitudes;
    }
}
