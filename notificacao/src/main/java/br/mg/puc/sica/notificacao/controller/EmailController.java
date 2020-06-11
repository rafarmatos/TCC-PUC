package br.mg.puc.sica.notificacao.controller;

import br.mg.puc.sica.notificacao.model.Mensagem;
import br.mg.puc.sica.notificacao.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/email")
public class EmailController {

  @Autowired
  private MailService mailService;

  @PostMapping("/send")
  @ResponseStatus(HttpStatus.CREATED)
  public void sendNotificacao(
      @RequestHeader(value = "Authorization")
          String authorization,
      @RequestBody Mensagem mensagem) {

    mailService.sendEmail(mensagem);

  }

}
