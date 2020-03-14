package br.mg.puc.sica.security.repository;

import org.springframework.data.repository.CrudRepository;

import br.mg.puc.sica.security.entities.User;

public interface UserRepository extends CrudRepository<User, String> {

}
