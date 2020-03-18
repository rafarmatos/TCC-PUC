package br.mg.puc.minas.sica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.mg.puc.minas.sica.component.SessionComponent;
import br.mg.puc.minas.sica.exception.AuthorizationException;

@RestController
@RequestMapping(path = "/_user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
	
	@Autowired
	private SessionComponent session;

	@GetMapping
	public ResponseEntity<?> me () {
		try {
			return ResponseEntity.ok(session.requestUser());
		} catch (AuthorizationException e) {
			return ResponseEntity.badRequest().body(e.getKey());
		}
	}
	
}
