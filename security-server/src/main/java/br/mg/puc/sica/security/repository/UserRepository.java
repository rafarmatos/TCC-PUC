package br.mg.puc.sica.security.repository;

import org.springframework.data.repository.CrudRepository;

import br.mg.puc.minas.sica.entities.User;

public interface UserRepository extends CrudRepository<User, String> {

}
