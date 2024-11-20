package com.early.demo.Repositorios;

import com.early.demo.Entidades.Paquete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Paquete_Repository extends JpaRepository<Paquete,Integer> {
}
