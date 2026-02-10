package com.desafio.Reserva.de.salas.business.service;

import com.desafio.Reserva.de.salas.infrastructure.model.Usuario;
import com.desafio.Reserva.de.salas.infrastructure.repository.UsuarioRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public Page<Usuario> listarUsuarios(Pageable pageable) {
        return usuarioRepository.findAll(pageable);
    }

    @Transactional
    public Usuario criarUsuario(@Valid Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Transactional
    public void deletarUsuario(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new IllegalArgumentException("Usuário com id " + id + " não encontrado.");
        }
        usuarioRepository.deleteById(id);
    }

    @Transactional
    public Usuario atualizarUsuario(Long id, @Valid Usuario usuarioAtualizado) {
        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuário com id " + id + " não encontrado."));
        usuarioExistente.setNome(usuarioAtualizado.getNome());

        return usuarioRepository.save(usuarioExistente);
    }
}