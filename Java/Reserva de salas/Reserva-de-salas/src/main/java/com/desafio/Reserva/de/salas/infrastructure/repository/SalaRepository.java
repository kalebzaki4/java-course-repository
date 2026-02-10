package com.desafio.Reserva.de.salas.infrastructure.repository;

import com.desafio.Reserva.de.salas.infrastructure.model.Sala;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaRepository extends JpaRepository<Sala, Long> {
}
