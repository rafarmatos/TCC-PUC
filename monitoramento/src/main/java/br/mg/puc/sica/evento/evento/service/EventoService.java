package br.mg.puc.sica.evento.evento.service;

import br.mg.puc.sica.evento.evento.Enum.Categoria;
import br.mg.puc.sica.evento.evento.model.Envolvidos;
import br.mg.puc.sica.evento.evento.model.Evento;
import br.mg.puc.sica.evento.evento.model.Sensor;
import br.mg.puc.sica.evento.evento.model.request.EventoRequest;
import br.mg.puc.sica.evento.evento.networking.EmailRequest;
import br.mg.puc.sica.evento.evento.networking.NotificationCore;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import br.mg.puc.sica.evento.evento.repositoy.EventoRepository;
import org.springframework.web.server.ResponseStatusException;

@Service
public class EventoService  {

  @Autowired
  EventoRepository eventoRepository;

  @Autowired
  SensorService sensorService;

  @Autowired
  NotificationCore notificationCore;

  public List<Evento> getEventos() {
    return eventoRepository.findAll();
  }

  public void criarEvento(String authorization, EventoRequest eventoRequest) {

    Sensor sensor = sensorService.recuperarSensor(eventoRequest.getSensor());

    Evento evento = Evento.builder()
        .data(eventoRequest.getData())
        .evento(eventoRequest.getEvento())
        .intensidade(eventoRequest.getIntensidade())
        .sensor(eventoRequest.getSensor())
        .build();

    eventoRepository.save(evento);

    List<Envolvidos> envolvidos = sensor.getZona().getEnvolvidos();
    List<String> destinatarios = new ArrayList<>();

    for (Envolvidos obj: envolvidos) {
      if (obj.getEmail()!=null && regraEnviarEmailEnvolvido(obj, evento)) {
        destinatarios.add(obj.getEmail());
      }
    }

    if (envolvidos!=null) {
      EmailRequest emailRequest = EmailRequest.builder()
          .assunto("**** ATENÇÃO: Evento *****")
          .corpo("Ocorreu um evento de intensidade " + evento.getIntensidade() + " na zona " +
              sensor.getZona().getNomeZona() + " localizado em " + sensor.getLocalizacao())
          .destinatarios(destinatarios)
          .build();
      notificationCore.sendNotificacaoEnvolvidos(authorization, emailRequest);
    }
  }

  public void deleteEvento(Long idEvento) {

    Optional<Evento> evento = eventoRepository.findById(idEvento);

    if (!evento.isPresent()) {
      throw new ResponseStatusException(
          HttpStatus.NOT_FOUND, "Evento não encontrado");
    }

    eventoRepository.delete(evento.get());
  }

  private boolean regraEnviarEmailEnvolvido(Envolvidos envolvido, Evento evento) {

    if (envolvido.getCategoria()!=null) {

      if (evento.getIntensidade() > 40) {
        return true;
      }

      if (envolvido.getCategoria().equals(Categoria.TECNICO)) {
        return true;
      }

      if (evento.getIntensidade() > 20 && envolvido.getCategoria().equals(Categoria.ENGENHEIRO)) {
        return true;
      }

      if (evento.getIntensidade() > 30 && (envolvido.getCategoria().equals(Categoria.ENGENHEIRO)
          ||envolvido.getCategoria().equals(Categoria.SEG_PUBLICA))) {
        return true;
      }
    }

    return false;
  }
}
