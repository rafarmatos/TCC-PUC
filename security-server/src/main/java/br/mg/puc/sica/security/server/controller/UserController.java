package br.mg.puc.sica.security.server.controller;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.mg.puc.sica.security.server.entities.User;
import br.mg.puc.sica.security.server.repository.UserRepository;

/**
 * <p>Conttoller responsável por permiter a consulta de usuários cadastrados no sistema.</p>
 * A inclusão de usuários ocorre após o processo autenticação, portanto somente usuários que já foram autenticados estão cadastrados. 
 * @author rafael.altagnam
 */
@RestController
@RequestMapping(path = "/_user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
	
	@Autowired
	private UserRepository repository;
	
	/**
	 * Funcionalidade que permite pesquisar um usuário na base de dados de 
	 * acordo com o email informado.
	 * 
	 * @param email
	 * @return
	 */
	@GetMapping(path = "/{email}")
	public User find (@PathVariable(name = "email", required =  true) String email) {
		return this. repository.findById(email).orElseThrow(NoResultException::new);
	}

}
