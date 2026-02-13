package com.desafio.Reserva.de.salas.infrastructure.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "salas")
@Data
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome da sala é obrigatório")
    private String nome;

    @Positive(message = "A capacidade deve ser um número positivo")
    private Integer capacidade;

    @AssertTrue(message = "A sala deve estar ativa ou inativa")
    private Boolean ativo;

    @OneToMany(mappedBy = "sala", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reserva> reservas;
}
