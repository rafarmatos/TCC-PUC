package br.mg.puc.sica.security.server.service;

import java.util.HashMap;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import br.mg.puc.sica.security.server.config.URLAllows;
import br.mg.puc.sica.security.server.entities.Function;
import br.mg.puc.sica.security.server.repository.FunctionRepository;

/**
 * Serviço responsável por manipular os dados referente a um {@link Function} 
 * @author rafael.altagnam
 *
 */
@Service
public class FunctionService {

	@Autowired
	private URLAllows urlsAllows;
	
	@Autowired
	private FunctionRepository repository;
	
	
	private final static HashMap<String, Function> CACHE = new HashMap<String, Function>();
	
	
	/**
	 * Limpa o cache a cada 5 minutos
	 */
	@Scheduled(fixedDelay = 300000)
	public void clearCache() {
	   CACHE.clear();
	}
	
	
	/**
	 * Recupera uma funcionalidade da base de dados de acordo com a URL 
	 * @param param
	 * @return
	 * @throws Exception 
	 */
	public Function findByUrl (String param) throws Exception {
		
		if (param == null || param.trim().equalsIgnoreCase("")) {
			throw new Exception("url cant'n be empty.");
		}
		
		Function function = CACHE.get(param);
		if (function == null) {
			function = repository.findByUrlLike(param);
			CACHE.put(param, function);
		}
		
		return function;
	}
	
	
	/**
	 * Verifica se um usuário possui permissao de acesso a uma determinada funcionalidade.
	 * @param principal
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public boolean allow (OAuth2User principal, String param) throws Exception {
	
		if (param == null || param.trim().equalsIgnoreCase("")) {
			throw new Exception("url cant'n be empty.");
		}
		
		
		if (urlsAllows.isSwagger(param)) {
			return true;
		}
	
		
		
		/*
		 * Nesta POC todos os usuários autenticados serão consiserados válidos
		 */
		if (principal != null) {
			return  Boolean.TRUE;
		}

		
		
		return  Boolean.FALSE;
	}


}
