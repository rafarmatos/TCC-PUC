package br.mg.puc.minas.sica.component;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;

import br.mg.puc.minas.sica.entities.RequestUser;
import br.mg.puc.minas.sica.exception.AuthorizationException;

@Component
public class SessionComponent {
	
	private HttpServletRequest request;

	private RestTemplate restTemplate;

	@Value("${authorization.url-validate:https://sica-security.herokuapp.com/_authorization/allow?url=%s}" )
	private String urlValidatePermission;
	
	@Value("${authorization.url-validate:https://sica-security.herokuapp.com/_authorization}" )
	private String urlValidadeAuthorization;
	
	
	
	private static final String JSESSIONID = "JSESSIONID=%s";

	@Autowired
	public SessionComponent(	RestTemplate restTemplate, 
								HttpServletRequest request) {

		this.request = request;
		this.restTemplate = restTemplate;
	}

	
	
	/**
	 * Funcionalidde que permite recuperar uma usuário de acordo com o valor do authorization
	 * enviado pela requisição.
	 * @return
	 * @throws AuthorizationException
	 */
	public Boolean validate () throws AuthorizationException {
		if (RequestContextHolder.getRequestAttributes() == null) {
			return null;
		}
		
		String authorization = request.getHeader("Authorization");
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("Cookie", String.format(JSESSIONID, authorization));		
		HttpEntity<String> headers  = new HttpEntity<String>(httpHeaders);
		
		
		try {
			
			ResponseEntity<Boolean> response = restTemplate.exchange(
												String.format(urlValidatePermission, request.getServletPath()), 
												HttpMethod.GET,
												headers,
												Boolean.class
			);
			
			if (!HttpStatus.OK.equals(response.getStatusCode())) {
				Logger.getGlobal().info( String.format("The authorization %s is invalid - %s", authorization, response.getStatusCode()));
				throw new AuthorizationException("erro_authorization", String.format("The authorization %s is invalid.", authorization));

			}
			
			return response.getBody();
		}catch (RestClientException e) {
			throw new AuthorizationException("erro_authorization", e.getLocalizedMessage());
		}
			
	}
	
	/**
	 * Funcionalidde que permite recuperar uma usuário de acordo com o valor do authorization
	 * enviado pela requisição.
	 * @return
	 * @throws AuthorizationException
	 */
	public RequestUser requestUser () throws AuthorizationException {
		if (RequestContextHolder.getRequestAttributes() == null) {
			return null;
		}
		
		String authorization = request.getHeader("Authorization");
		if (authorization == null || authorization.isEmpty()) {
			throw new AuthorizationException("erro_authorization", "There isn't authorization in request");
		}
		
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("Cookie", String.format(JSESSIONID, authorization));		
		HttpEntity<String> headers  = new HttpEntity<String>(httpHeaders);
		
		
		try {
			ResponseEntity<RequestUser> response = restTemplate.exchange(
												urlValidadeAuthorization, 
												HttpMethod.GET,
												headers,
												RequestUser.class
			);
			
			if (!HttpStatus.OK.equals(response.getStatusCode())) {
				Logger.getGlobal().info( String.format("The authorization %s is invalid - %s", authorization, response.getStatusCode()));
				throw new AuthorizationException("erro_authorization", String.format("The authorization %s is invalid.", authorization));

			}
			
			return response.getBody();
		}catch (RestClientException e) {
			throw new AuthorizationException("erro_authorization", e.getLocalizedMessage());
		}
			
	}
}
