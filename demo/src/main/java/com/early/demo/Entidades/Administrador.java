package com.early.demo.Entidades;
import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "administradores")
public class Administrador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAdmin;

    @Column(nullable = false, length = 100, unique = true)
    private String email;

    @Column(nullable = false, length = 15)
    private String telefono;

    @OneToMany(mappedBy = "administrador")
    private List<Usuario> usuariosSupervisados;

    public Administrador() {
    }

    public Administrador(Long idAdmin, String email, String telefono, List<Usuario> usuariosSupervisados) {
        this.idAdmin = idAdmin;
        this.email = email;
        this.telefono = telefono;
        this.usuariosSupervisados = usuariosSupervisados;
    }

    @Override
    public String toString() {
        return "Administrador{" +
                "idAdmin=" + idAdmin +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", usuariosSupervisados=" + usuariosSupervisados +
                '}';
    }

    public Long getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(Long idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Usuario> getUsuariosSupervisados() {
        return usuariosSupervisados;
    }

    public void setUsuariosSupervisados(List<Usuario> usuariosSupervisados) {
        this.usuariosSupervisados = usuariosSupervisados;
    }
}

