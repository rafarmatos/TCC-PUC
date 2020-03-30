package br.mg.puc.sica.evento.evento.controller;

import br.mg.puc.sica.evento.evento.model.Sensor;
import br.mg.puc.sica.evento.evento.model.request.EnvolvidoUpdateRequest;
import br.mg.puc.sica.evento.evento.model.request.SensorRequest;
import br.mg.puc.sica.evento.evento.model.request.SensorUpdateRequest;
import br.mg.puc.sica.evento.evento.service.SensorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/sensor")
public class SensorController {

  @Autowired
  SensorService sensorService;

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<Sensor> listSensores() {
    return sensorService.getSensores();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void adicionarSensor(@RequestBody SensorRequest sensorRequest) {
    sensorService.criarSensor(sensorRequest);
  }

  @DeleteMapping(path = "/{idSensor}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteSensor(@PathVariable(value = "idSensor")
      Long idSensor) {
    sensorService.deleteSensor(idSensor);
  }

  @PutMapping(path = "/{idSensor}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void updateSensor(@PathVariable(value = "idSensor") Long idSensor,
      @RequestBody SensorUpdateRequest sensorUpdateRequest) {
    sensorService.updateSensor(idSensor, sensorUpdateRequest);
  }
}
