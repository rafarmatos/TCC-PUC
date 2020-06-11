package br.mg.puc.sica.evento.evento.repositoy;

import br.mg.puc.sica.evento.evento.model.Envolvidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface EnvolvidoRepository extends JpaRepository<Envolvidos, Long> {

}
