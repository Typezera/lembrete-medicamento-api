package com.LembreteMedicamento.lembretemedicamento;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
public class LembretemedicamentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LembretemedicamentoApplication.class, args);
	}

	@PostConstruct
	void started(){
		TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));
	}

}
