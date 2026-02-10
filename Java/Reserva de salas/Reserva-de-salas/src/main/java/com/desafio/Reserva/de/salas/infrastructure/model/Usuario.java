package com.desafio.Reserva.de.salas.infrastructure.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuarioId;

    @NotBlank (message = "O nome do usuário é obrigatório")
    private String nome;

    @NotBlank (message = "O email do usuário é obrigatório")
    private String email;

    @NotBlank (message = "A senha do usuário é obrigatória")
    private String senha;
}
