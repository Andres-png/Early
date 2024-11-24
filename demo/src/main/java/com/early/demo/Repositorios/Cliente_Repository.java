package com.early.demo.Repositorios;

import com.early.demo.Entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Cliente_Repository extends JpaRepository<Cliente,Integer> {
}
