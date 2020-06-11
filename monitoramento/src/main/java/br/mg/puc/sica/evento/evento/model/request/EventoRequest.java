package br.mg.puc.sica.evento.evento.model.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
public class EventoRequest {

  @NotBlank(message = "Evento é obrigatório")
  private String evento;

  private String data;

  private Long sensor;

  @Min(value = 1, message = "Intesidade deve ser maior ou igual a 1")
  @Max(value = 100, message = "Intesidade deve ser menor ou igual a 100")
  private Integer intensidade;

}
