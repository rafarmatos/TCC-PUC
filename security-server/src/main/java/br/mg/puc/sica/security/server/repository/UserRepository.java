package br.mg.puc.sica.security.server.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.mg.puc.sica.security.server.entities.User;

/**
 * <p>Repositorio de dados de um {@link User}.</p>
 * Atraves deste repositorio é possivel manter um {@link User} na base de dados.
 * 
 * @author rafael.altagnam
 *
 */
@Repository
public interface UserRepository extends CrudRepository<User, String> {

}
