package br.mg.puc.sica.evento.evento.service;

import br.mg.puc.sica.evento.evento.model.Evento;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.mg.puc.sica.evento.evento.repositoy.EventoRepository;

@Service
public class EventoService  {

  @Autowired
  EventoRepository eventoRepository;

  public List<Evento> getEventos() {
    return eventoRepository.findAll();
  }

  public void criarEvento(Evento evento) {
    eventoRepository.save(evento);
  }
}
