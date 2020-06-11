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
public class ZonaResponse {

  private Long idZona;
  private String nomeZona;
  private List<SensorResponse> sensores;
  private List<EnvolvidoResponse> envolvidos;
}
