package com.desafio.Reserva.de.salas.controller;

import com.desafio.Reserva.de.salas.infrastructure.model.Sala;
import com.desafio.Reserva.de.salas.business.service.SalaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/salas")
@RestController
public class SalaController {

    private final SalaService salaService;

    public SalaController(SalaService salaService) {
        this.salaService = salaService;
    }

    @GetMapping
    public ResponseEntity<?> listarSalas() {
        try {
            List<Sala> salas = salaService.listarSalas();
            return ResponseEntity.ok(salas);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao listar: " + e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<String> criarSala(@Valid @RequestBody Sala sala) {
        try {
            this.salaService.criarSala(sala);
            return ResponseEntity.status(HttpStatus.CREATED).body("Sala criada com sucesso!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarSala(@PathVariable Long id) {
        try {
            this.salaService.deletarSala(id);
            return ResponseEntity.ok("Sala deletada com sucesso!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarSala(@PathVariable Long id, @Valid @RequestBody Sala salaAtualizada) {
        try {
            this.salaService.atualizarSala(id, salaAtualizada);
            return ResponseEntity.ok("Sala atualizada com sucesso!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}


