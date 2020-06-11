package br.mg.puc.sica.evento.evento.controller;

import br.mg.puc.sica.evento.evento.model.Envolvidos;
import br.mg.puc.sica.evento.evento.model.request.EnvolvidoRequest;
import br.mg.puc.sica.evento.evento.model.request.EnvolvidoUpdateRequest;
import br.mg.puc.sica.evento.evento.service.EnvolvidoService;
import io.swagger.annotations.ApiParam;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/envolvido")
public class EnvolvidoController {

  @Autowired
  EnvolvidoService envolvidoService;

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<Envolvidos> listEnvolvidos(
      @ApiParam(
          required = true,
          example = "2EE21B31F2610263AD538C46F5E22D91")
      @RequestHeader(value = "Authorization")
          String authorization
  ) {
    return envolvidoService.getEnvolvidos();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void adicionarEnvolvido(
      @ApiParam(
          required = true,
          example = "2EE21B31F2610263AD538C46F5E22D91")
      @RequestHeader(value = "Authorization")
          String authorization,
      @RequestBody @Validated EnvolvidoRequest envolvidoRequest) {
    envolvidoService.adicionarEnvolvido(envolvidoRequest);
  }

  @DeleteMapping(path = "/{idEnvolvido}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteEnvolvido(
      @ApiParam(
          required = true,
          example = "2EE21B31F2610263AD538C46F5E22D91")
      @RequestHeader(value = "Authorization")
          String authorization,
      @PathVariable(value = "idEnvolvido")
      Long idEnvolvido) {
    envolvidoService.deleteEnvolvido(idEnvolvido);
  }

  @PutMapping(path = "/{idEnvolvido}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void updateEnvolvido(
      @ApiParam(
          required = true,
          example = "2EE21B31F2610263AD538C46F5E22D91")
      @RequestHeader(value = "Authorization")
          String authorization,
      @PathVariable(value = "idEnvolvido") Long idEnvolvido,
      @RequestBody @Validated EnvolvidoUpdateRequest envolvidoUpdateRequest) {
    envolvidoService.updateEnvolvido(idEnvolvido, envolvidoUpdateRequest);
  }
}
