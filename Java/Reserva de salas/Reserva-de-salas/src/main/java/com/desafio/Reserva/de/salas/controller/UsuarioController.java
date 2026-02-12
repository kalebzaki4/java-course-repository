package com.desafio.Reserva.de.salas.controller;

import com.desafio.Reserva.de.salas.business.service.UsuarioService;
import com.desafio.Reserva.de.salas.infrastructure.model.Usuario;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.net.URI;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<Page<Usuario>> listarUsuarios(Pageable pageable) {
        Page<Usuario> resultado = this.usuarioService.listarUsuarios(pageable);
        return ResponseEntity.ok(resultado);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Usuario> criarUsuario(@Valid @RequestBody Usuario usuario) {
        Usuario salvo = this.usuarioService.criarUsuario(usuario);
        System.out.println("Usuario criado com ID: " + salvo.getUsuarioId());
        return ResponseEntity.created(URI.create("/usuarios/" + salvo.getUsuarioId())).body(salvo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarUsuario(@PathVariable Long id) {
        this.usuarioService.deletarUsuario(id);
        System.out.println("Usuario com ID " + id + " deletado com sucesso.");
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Long id,
                                                    @Valid @RequestBody Usuario usuarioAtualizado) {
        Usuario atualizado = usuarioService.atualizarUsuario(id, usuarioAtualizado);
        System.out.println("Usuario com ID " + id + " atualizado com sucesso.");
        return ResponseEntity.ok(atualizado);
    }
}