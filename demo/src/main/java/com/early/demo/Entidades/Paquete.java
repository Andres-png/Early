package com.early.demo.Entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "paquetes")
public class Paquete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPaquete;

    @Column(nullable = false, length = 50)
    private String estadoPaquete;

    @Column(nullable = false)
    private Double peso;

    @Column(nullable = false)
    private Double costo;

    @Column(nullable = false, length = 100)
    private String nombreReceptor;

    @ManyToOne
    @JoinColumn(name = "solicitud_id", nullable = false)
    private Solicitud solicitud;

    @ManyToOne
    @JoinColumn(name = "mensajero_id", nullable = false)
    private Mensajero mensajero;

    public Paquete() {
    }

    public Paquete(Integer idPaquete, String estadoPaquete, Double peso, Double costo, String nombreReceptor, Solicitud solicitud, Mensajero mensajero) {
        this.idPaquete = idPaquete;
        this.estadoPaquete = estadoPaquete;
        this.peso = peso;
        this.costo = costo;
        this.nombreReceptor = nombreReceptor;
        this.solicitud = solicitud;
        this.mensajero = mensajero;
    }

    @Override
    public String toString() {
        return "Paquete{" +
                "idPaquete=" + idPaquete +
                ", estadoPaquete='" + estadoPaquete + '\'' +
                ", peso=" + peso +
                ", costo=" + costo +
                ", nombreReceptor='" + nombreReceptor + '\'' +
                ", solicitud=" + solicitud +
                ", mensajero=" + mensajero +
                '}';
    }

    public Integer getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(int idPaquete) {
        this.idPaquete = idPaquete;
    }

    public String getEstadoPaquete() {
        return estadoPaquete;
    }

    public void setEstadoPaquete(String estadoPaquete) {
        this.estadoPaquete = estadoPaquete;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public String getNombreReceptor() {
        return nombreReceptor;
    }

    public void setNombreReceptor(String nombreReceptor) {
        this.nombreReceptor = nombreReceptor;
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }

    public Mensajero getMensajero() {
        return mensajero;
    }

    public void setMensajero(Mensajero mensajero) {
        this.mensajero = mensajero;
    }
}


