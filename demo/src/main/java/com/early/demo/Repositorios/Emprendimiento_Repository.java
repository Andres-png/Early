package com.early.demo.Repositorios;

import com.early.demo.Entidades.Emprendimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Emprendimiento_Repository extends JpaRepository<Emprendimiento,Integer> {
}
