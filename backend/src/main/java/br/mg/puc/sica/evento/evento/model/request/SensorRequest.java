package br.mg.puc.sica.evento.evento.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SensorRequest {

  private String nomeSensor;
  private String localizacao;
  private Long idZona;
}
