package br.mg.puc.sica.security.server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

/**
 * <p>Classe responsável por configurar o processo de autenticação via oauth2.</p>
 * 
 * @author rafael.altagnam
 * @see <a href="https://spring.io/guides/tutorials/spring-boot-oauth2/">spring-boot-oauth2</a>
 *
 */
@Configuration
public class SecurityConfig  extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {		
		http
			.authorizeRequests(a -> a
				.antMatchers(
						"/", 
						"/_authorization/**",
						"/error",
						"/v2/api-docs", 
						"/swagger-resources/configuration/ui", 
						"/swagger-resources", 
						"/swagger-resources/configuration/security", 
						"/swagger-ui.html",
						"/webjars/**").permitAll()
				.anyRequest().authenticated()
			)
			.exceptionHandling(e -> e
				.authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
			)
			.csrf().disable()
			.logout(l -> l
				.logoutSuccessUrl("/").permitAll()
			)
			.oauth2Login( o -> o.defaultSuccessUrl("/_authorization/register"));

	}
}
