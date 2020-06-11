package br.mg.puc.sica.notificacao.service;

import br.mg.puc.sica.notificacao.model.Mensagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

  @Autowired
  private JavaMailSender javaMailSender;

  public void sendEmail(Mensagem mensagem) {

    SimpleMailMessage mail = new SimpleMailMessage();
    mail.setTo(mensagem.getDestinatarios().toArray(new String[mensagem.getDestinatarios().size()]));
    mail.setSubject(mensagem.getAssunto());
    mail.setText(mensagem.getCorpo());

    javaMailSender.send(mail);

  }

}
