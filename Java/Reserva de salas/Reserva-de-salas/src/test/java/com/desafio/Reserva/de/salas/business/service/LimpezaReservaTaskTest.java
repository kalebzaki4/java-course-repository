package com.desafio.Reserva.de.salas.business.service;


import com.desafio.Reserva.de.salas.infrastructure.repository.ReservaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.*;

@ExtendWith(MockitoExtension.class)
public class LimpezaReservaTaskTest {

    @InjectMocks
    private LimpezaReservaTask limpezaReservaTask;

    @Mock
    private ReservaRepository reservaRepository;

    @BeforeEach
    public void setUp() {
        Instant instanteFixo = Instant.parse("2026-02-10T10:00:00Z");
        ZoneId zoneId = ZoneId.of("UTC");
        limpezaReservaTask.setClock(Clock.fixed(instanteFixo, zoneId));
    }

    @Test
    public void testExcluirReservasVencidas() {
        // arrange
        LocalDate hoje = LocalDate.now(limpezaReservaTask.getClock());
        LocalTime agora = LocalTime.now(limpezaReservaTask.getClock());
        LocalDate dataLimite = hoje.minusDays(1);

        // act
        limpezaReservaTask.excluirReservasVencidas();

        // verify
        Mockito.verify(reservaRepository, Mockito.times(1))
                .deleteByDataReservaBeforeOrDataReservaAndHoraFimBefore(
                        dataLimite, hoje, agora
                );

    }

    @Test
    public void deveLancarExceptionQuandoRepositorioFalhar() {
        Mockito.doThrow(new RuntimeException("Erro de conexão"))
                .when(reservaRepository)
                .deleteByDataReservaBeforeOrDataReservaAndHoraFimBefore(
                        Mockito.any(LocalDate.class),
                        Mockito.any(LocalDate.class),
                        Mockito.any(LocalTime.class)
                );

        Assertions.assertThrows(RuntimeException.class, () -> {
            limpezaReservaTask.excluirReservasVencidas();
        });
    }

    @Test
    public void deveManterReservaQuandoHorarioFimForIgualAoHorarioAtual() {
        // arrange
        LocalTime agora = LocalTime.now(limpezaReservaTask.getClock());
        LocalDate hoje = LocalDate.now(limpezaReservaTask.getClock());
        LocalDate dataLimite = hoje.minusDays(1);
        LocalTime horarioEsperado = LocalTime.of(10, 0, 0);

        // act
        limpezaReservaTask.excluirReservasVencidas();

        // verify
        Mockito.verify(reservaRepository, Mockito.times(1))
                .deleteByDataReservaBeforeOrDataReservaAndHoraFimBefore(
                        dataLimite, hoje, agora
                );

        Assertions.assertEquals(horarioEsperado, agora, "O horário atual deve ser igual ao horário usado na exclusão");
    }

    @Test
    public void DeveNuncaApagarReservasCasoEstejaVazio() {
        // arrange
        Mockito.when(reservaRepository.count()).thenReturn(0L);

        // act
        String resultado = limpezaReservaTask.excluirReservasVencidas();

        // verify
        Mockito.verify(reservaRepository, Mockito.never())
                .deleteByDataReservaBeforeOrDataReservaAndHoraFimBefore(
                        Mockito.any(LocalDate.class),
                        Mockito.any(LocalDate.class),
                        Mockito.any(LocalTime.class)
                );
        Assertions.assertEquals("Ops! Nenhuma reserva encontrada.", resultado);
    }

    @Test
    public void deveLaancarDataAccessExceptionCasoRepositorioEstejaIndisponivel() {
        // Arrange
        Mockito.when(reservaRepository.count())
                .thenThrow(new RuntimeException("Banco fora do ar"));

        // Act & Assert
        Assertions.assertThrows(RuntimeException.class, () -> {
            limpezaReservaTask.excluirReservasVencidas();
        });

        // Verify
        Mockito.verify(reservaRepository, Mockito.never())
                .deleteByDataReservaBeforeOrDataReservaAndHoraFimBefore(
                        Mockito.any(), Mockito.any(), Mockito.any()
                );
    }

}
