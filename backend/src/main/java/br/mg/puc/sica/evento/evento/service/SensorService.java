package br.mg.puc.sica.evento.evento.service;

import br.mg.puc.sica.evento.evento.model.Sensor;
import br.mg.puc.sica.evento.evento.model.Zona;
import br.mg.puc.sica.evento.evento.model.request.SensorRequest;
import br.mg.puc.sica.evento.evento.model.request.SensorUpdateRequest;
import br.mg.puc.sica.evento.evento.repositoy.SensorRepository;
import br.mg.puc.sica.evento.evento.repositoy.ZonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SensorService {

  @Autowired
  SensorRepository sensorRepository;

  @Autowired
  ZonaRepository zonaRepository;

  public List<Sensor> getSensores() {
    return sensorRepository.findAll();
  }

  public void criarSensor(SensorRequest sensorRequest) {

    Zona zona = zonaRepository.findById(sensorRequest.getIdZona()).get();

    Sensor sensor = Sensor.builder()
        .nomeSensor(sensorRequest.getNomeSensor())
        .localizacao(sensorRequest.getLocalizacao())
        .zona(zona)
        .build();
    sensorRepository.save(sensor);
  }

  public void deleteSensor (Long idSensor) {
    Sensor sensor = sensorRepository.findById(idSensor).get();
    sensorRepository.delete(sensor);
  }

  public void updateSensor (Long idSensor, SensorUpdateRequest sensorUpdateRequest) {
    Sensor sensor = sensorRepository.findById(idSensor).get();
    sensor.setLocalizacao(sensorUpdateRequest.getLocalizacao());
    sensor.setNomeSensor(sensorUpdateRequest.getNomeSensor());
    Zona zona = zonaRepository.findById(sensorUpdateRequest.getIdZona()).get();
    sensor.setZona(zona);
    sensorRepository.save(sensor);
  }
}
