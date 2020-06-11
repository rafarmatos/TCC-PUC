package br.mg.puc.sica.evento.evento.controller;

import br.mg.puc.sica.evento.evento.model.Evento;
import br.mg.puc.sica.evento.evento.model.request.EventoRequest;
import br.mg.puc.sica.evento.evento.service.EventoService;
import io.swagger.annotations.ApiParam;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
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
  public List<Evento> listEventos(
      @ApiParam(
          required = true,
          example = "2EE21B31F2610263AD538C46F5E22D91")
      @RequestHeader(value = "Authorization")
          String authorization
  ) {
    return eventoService.getEventos();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void adicionarEvento(
      @ApiParam(
          required = true,
          example = "2EE21B31F2610263AD538C46F5E22D91")
      @RequestHeader(value = "Authorization")
          String authorization,
      @RequestBody @Validated EventoRequest eventoRequest) {
    eventoService.criarEvento(authorization, eventoRequest);
  }

  @DeleteMapping(path = "/{idEvento}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteEvento(
      @ApiParam(
          required = true,
          example = "2EE21B31F2610263AD538C46F5E22D91")
      @RequestHeader(value = "Authorization")
          String authorization,
      @PathVariable(value = "idEvento")
          Long idEvento) {
    eventoService.deleteEvento(idEvento);
  }

}
