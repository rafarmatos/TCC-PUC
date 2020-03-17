package br.mg.puc.minas.sica.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.mg.puc.minas.sica.entities.Function;

@Repository
public interface FunctionRepository  extends CrudRepository<Function, String> {
	
}
