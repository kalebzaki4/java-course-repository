package com.desafio.Reserva.de.salas.service;

import com.desafio.Reserva.de.salas.model.Reserva;
import com.desafio.Reserva.de.salas.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    // Método para salvar uma reserva
    public void CriarReserva(Reserva reserva) {
        if (reserva == null) {
            throw new IllegalArgumentException("A reserva não pode ser nula");
        }
        if (reserva.getDataHoraInicio() == null || reserva.getDataHoraFim() == null) {
            throw new IllegalArgumentException("O horário de início e fim da reserva não podem ser nulos");
        }
        if (reserva.getDataHoraFim().isBefore(reserva.getDataHoraInicio())) {
            throw new IllegalArgumentException("O horário de fim da reserva não pode ser antes do horário de início");
        }
        if (reservaRepository.existsById((long) reserva.getId())) {
            throw new IllegalArgumentException("Já existe uma reserva com este ID");
        } else {
            reservaRepository.save(reserva);
        }
    }

    // Metodo para deletar uma reserva por ID
    public void DeletarReservaPorId(Long id) {
        if (!reservaRepository.existsById(id)) {
            throw new IllegalArgumentException("Reserva não encontrada com o ID: " + id);
        } else {
            reservaRepository.deleteById(id);
        }
    }
}
