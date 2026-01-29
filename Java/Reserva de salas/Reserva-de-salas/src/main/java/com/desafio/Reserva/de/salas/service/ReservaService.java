package com.desafio.Reserva.de.salas.service;

import com.desafio.Reserva.de.salas.model.Reserva;
import org.springframework.stereotype.Service;

@Service
public class ReservaService {
    public void salvarReserva(Reserva reserva) {
        if (reserva.getHoraInicio().isAfter(reserva.getHoraFim())) {
            throw new IllegalArgumentException("A hora de início deve ser antes da hora de fim.");
        }
    }
}
