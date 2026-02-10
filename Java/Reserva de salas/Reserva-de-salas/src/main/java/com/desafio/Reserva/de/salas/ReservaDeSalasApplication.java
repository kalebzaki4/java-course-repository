package com.desafio.Reserva.de.salas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ReservaDeSalasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservaDeSalasApplication.class, args);
	}

}
