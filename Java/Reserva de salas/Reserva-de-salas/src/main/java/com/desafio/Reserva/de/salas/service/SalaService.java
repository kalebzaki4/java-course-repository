package com.desafio.Reserva.de.salas.service;

import com.desafio.Reserva.de.salas.model.Sala;
import com.desafio.Reserva.de.salas.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaService {

    @Autowired
    private SalaRepository salaRepository;

    public List<Sala> listarSalas() {
        return salaRepository.findAll();
    }

    public void criarSala(Sala sala) {
        try {
            salaRepository.save(sala);
        } catch (Exception e) {
            throw new IllegalArgumentException("Erro ao criar sala: " + e.getMessage());
        }
    }
}
