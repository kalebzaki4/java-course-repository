package com.desafio.Reserva.de.salas.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import lombok.Data;

import javax.net.ssl.SSLSession;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table (name = "reservas")
@Data
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nomeReserva;

    @OneToOne
    @JoinColumn(name = "nome_sala")
    private Sala nomeSala;

    @Future
    private LocalDate dataReserva;

    private LocalTime horaInicio;

    private LocalTime horaFim;

    public LocalTime getDataHoraInicio() {
        return horaInicio;
    }

    public LocalTime getDataHoraFim() {
        return horaFim;
    }

}
