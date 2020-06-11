package br.mg.puc.sica.evento.evento.model.request;

import javax.validation.constraints.Email;
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
public class EnvolvidoRequest {

  @Email
  private String email;

  private Long idZona;

  @NotBlank(message = "Categoria é obrigatório")
  private String categoria;
}
