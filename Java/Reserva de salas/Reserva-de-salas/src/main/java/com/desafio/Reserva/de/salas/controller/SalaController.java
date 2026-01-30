package com.desafio.Reserva.de.salas.controller;

import com.desafio.Reserva.de.salas.model.Sala;
import com.desafio.Reserva.de.salas.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SalaController {

    @Autowired
    private SalaService salaService;

    @GetMapping("/salas")
    public ResponseEntity<?> listarSalas() { // O "?" permite retornar a lista ou erro
        try {
            List<Sala> salas = salaService.listarSalas();
            return ResponseEntity.ok(salas); // Agora o Postman vai mostrar o JSON das salas
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao listar: " + e.getMessage());
        }
    }

    @PostMapping("/salas")
    public ResponseEntity<String> criarSala(@RequestBody Sala sala) {
        try {
            this.salaService.criarSala(sala);
            return ResponseEntity.status(HttpStatus.CREATED).body("Sala criada com sucesso!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}


