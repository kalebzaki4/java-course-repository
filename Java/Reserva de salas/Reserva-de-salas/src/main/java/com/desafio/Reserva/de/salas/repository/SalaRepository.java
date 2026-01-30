package com.desafio.Reserva.de.salas.repository;

import com.desafio.Reserva.de.salas.model.Sala;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaRepository extends JpaRepository<Sala, Long> {
}
