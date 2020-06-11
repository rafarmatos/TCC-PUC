package br.mg.puc.sica.notificacao.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Mensagem {

  private List<String> destinatarios;

  private String assunto;

  private String corpo;

}
