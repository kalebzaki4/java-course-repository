package com.desafio.Reserva.de.salas.controller;

import com.desafio.Reserva.de.salas.model.Reserva;
import com.desafio.Reserva.de.salas.repository.ReservaRepository;
import com.desafio.Reserva.de.salas.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @Autowired
    private ReservaRepository reservaRepository;

    // Endpoint para listar todas as reservas
    @GetMapping("/reservas")
    public List<Reserva> listarTodasReservas() {
        return reservaRepository.findAll();
    }

    // Endpoint para buscar uma reserva por ID
    @GetMapping("/reservas/{id} ")
    public Reserva buscarReservaPorId(int id) {
        return reservaRepository.findById((long) id).orElse(null);
    }

    // Endpoint para criar uma nova reserva
    @PostMapping("/reservas")
    public String criarReserva(Reserva reserva) {
        try {
            this.reservaService.CriarReserva(reserva);
            return "Reserva criada com sucesso!";
        } catch (IllegalArgumentException e) {
            return "Erro ao criar reserva: " + e.getMessage();
        }
    }

    // Endpoint para deletar ou ccancelar uma reserva por ID
    @PostMapping("/reservas/deletar/{id}")
    public String deletarReservaPorId(int id) {
        try {
            this.reservaService.DeletarReservaPorId((long) id);
            return "Reserva deletada com sucesso!";
        } catch (IllegalArgumentException e) {
            return "Erro ao deletar reserva: " + e.getMessage();
        }
    }
}