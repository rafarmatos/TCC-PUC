package br.mg.puc.minas.sica.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import br.mg.puc.minas.sica.component.SessionComponent;
import br.mg.puc.minas.sica.exception.AuthorizationException;

@Component
@Order(1)
public class AuthorizationFilter implements Filter{
	
	@Autowired
	private SessionComponent authorizationComponent;

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		
		try {
			
			authorizationComponent.myUser();			
			chain.doFilter(req, res);
		
		} catch (AuthorizationException e) {
			HttpServletResponse response = (HttpServletResponse) res;			
			response.sendError(HttpStatus.UNAUTHORIZED.value(), e.getMessage());
		}
		
	}

}
