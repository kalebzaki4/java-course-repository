package com.desafio.Reserva.de.salas.infrastructure.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "reservas")
@Data
public class Reserva {
    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nome da reserva
    @NotBlank(message = "O nome da reserva é obrigatório")
    private String nomeReserva;

    // Relação ManyToOne com Usuario
    @NotNull(message = "A sala deve ser selecionada")
    @ManyToOne
    @JoinColumn(name = "sala_id")
    private Sala sala;

    @NotNull
    @Future(message = "A reserva deve ser para uma data futura")
    private LocalDate dataReserva;

    // Hora de início da reserva
    @NotNull
    private LocalTime horaInicio;

    // Hora de término da reserva
    @NotNull
    private LocalTime horaFim;

    // Validação para garantir que a hora de término seja após a hora de início
    @AssertTrue(message = "A hora de término deve ser após a hora de início")
    public boolean isHorarioValido() {
        if (horaInicio == null || horaFim == null) return true;
        return horaFim.isAfter(horaInicio);
    }

    // descricão da reserva
    private String descricao;

    // Getters para dataReserva, horaInicio e horaFim
    public LocalTime getDataHoraInicio() {
        return horaInicio;
    }

    // Getter para horaFim
    public LocalTime getDataHoraFim() {
        return horaFim;
    }
}
