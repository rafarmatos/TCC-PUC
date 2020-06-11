package br.mg.puc.sica.evento.evento.service;

import br.mg.puc.sica.evento.evento.model.Sensor;
import br.mg.puc.sica.evento.evento.model.Zona;
import br.mg.puc.sica.evento.evento.model.request.SensorRequest;
import br.mg.puc.sica.evento.evento.model.request.SensorUpdateRequest;
import br.mg.puc.sica.evento.evento.repositoy.SensorRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class SensorService {

  @Autowired
  SensorRepository sensorRepository;

  @Autowired
  ZonaService zonaService;

  public List<Sensor> getSensores() {
    return sensorRepository.findAll();
  }

  public void criarSensor(SensorRequest sensorRequest) {

    Zona zona = zonaService.recuperarZona(sensorRequest.getIdZona());

    Sensor sensor = Sensor.builder()
        .nomeSensor(sensorRequest.getNomeSensor())
        .localizacao(sensorRequest.getLocalizacao())
        .zona(zona)
        .build();

    sensorRepository.save(sensor);
  }

  public void deleteSensor (Long idSensor) {

    Sensor sensor = recuperarSensor(idSensor);
    sensorRepository.delete(sensor);
  }

  public void updateSensor (Long idSensor, SensorUpdateRequest sensorUpdateRequest) {

    Sensor sensor = recuperarSensor(idSensor);

    Zona zona = zonaService.recuperarZona(sensorUpdateRequest.getIdZona());

    sensor.setLocalizacao(sensorUpdateRequest.getLocalizacao());
    sensor.setNomeSensor(sensorUpdateRequest.getNomeSensor());
    sensor.setZona(zona);

    sensorRepository.save(sensor);
  }

  public Sensor recuperarSensor(Long idSensor) {
    Optional<Sensor> sensor = sensorRepository.findById(idSensor);

    if (!sensor.isPresent()) {
      throw new ResponseStatusException(
          HttpStatus.NOT_FOUND, "Sensor não encontrado");
    }

    return sensor.get();
  }
}
