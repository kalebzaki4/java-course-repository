package com.desafio.Reserva.de.salas.business.service;

import com.desafio.Reserva.de.salas.infrastructure.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class LimpezaReservaTask {
    @Autowired
    private ReservaRepository reservaRepository;

    @Scheduled(fixedRate = 3600000)
    public void excluirReservasVencidas() {
        LocalDate hoje = LocalDate.now();
        LocalTime agora = LocalTime.now();
        reservaRepository.deleteByDataReservaBeforeOrDataReservaAndHoraFimBefore(hoje, hoje, agora);

        System.out.println("🧹 Faxina realizada: Reservas antigas removidas.");
    }
}