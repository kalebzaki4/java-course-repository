package com.desafio.Reserva.de.salas.infrastructure.repository;

import com.desafio.Reserva.de.salas.infrastructure.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    boolean existsBySalaIdAndDataReservaAndHoraInicioBeforeAndHoraFimAfter(
            Long salaId, LocalDate data, LocalTime horaFim, LocalTime horaInicio
    );

    @Modifying
    @Transactional
    void deleteByDataReservaBeforeOrDataReservaAndHoraFimBefore(
            LocalDate dataLimite,
            LocalDate hoje,
            LocalTime agora
    );
}
