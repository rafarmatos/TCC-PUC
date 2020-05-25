package br.mg.puc.sica.evento.evento.networking;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value="sendEmail", url="https://sipa-notificacao.herokuapp.com")
public interface NotificationCore {

  @RequestMapping(method = RequestMethod.POST, value = "/email/send")
  void sendNotificacaoEnvolvidos(EmailRequest emailRequest);

}
