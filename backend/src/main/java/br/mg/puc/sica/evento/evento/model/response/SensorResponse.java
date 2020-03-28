package br.mg.puc.sica.evento.evento.model.response;

import br.mg.puc.sica.evento.evento.model.Sensor;
import java.util.List;
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
public class SensorResponse {

  private Long idSensor;
  private String nomeSensor;
  private String localizacao;
}
