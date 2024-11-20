package com.early.demo.Entidades;

import jakarta.persistence.*;

@Entity
public class Paquete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_paquete;

    @Column(nullable = false)
    private boolean estado;

    @Column(nullable = false, length = 50)
    private String direccion_entrega;

    @Column(nullable = false, length = 50)
    private String direccion_recogida;

    @Column(nullable = false, length = 50)
    private int costo_por_tamaño;

    // Relación muchos paquetes un usuario
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @OneToOne(mappedBy = "paquete", cascade = CascadeType.ALL)
    private Solicitud solicitud;

    public Paquete() {
    }

    public Paquete(int id_paquete, boolean estado, String direccion_entrega, String direccion_recogida, int costo_por_tamaño, Usuario usuario, Solicitud solicitud) {
        this.id_paquete = id_paquete;
        this.estado = estado;
        this.direccion_entrega = direccion_entrega;
        this.direccion_recogida = direccion_recogida;
        this.costo_por_tamaño = costo_por_tamaño;
        this.usuario = usuario;
        this.solicitud = solicitud;
    }

    @Override
    public String toString() {
        return "Paquete{" +
                "id_paquete=" + id_paquete +
                ", estado=" + estado +
                ", direccion_entrega='" + direccion_entrega + '\'' +
                ", direccion_recogida='" + direccion_recogida + '\'' +
                ", costo_por_tamaño=" + costo_por_tamaño +
                ", usuario=" + usuario +
                ", solicitud=" + solicitud +
                '}';
    }

    public int getId_paquete() {
        return id_paquete;
    }

    public void setId_paquete(int id_paquete) {
        this.id_paquete = id_paquete;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getDireccion_entrega() {
        return direccion_entrega;
    }

    public void setDireccion_entrega(String direccion_entrega) {
        this.direccion_entrega = direccion_entrega;
    }

    public String getDireccion_recogida() {
        return direccion_recogida;
    }

    public void setDireccion_recogida(String direccion_recogida) {
        this.direccion_recogida = direccion_recogida;
    }

    public int getCosto_por_tamaño() {
        return costo_por_tamaño;
    }

    public void setCosto_por_tamaño(int costo_por_tamaño) {
        this.costo_por_tamaño = costo_por_tamaño;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }
}
