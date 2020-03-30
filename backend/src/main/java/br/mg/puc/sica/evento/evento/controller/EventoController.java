package br.mg.puc.sica.evento.evento.controller;

import br.mg.puc.sica.evento.evento.model.Evento;
import br.mg.puc.sica.evento.evento.service.EventoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/evento")
public class EventoController {

  @Autowired
  EventoService eventoService;

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<Evento> listEventos() {
    return eventoService.getEventos();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void adicionarEvento(@RequestBody Evento evento) {
    eventoService.criarEvento(evento);
  }
}
