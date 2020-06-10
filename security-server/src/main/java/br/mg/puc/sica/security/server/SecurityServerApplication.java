package br.mg.puc.sica.security.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Classe princpal do projeto - responsável por sua inicilização.
 * @author rafael.altagnam
 *
 */
@SpringBootApplication
@EnableScheduling
@EnableSwagger2
public class SecurityServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityServerApplication.class, args);
	}


}
