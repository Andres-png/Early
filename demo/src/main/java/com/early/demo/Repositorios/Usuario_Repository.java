package com.early.demo.Repositorios;

import com.early.demo.Entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Usuario_Repository extends JpaRepository<Usuario,Integer> {
}
