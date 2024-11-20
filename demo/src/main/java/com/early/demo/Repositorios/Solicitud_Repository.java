package com.early.demo.Repositorios;

import com.early.demo.Entidades.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Solicitud_Repository extends JpaRepository<Solicitud,Integer> {
}
