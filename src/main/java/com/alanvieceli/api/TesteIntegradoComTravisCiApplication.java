package com.alanvieceli.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.alanvieceli.api.utils.SenhaUtils;

@SpringBootApplication
public class TesteIntegradoComTravisCiApplication {
	
	@Value("${paginacao.qtd_por_pagina}")
	private int qtdePorPagina;

	public static void main(String[] args) {
		SpringApplication.run(TesteIntegradoComTravisCiApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args ->{
			System.out.println("### Quantidade de elementos por página = " + this.qtdePorPagina + "###");
			
			String senha = "123456";
			String senhaEncoded = SenhaUtils.gerarBCrypty(senha);
			System.out.println("Senha encoded : " + senhaEncoded);
			
			senhaEncoded = SenhaUtils.gerarBCrypty(senha);
			System.out.println("Senha encoded (De novo): " + senhaEncoded);
			
			System.out.println("Senha válida? " + SenhaUtils.senhaValida(senha, senhaEncoded));
		};
	}
}
