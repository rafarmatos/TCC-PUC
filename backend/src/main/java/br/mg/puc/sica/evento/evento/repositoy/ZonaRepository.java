package br.mg.puc.sica.evento.evento.repositoy;

import br.mg.puc.sica.evento.evento.model.Zona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ZonaRepository extends JpaRepository<Zona, Long> {

}
