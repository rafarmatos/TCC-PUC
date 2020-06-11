package br.mg.puc.sica.notificacao.config;

import java.util.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
@PropertySource("classpath:application.properties")
public class MailConfig {

  @Autowired
  private Environment env;

  @Bean
  public JavaMailSender mailSender() {
    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

    mailSender.setHost(env.getProperty("mail.smtp.host"));
    mailSender.setPort(env.getProperty("mail.smtp.port", Integer.class));
    mailSender.setUsername(env.getProperty("mail.smtp.username"));
    mailSender.setPassword(env.getProperty("mail.smtp.password"));

    Properties pros = new Properties();
    pros.put("mail.transport.protocol", "smtp");
    pros.put("mail.smtp.auth", true);
    pros.put("mail.smtp.starttls.enable", true);
    pros.put("mail.smtp.connectiontimeout", 10000);

    mailSender.setJavaMailProperties(pros);

    return mailSender;
  }

}
