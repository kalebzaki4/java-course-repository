package com.desafio.Reserva.de.salas.controller;

import com.desafio.Reserva.de.salas.infrastructure.exception.EntidadeNaoEncontradaException;
import com.desafio.Reserva.de.salas.infrastructure.model.Reserva;
import com.desafio.Reserva.de.salas.infrastructure.repository.ReservaRepository;
import com.desafio.Reserva.de.salas.business.service.ReservaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @Autowired
    private ReservaRepository reservaRepository;


    // Endpoint para listar todas as reservas
    @GetMapping
    public List<Reserva> listarTodasReservas() {
        return this.reservaService.ListarTodasReservas();
    }

    // Endpoint para buscar uma reserva por ID
    @GetMapping("/{id}")
    public Reserva buscarReservaPorId(@PathVariable Long id) {
        return reservaRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Reserva não encontrada com o ID: " + id));
    }

    // Endpoint para criar uma nova reserva
    @PostMapping
    public ResponseEntity<String> criarReserva(@Valid @RequestBody Reserva reserva) {
        reservaService.CriarReserva(reserva);
        return ResponseEntity.status(HttpStatus.CREATED).body("Reserva criada com sucesso!");
    }

    // Endpoint para deletar ou ccancelar uma reserva por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarReservaPorId(@Valid @PathVariable Long id) {
        this.reservaService.DeletarReservaPorId(id);
        return ResponseEntity.noContent().build();
    }

    // Endpoint para atualizar uma reserva existente
    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarReserva(@PathVariable Long id, @Valid @RequestBody Reserva reservaAtualizada) {
        reservaService.AtualizarReserva(id, reservaAtualizada);
        return ResponseEntity.ok("Reserva atualizada com sucesso!");
    }
}