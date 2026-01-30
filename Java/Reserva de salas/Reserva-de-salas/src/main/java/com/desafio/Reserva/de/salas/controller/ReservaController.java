package com.desafio.Reserva.de.salas.controller;

import com.desafio.Reserva.de.salas.model.Reserva;
import com.desafio.Reserva.de.salas.repository.ReservaRepository;
import com.desafio.Reserva.de.salas.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<String> criarReserva(@RequestBody Reserva reserva) {
        try {
            reservaService.CriarReserva(reserva);
            return ResponseEntity.status(HttpStatus.CREATED).body("Reserva criada com sucesso!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Endpoint para deletar ou ccancelar uma reserva por ID
    @DeleteMapping("/reservas/{id}")
    public ResponseEntity<String> deletarReservaPorId(@PathVariable int id) {
        try {
            this.reservaService.DeletarReservaPorId((long) id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Erro ao deletar reserva: " + e.getMessage());
        }
    }
}