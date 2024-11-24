package com.early.demo.Repositorios;

import com.early.demo.Entidades.Mensajero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Mensajero_Repository extends JpaRepository<Mensajero,Integer> {
}
