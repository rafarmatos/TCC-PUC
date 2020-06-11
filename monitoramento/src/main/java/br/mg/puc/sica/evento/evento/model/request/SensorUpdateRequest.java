package br.mg.puc.sica.evento.evento.model.request;

import javax.validation.constraints.NotBlank;
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
public class SensorUpdateRequest {

  @NotBlank(message = "Nome do sensor é obrigatório")
  private String nomeSensor;

  @NotBlank(message = "Localização é obrigatório")
  private String localizacao;

  private Long idZona;

}
