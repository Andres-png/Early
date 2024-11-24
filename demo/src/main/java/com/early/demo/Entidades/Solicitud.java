package com.early.demo.Entidades;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "solicitudes")
public class Solicitud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSolicitud;

    @Column(nullable = false)
    private LocalDate fechaCreacion;

    @Column(nullable = false, length = 50)
    private String estadoSolicitud;

    @Column(nullable = false, length = 50)
    private String metodoPago;

    @Column(length = 255)
    private String descripcion;

    @Column(nullable = false, length = 255)
    private String direccionEntrega;

    @Column(nullable = false, length = 255)
    private String direccionRecogida;

    @Column
    private Integer calificacionCliente;

    @Column
    private Integer calificacionMensajero;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "emprendimiento_id", nullable = false)
    private Emprendimiento emprendimiento;

    @ManyToOne
    @JoinColumn(name = "mensajero_id")
    private Mensajero mensajero;

    @OneToMany(mappedBy = "solicitud")
    private List<Paquete> paquetes;

    public Solicitud() {
    }

    public Solicitud(int idSolicitud, LocalDate fechaCreacion, String estadoSolicitud, String metodoPago, String descripcion, String direccionEntrega, String direccionRecogida, Integer calificacionCliente, Integer calificacionMensajero, Cliente cliente, Emprendimiento emprendimiento, Mensajero mensajero, List<Paquete> paquetes) {
        this.idSolicitud = idSolicitud;
        this.fechaCreacion = fechaCreacion;
        this.estadoSolicitud = estadoSolicitud;
        this.metodoPago = metodoPago;
        this.descripcion = descripcion;
        this.direccionEntrega = direccionEntrega;
        this.direccionRecogida = direccionRecogida;
        this.calificacionCliente = calificacionCliente;
        this.calificacionMensajero = calificacionMensajero;
        this.cliente = cliente;
        this.emprendimiento = emprendimiento;
        this.mensajero = mensajero;
        this.paquetes = paquetes;
    }

    @Override
    public String toString() {
        return "Solicitud{" +
                "idSolicitud=" + idSolicitud +
                ", fechaCreacion=" + fechaCreacion +
                ", estadoSolicitud='" + estadoSolicitud + '\'' +
                ", metodoPago='" + metodoPago + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", direccionEntrega='" + direccionEntrega + '\'' +
                ", direccionRecogida='" + direccionRecogida + '\'' +
                ", calificacionCliente=" + calificacionCliente +
                ", calificacionMensajero=" + calificacionMensajero +
                ", cliente=" + cliente +
                ", emprendimiento=" + emprendimiento +
                ", mensajero=" + mensajero +
                ", paquetes=" + paquetes +
                '}';
    }

    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getEstadoSolicitud() {
        return estadoSolicitud;
    }

    public void setEstadoSolicitud(String estadoSolicitud) {
        this.estadoSolicitud = estadoSolicitud;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public String getDireccionRecogida() {
        return direccionRecogida;
    }

    public void setDireccionRecogida(String direccionRecogida) {
        this.direccionRecogida = direccionRecogida;
    }

    public Integer getCalificacionCliente() {
        return calificacionCliente;
    }

    public void setCalificacionCliente(Integer calificacionCliente) {
        this.calificacionCliente = calificacionCliente;
    }

    public Integer getCalificacionMensajero() {
        return calificacionMensajero;
    }

    public void setCalificacionMensajero(Integer calificacionMensajero) {
        this.calificacionMensajero = calificacionMensajero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Emprendimiento getEmprendimiento() {
        return emprendimiento;
    }

    public void setEmprendimiento(Emprendimiento emprendimiento) {
        this.emprendimiento = emprendimiento;
    }

    public Mensajero getMensajero() {
        return mensajero;
    }

    public void setMensajero(Mensajero mensajero) {
        this.mensajero = mensajero;
    }

    public List<Paquete> getPaquetes() {
        return paquetes;
    }

    public void setPaquetes(List<Paquete> paquetes) {
        this.paquetes = paquetes;
    }
}

