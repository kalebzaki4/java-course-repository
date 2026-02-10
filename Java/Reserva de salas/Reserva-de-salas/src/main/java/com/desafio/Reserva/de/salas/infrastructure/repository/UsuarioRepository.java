package com.desafio.Reserva.de.salas.infrastructure.repository;

import com.desafio.Reserva.de.salas.infrastructure.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
