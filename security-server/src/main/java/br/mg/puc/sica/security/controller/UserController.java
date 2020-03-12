package br.mg.puc.sica.security.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.exceptions.UnauthorizedUserException;
import org.springframework.security.web.firewall.RequestRejectedException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.mg.puc.sica.security.service.UserService;

@RestController
@RequestMapping(path = "/_user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private UserService service;
	
	//http://localhost:8080/google/login
	@GetMapping
	public ResponseEntity<?> user(Principal principal) {
		try {
			return ResponseEntity.ok().body(service.builUser(
					principal, 
					request
				)
			);
		}catch (UnauthorizedUserException | RequestRejectedException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
		}
	}
	
}
