package com.early.demo.Repositorios;

import com.early.demo.Entidades.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Administrador_Repository extends JpaRepository<Administrador,Long> {
}
