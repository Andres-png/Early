package com.early.demo.Entidades;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false, length = 20)
    private String email_celular;

    @Column(nullable = false, length = 15)
    private String contraseña;

    @Column(name = "fecha_creacion", nullable = false)
    private Date fechaCreacion;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Rol rol;

    @Column(nullable = true, length = 15)
    private String Zona;

    @Column(nullable = true)
    private Boolean Estado;

    @Enumerated(EnumType.STRING)
    @Column(nullable = true, length = 15)
    private Vehiculos vehiculo;

    @Column(nullable = false, length = 15)
    private String direccion;

    // Relación un usuario muchos paquetes
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Paquete> paquetes;

    // Relación un usuario muchas solicitudes
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Solicitud> solicitudes;


    public Usuario() {
    }

    public Usuario(Integer id, String nombre, String email_celular, String contraseña, Date fechaCreacion, Rol rol, String zona, Boolean estado, Vehiculos vehiculo, String direccion, List<Paquete> paquetes, List<Solicitud> solicitudes) {
        this.id = id;
        this.nombre = nombre;
        this.email_celular = email_celular;
        this.contraseña = contraseña;
        this.fechaCreacion = fechaCreacion;
        this.rol = rol;
        Zona = zona;
        Estado = estado;
        this.vehiculo = vehiculo;
        this.direccion = direccion;
        this.paquetes = paquetes;
        this.solicitudes = solicitudes;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email_celular='" + email_celular + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", rol=" + rol +
                ", Zona='" + Zona + '\'' +
                ", Estado=" + Estado +
                ", vehiculo=" + vehiculo +
                ", direccion='" + direccion + '\'' +
                ", paquetes=" + paquetes +
                ", solicitudes=" + solicitudes +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail_celular() {
        return email_celular;
    }

    public void setEmail_celular(String email_celular) {
        this.email_celular = email_celular;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getZona() {
        return Zona;
    }

    public void setZona(String zona) {
        Zona = zona;
    }

    public Boolean getEstado() {
        return Estado;
    }

    public void setEstado(Boolean estado) {
        this.Estado = estado;
    }

    public Vehiculos getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculos vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Paquete> getPaquetes() {
        return paquetes;
    }

    public void setPaquetes(List<Paquete> paquetes) {
        this.paquetes = paquetes;
    }

    public List<Solicitud> getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(List<Solicitud> solicitudes) {
        this.solicitudes = solicitudes;
    }
}

