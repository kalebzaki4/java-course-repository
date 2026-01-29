package com.desafio.Reserva.de.salas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Entity
@Table(name = "salas")
@Data
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Positive (message = "A capacidade deve ser um número positivo")
    private Integer capacidade;

    @AssertTrue(message = "A sala deve estar ativa ou inativa")
    private Boolean ativo;
}
