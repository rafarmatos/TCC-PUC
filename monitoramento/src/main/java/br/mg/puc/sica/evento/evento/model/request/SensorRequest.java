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
public class SensorRequest {

  @NotBlank(message = "Nome do sensor não pode ser vazio")
  private String nomeSensor;

  @NotBlank(message = "Localização não pode ser vazia")
  private String localizacao;

  private Long idZona;
}
