package com.desafio.Reserva.de.salas.business.service;

import com.desafio.Reserva.de.salas.infrastructure.model.Usuario;
import com.desafio.Reserva.de.salas.infrastructure.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Page<Usuario> listarUsuarios(Pageable pageable) {
        try {
            return usuarioRepository.findAll(pageable);
        } catch (Exception e) {
            throw new IllegalArgumentException("Erro ao listar usuarios: " + e.getMessage());
        }
    }

    // Metodo para criar usuario
    public void criarUsuario() {
        try {
            Usuario usuario = new Usuario();
            usuario.setNome("Usuario " + System.currentTimeMillis());
            usuarioRepository.save(usuario);
        } catch (Exception e) {
            throw new IllegalArgumentException("Erro ao criar usuario: " + e.getMessage());
        }
    }

    // metodo para deletar usuario
    public void deletarUsuario(Long id) {
        usuarioRepository.deleteById(id);
        System.out.println("Usuario com id " + id + " deletado com sucesso.");
    }

    // metodo para atualizar usuario
    public void atualizarUsuario(Long id, Usuario usuarioAtualizado) {
        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuario com id " + id + " não encontrado."));

        usuarioExistente.setNome(usuarioAtualizado.getNome());

        usuarioRepository.save(usuarioExistente);
        System.out.println("Usuario com id " + id + " atualizado com sucesso.");
    }
}