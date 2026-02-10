package com.desafio.Reserva.de.salas.business.service;

import com.desafio.Reserva.de.salas.infrastructure.exception.EntidadeNaoEncontradaException;
import com.desafio.Reserva.de.salas.infrastructure.model.Reserva;
import com.desafio.Reserva.de.salas.infrastructure.model.Sala;
import com.desafio.Reserva.de.salas.infrastructure.repository.ReservaRepository;
import com.desafio.Reserva.de.salas.infrastructure.repository.SalaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private SalaRepository salaRepository;

    // criar uma reserva
    public void CriarReserva(Reserva reserva) {
        if (reserva.getSala() == null || reserva.getSala().getId() == null) {
            throw new IllegalArgumentException("O ID da sala deve ser informado.");
        }

        Sala salaExistente = salaRepository.findById(reserva.getSala().getId()).orElseThrow(() -> new IllegalArgumentException("A sala especificada não existe"));

        boolean conflito = reservaRepository.existsBySalaIdAndDataReservaAndHoraInicioBeforeAndHoraFimAfter(salaExistente.getId(), reserva.getDataReserva(), reserva.getHoraFim(), reserva.getHoraInicio());

        if (conflito) {
            throw new IllegalArgumentException("Conflito de horário: A sala já está reservada nesse período.");
        }

        reserva.setSala(salaExistente);
        reservaRepository.save(reserva);
    }

    // deletar uma reserva por ID
    public void DeletarReservaPorId(Long id) {
        if (!reservaRepository.existsById(id)) {
            throw new EntidadeNaoEncontradaException("Reserva com ID " + id + " não encontrada.");
        } else {
            reservaRepository.deleteById(id);
            System.out.println("Reserva com ID " + id + " deletada com sucesso.");
        }
    }

    // listar todas as reservas
    public List<Reserva> ListarTodasReservas() {
        try {
            return reservaRepository.findAll();
        } catch (Exception e) {
            throw new IllegalArgumentException("Erro ao listar reservas: " + e.getMessage());
        }
    }

    // atualizar usuario
    public void AtualizarReserva(Long id, @Valid Reserva reservaAtualizada) {
        Reserva reservaExistente = reservaRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Reserva com ID " + id + " não encontrada."));
    }

}
