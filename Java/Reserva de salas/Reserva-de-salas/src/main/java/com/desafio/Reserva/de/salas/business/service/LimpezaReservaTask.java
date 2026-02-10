package com.desafio.Reserva.de.salas.business.service;

import com.desafio.Reserva.de.salas.infrastructure.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class LimpezaReservaTask {
    @Autowired
    ReservaRepository reservaRepository;

    private Clock clock = Clock.systemDefaultZone();

    @Autowired
    public Clock getClock() {
        return this.clock;
    }

    @Autowired
    public void setClock(Clock fixed) {
        this.clock = fixed;
    }

    @Transactional
    @Scheduled(fixedRate = 300000)
    public void excluirReservasVencidas() {
        LocalDate hoje = LocalDate.now(clock);
        LocalTime agora = LocalTime.now(clock);
        LocalDate dataLimite = hoje.minusDays(1);
        reservaRepository.deleteByDataReservaBeforeOrDataReservaAndHoraFimBefore(dataLimite, hoje, agora);

        System.out.println("🧹 Faxina realizada: Reservas antigas removidas.");
    }

}