package com.early.demo.Entidades;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_solicitud;

    @Column(nullable = false)
    private Date fecha_creacion;

    @Column(nullable = false)
    private Date fecha_entrega;

    @Column(nullable = false, length = 200)
    private String descripcion;

    @Column(nullable = false, length = 20)
    private String metodo_pago;

    @Column(nullable = false, length = 5)
    private int calificacion_cliente;

    // Relación muchas solicitudes un usuario
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    // Relación una solicitud un paquete
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paquete_id", referencedColumnName = "id_paquete")
    private Paquete paquete;

    public Solicitud() {
    }

    public Solicitud(int id_solicitud, Date fecha_creacion, Date fecha_entrega, String descripcion, String metodo_pago, int calificacion_cliente, Usuario usuario, Paquete paquete) {
        this.id_solicitud = id_solicitud;
        this.fecha_creacion = fecha_creacion;
        this.fecha_entrega = fecha_entrega;
        this.descripcion = descripcion;
        this.metodo_pago = metodo_pago;
        this.calificacion_cliente = calificacion_cliente;
        this.usuario = usuario;
        this.paquete = paquete;
    }

    @Override
    public String toString() {
        return "Solicitud{" +
                "id_solicitud=" + id_solicitud +
                ", fecha_creacion=" + fecha_creacion +
                ", fecha_entrega=" + fecha_entrega +
                ", descripcion='" + descripcion + '\'' +
                ", metodo_pago='" + metodo_pago + '\'' +
                ", calificacion_cliente=" + calificacion_cliente +
                ", usuario=" + usuario +
                ", paquete=" + paquete +
                '}';
    }

    public int getId_solicitud() {
        return id_solicitud;
    }

    public void setId_solicitud(int id_solicitud) {
        this.id_solicitud = id_solicitud;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public Date getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(Date fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMetodo_pago() {
        return metodo_pago;
    }

    public void setMetodo_pago(String metodo_pago) {
        this.metodo_pago = metodo_pago;
    }

    public int getCalificacion_cliente() {
        return calificacion_cliente;
    }

    public void setCalificacion_cliente(int calificacion_cliente) {
        this.calificacion_cliente = calificacion_cliente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Paquete getPaquete() {
        return paquete;
    }

    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }
}