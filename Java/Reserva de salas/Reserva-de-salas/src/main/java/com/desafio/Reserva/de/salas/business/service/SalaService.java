package com.desafio.Reserva.de.salas.business.service;

import com.desafio.Reserva.de.salas.infrastructure.model.Sala;
import com.desafio.Reserva.de.salas.infrastructure.repository.SalaRepository;
import jakarta.validation.Valid;
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

    public void deletarSala(Long id) {
        if (!salaRepository.existsById(id)) {
            throw new IllegalArgumentException("Sala com id " + id + " não encontrada.");
        }
        salaRepository.deleteById(id);
    }

    public void atualizarSala(Long id, @Valid Sala salaAtualizada) {
        Sala salaExistente = salaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Sala com id " + id + " não encontrada."));
        salaExistente.setNome(salaAtualizada.getNome());
        salaExistente.setCapacidade(salaAtualizada.getCapacidade());

        salaRepository.save(salaExistente);
    }
}
