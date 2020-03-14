package br.mg.puc.sica.security.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.firewall.RequestRejectedException;
import org.springframework.stereotype.Service;

import br.mg.puc.minas.sica.entities.User;
import br.mg.puc.sica.security.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	
	private final static String JSESSIONID = "JSESSIONID";
	

	public User builUser (OAuth2User principal, HttpServletRequest request)  throws Exception {
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
				takeJSessionId(request)
		);
		
		if (!repository.existsById(user.getEmail())) {
			this.repository.save(user);
		}
		
		return user;
	}
	
	
	private String takeJSessionId( HttpServletRequest request) throws RequestRejectedException {
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
