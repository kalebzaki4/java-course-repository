package com.desafio.Reserva.de.salas.repository;

import com.desafio.Reserva.de.salas.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

}
