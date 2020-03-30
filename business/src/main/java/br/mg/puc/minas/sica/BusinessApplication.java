package br.mg.puc.minas.sica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication
@EnableWebMvc
public class BusinessApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusinessApplication.class, args);
	}

}
