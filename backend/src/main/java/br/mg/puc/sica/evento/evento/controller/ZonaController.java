package br.mg.puc.sica.evento.evento.controller;

import br.mg.puc.sica.evento.evento.model.Zona;
import br.mg.puc.sica.evento.evento.model.response.ZonaResponse;
import br.mg.puc.sica.evento.evento.service.ZonaService;
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
@RequestMapping(value = "/zona")
public class ZonaController {

  @Autowired
  ZonaService zonaService;

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<ZonaResponse> listZonas() {
    return zonaService.getZonas();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void adicionarZona(@RequestBody Zona zona) {
    zonaService.criarZona(zona);
  }
}
