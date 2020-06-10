package br.mg.puc.sica.security.server.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * <p>Classe responsável por armazenar as URLs publicas do sistema.</p>
 * 
 * @author rafael.altagnam
 *
 */
@Component
public class URLAllows {
	
	private List<String> urls;
	
	public URLAllows() {
		this.urls = Arrays.asList(
				"/", 
				"/_authorization/**",
				"csrf",
				"/error",
				"/v2/api-docs", 
				"/swagger-resources", 
				"/swagger-resources/**", 
				"/configuration/security", 
				"/swagger-ui.html",
				"/webjars/**",
				"favicon.ico",
				"/favicon.ico"
		);
	}
	
	
	/**
	 * Retorna a lista de URL's permitidas
	 * @return
	 */
	public String[] getUrls () {
		return (String[]) this.urls.toArray();
	}
	
	
	/**
	 * Valida se a requisição tem como endereço paginas de documentaçao do swagger
	 * @param param
	 * @return
	 */
	public boolean isSwagger (String param) {
		if (param.equals("/favicon.ico") || param.equals("csrf") || param.equals("/csrf") || param.equals("/") || param.contains("swagger") || param.contains("v2/api-docs")) {
			return  Boolean.TRUE;
		}
		
		return false;
	}
	
}
