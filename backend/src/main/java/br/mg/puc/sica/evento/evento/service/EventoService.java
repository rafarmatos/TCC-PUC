package br.mg.puc.sica.evento.evento.service;

import br.mg.puc.sica.evento.evento.model.Envolvidos;
import br.mg.puc.sica.evento.evento.model.Evento;
import br.mg.puc.sica.evento.evento.model.Sensor;
import br.mg.puc.sica.evento.evento.networking.EmailRequest;
import br.mg.puc.sica.evento.evento.networking.NotificationCore;
import br.mg.puc.sica.evento.evento.repositoy.SensorRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.mg.puc.sica.evento.evento.repositoy.EventoRepository;

@Service
public class EventoService  {

  @Autowired
  EventoRepository eventoRepository;

  @Autowired
  SensorRepository sensorRepository;

  @Autowired
  NotificationCore notificationCore;

  public List<Evento> getEventos() {
    return eventoRepository.findAll();
  }

  public void criarEvento(Evento evento) {
    eventoRepository.save(evento);

    Optional<Sensor> sensor = sensorRepository.findById(evento.getSensor());

    if (sensor.isPresent()){
      List<Envolvidos> envolvidos = sensor.get().getZona().getEnvolvidos();
      List<String> destinatarios = new ArrayList<>();

      for (Envolvidos obj: envolvidos) {
        if (obj.getEmail()!=null) {
          destinatarios.add(obj.getEmail());
        }
      }

      if (envolvidos!=null) {
        EmailRequest emailRequest = EmailRequest.builder()
            .assunto("**** ATENÇÃO: Evento *****")
            .corpo("Ocorreu um evento de intensidade " + evento.getIntensidade() + " na zona " +
                sensor.get().getZona().getNomeZona() + " localizado em " + sensor.get().getLocalizacao())
            .destinatarios(destinatarios)
            .build();
        notificationCore.sendNotificacaoEnvolvidos(emailRequest);
      }
    }
  }

  public void deleteEvento(Long idEvento) {
    Evento evento = eventoRepository.findById(idEvento).get();

    eventoRepository.delete(evento);
  }
}
