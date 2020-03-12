package br.mg.puc.sica.security.service;

import java.security.Principal;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.exceptions.UnauthorizedUserException;
import org.springframework.security.web.firewall.RequestRejectedException;
import org.springframework.stereotype.Service;

import br.mg.puc.sica.security.entities.User;
import br.mg.puc.sica.security.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	
	private final static String JSESSIONID = "JSESSIONID";
	

	public User builUser (Principal principal, HttpServletRequest request)  throws UnauthorizedUserException, 
																					RequestRejectedException {
		if (principal == null) {
			throw new UnauthorizedUserException("The user is null.");			
		}
		
		if (!request.isRequestedSessionIdValid()) {
			throw new RequestRejectedException("The session is invalid.");
		}
		
		
		User user =  User.of(principal, getJSessionId(request));
		if (!repository.existsById(user.getId())) {
			this.repository.save(user);
		}
		
		return user;
	}
	
	
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
