package br.mg.puc.sica.security.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * Classe princpal do projeto - responsável por sua inicilização.
 * @author rafael.altagnam
 *
 */
@SpringBootApplication
@EntityScan("br.mg.puc.minas.sica.entities") // Anotação responsável por ler o pacote de entidades
public class SecurityServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityServerApplication.class, args);
	}


}
