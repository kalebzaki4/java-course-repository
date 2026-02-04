package com.desafio.Reserva.de.salas.business.service;

import com.desafio.Reserva.de.salas.controller.UsuarioController;
import com.desafio.Reserva.de.salas.infrastructure.model.Usuario;
import com.desafio.Reserva.de.salas.infrastructure.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> ListarUsuarios() {
        try {
            return usuarioRepository.findAll();
        } catch (Exception e) {
            throw new IllegalArgumentException("Erro ao listar usuarios: " + e.getMessage());
        }
    }

    public void criarUsuario() {
        try {
            Usuario usuario = new Usuario();
            usuario.setNome("Usuario " + System.currentTimeMillis());
            usuarioRepository.save(usuario);
        } catch (Exception e) {
            throw new IllegalArgumentException("Erro ao criar usuario: " + e.getMessage());
        }
    }
}
