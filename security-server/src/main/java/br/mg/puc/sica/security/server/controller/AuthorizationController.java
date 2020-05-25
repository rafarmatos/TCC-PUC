package br.mg.puc.sica.security.server.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.mg.puc.sica.security.server.service.FunctionService;
import br.mg.puc.sica.security.server.service.UserService;

/**
 * <p>Funcionalidade que permite um usuário após o processo de autenticação registra-se ao sistema.</p>
 * Esta classe ainda permite recuperar um usuário previamente autenticado de acordo com os parametros do Header 
 * utilizando da biblioteca spring security.
 * 
 * @author rafael.altagnam
 *
 */
@RestController
@RequestMapping(path = "/_authorization", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthorizationController {
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private FunctionService functionService;
	
	/**
	 * Funcionalidade que exibe os dados do usuário autenticado de acordo com os 
	 * valores contidos no header da requisição.
	 *  
	 * @param principal
	 * @return
	 */
	@GetMapping(path = "/me")
	public ResponseEntity<?> user(@AuthenticationPrincipal OAuth2User principal) {
		
		try {
			
			return ResponseEntity.ok().body(userService.build(
					principal, 
					request
				)
			);
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
		}
	}
	
	
	@GetMapping(path = "/allow")
	public ResponseEntity<?> allow(@AuthenticationPrincipal OAuth2User principal, 
								  @RequestParam(name = "url") String url) {
		
		try {
	
			return ResponseEntity.ok().body(functionService.allow(
					principal, 
					url
				)
			);
			
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
		}
	}
	
	
	/**
	 * Funcionalidade que permite registrar um usuário na base de dados após o processo de autenticação.
	 * @param principal
	 * @return
	 */
	@GetMapping(path = "/register")
	public ResponseEntity<?> register (@AuthenticationPrincipal OAuth2User principal) {
	
		try {
			
			return ResponseEntity.ok().body(userService.register(
					principal, 
					request
				)
			);
			
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
		}
	}
	
	
	
}
