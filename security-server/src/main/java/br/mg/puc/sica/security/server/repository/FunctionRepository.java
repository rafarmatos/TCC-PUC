package br.mg.puc.sica.security.server.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.mg.puc.sica.security.server.entities.Function;

/**
 * <p>Repositorio de dados de um {@link Function}.</p>
 * Atraves deste repositorio é possivel recuperar as funcionalidades cadastradas no sistema.
 * 
 * @author rafael.altagnam
 *
 */
@Repository
public interface FunctionRepository extends CrudRepository<Function, String> {

	Function findByUrlLike(String url);
}
