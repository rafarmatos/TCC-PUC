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
public class ZonaRequest {

  @NotBlank(message = "Nome da zona é obrigatório")
  private String nomeZona;
}
