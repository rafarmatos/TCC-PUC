package br.mg.puc.sica.security.server.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.firewall.RequestRejectedException;
import org.springframework.stereotype.Service;

import br.mg.puc.sica.security.server.entities.User;
import br.mg.puc.sica.security.server.repository.UserRepository;

/**
 * Serviço responsável por manipular os dados referente a um {@link User} 
 * @author rafael.altagnam
 *
 */
@Service
public class UserService {
	
	/**
	 * Repositorio de dados para o usuário
	 */
	@Autowired
	private UserRepository repository;
	
	/**
	 * Nome do cookie que contem os dados do usuário após a autenticação pelo spring security 
	 */
	private final static String JSESSIONID = "JSESSIONID";
	
	
	/**
	 * Funcionalidade que permite contruir a entidade {@link User} a partir dos 
	 * dos valores enviados como atributos. 
	 * 
	 * @param principal  - usuário autenticado pelo spring security
	 * @param request	 - requisição do usuário para se recuperar o JSESSIONID da requisição
	 * @return
	 * @throws Exception
	 */
	public User build (OAuth2User principal, HttpServletRequest request)  throws Exception {
		if (principal == null) {
			throw new Exception("The user is null.");			
		}
		
		if (!request.isRequestedSessionIdValid()) {
			throw new Exception("The session is invalid.");
		}

		User user =  User.of(
				principal.getAttribute("email").toString(),
				principal.getAttribute("name").toString(),
				principal.getAttribute("picture").toString(),
				getJSessionId(request)
		);
		
		return user;
	}
	
	
	/**
	 * <p>Funcionalidade que permite contruir a salvar a entidade {@link User} na base de dados.</p>
	 * O usuário, caso ainda nãp exista na base de dados será salvo após sua autenticação.
	 * 
	 * @param principal  - usuário autenticado pelo spring security
	 * @param request	 - requisição do usuário para se recuperar o JSESSIONID da requisição
	 * @return
	 * @throws Exception
	 */
	public User register (OAuth2User principal, HttpServletRequest request)  throws Exception {
		User user =  build(principal, request);		
		if (!repository.existsById(user.getEmail())) {
			this.repository.save(user);
		}
		
		return user;
	}
	
	
	/**
	 * Recupera o valor do cookie JSESSIONID da requisição. Este cookie é responsável 
	 * para indicar para o spring security os dados de um usuário autenticado.
	 *   
	 * @param request
	 * @return
	 * @throws RequestRejectedException
	 */
	private String getJSessionId( HttpServletRequest request) throws RequestRejectedException {
		String cookieValue = null;
		for (Cookie cookie : request.getCookies()) {
			if (JSESSIONID.equals(cookie.getName())){
				cookieValue = cookie.getValue();
				break;
			}
		}
		
		if (cookieValue == null) {
			throw new RequestRejectedException("Jsessionid not found in request.");
		}
		
		return cookieValue;
	}
}
