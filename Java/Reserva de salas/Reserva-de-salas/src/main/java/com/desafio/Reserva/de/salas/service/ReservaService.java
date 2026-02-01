package com.desafio.Reserva.de.salas.service;

import com.desafio.Reserva.de.salas.model.Reserva;
import com.desafio.Reserva.de.salas.model.Sala;
import com.desafio.Reserva.de.salas.repository.ReservaRepository;
import com.desafio.Reserva.de.salas.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private SalaRepository salaRepository;

    // Método para criar uma reserva
    public void CriarReserva(Reserva reserva) {
        if (reserva == null) {
            throw new IllegalArgumentException("A reserva não pode ser nula");
        }
        if (reserva.getHoraInicio() == null || reserva.getHoraFim() == null) {
            throw new IllegalArgumentException("O horário de início e fim da reserva não podem ser nulos");
        }
        if (reserva.getDataHoraFim().isBefore(reserva.getDataHoraInicio())) {
            throw new IllegalArgumentException("O horário de fim da reserva não pode ser antes do horário de início");
        }
        if (reservaRepository.existsById((long) reserva.getId())) {
            throw new IllegalArgumentException("Já existe uma reserva com este ID");
        } else {
            Sala salaExistente = salaRepository.findById((long) reserva.getNomeSala().getId())
                    .orElseThrow(() -> new IllegalArgumentException("A sala especificada não existe"));
            reserva.setNomeSala(salaExistente);
            reservaRepository.save(reserva);
        }
    }

    // Metodo para deletar uma reserva por ID
    public void DeletarReservaPorId(Long id) {
        if (!reservaRepository.existsById(id)) {
            throw new IllegalArgumentException("Reserva não encontrada com o ID: " + id);
        } else {
            reservaRepository.deleteById(id);
            System.out.println("Reserva com ID " + id + " deletada com sucesso.");
        }
    }


}
