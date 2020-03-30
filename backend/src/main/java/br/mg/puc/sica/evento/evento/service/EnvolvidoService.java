package br.mg.puc.sica.evento.evento.service;

import br.mg.puc.sica.evento.evento.Enum.Categoria;
import br.mg.puc.sica.evento.evento.model.Envolvidos;
import br.mg.puc.sica.evento.evento.model.Evento;
import br.mg.puc.sica.evento.evento.model.Zona;
import br.mg.puc.sica.evento.evento.model.request.EnvolvidoRequest;
import br.mg.puc.sica.evento.evento.model.request.EnvolvidoUpdateRequest;
import br.mg.puc.sica.evento.evento.repositoy.EnvolvidoRepository;
import br.mg.puc.sica.evento.evento.repositoy.EventoRepository;
import br.mg.puc.sica.evento.evento.repositoy.ZonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnvolvidoService {

  @Autowired
  EnvolvidoRepository envolvidoRepository;

  @Autowired
  ZonaRepository zonaRepository;


  public List<Envolvidos> getEnvolvidos() {
    return envolvidoRepository.findAll();
  }

  public void adicionarEnvolvido(EnvolvidoRequest envolvidoRequest) {

    Zona zona = zonaRepository.findById(envolvidoRequest.getIdZona()).get();

    Envolvidos envolvidos = Envolvidos.builder()
        .email(envolvidoRequest.getEmail())
        .zona(zona)
        .categoria(Categoria.MORADOR)
        .build();

    envolvidoRepository.save(envolvidos);
  }

  public void deleteEnvolvido(Long idEnvolvido) {
    Envolvidos envolvido = envolvidoRepository.findById(idEnvolvido).get();

    envolvidoRepository.delete(envolvido);
  }

  public void updateEnvolvido(Long idEnvolvido, EnvolvidoUpdateRequest envolvidoUpdateRequest) {
    Envolvidos envolvido = envolvidoRepository.findById(idEnvolvido).get();
    envolvido.setCategoria(envolvidoUpdateRequest.getCategoria());
    envolvido.setEmail(envolvidoUpdateRequest.getEmail());

    Zona zona = zonaRepository.findById(envolvidoUpdateRequest.getIdZona()).get();
    envolvido.setZona(zona);

    envolvidoRepository.save(envolvido);
  }
}
