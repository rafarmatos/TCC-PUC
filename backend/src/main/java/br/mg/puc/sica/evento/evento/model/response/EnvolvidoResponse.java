package br.mg.puc.sica.evento.evento.model.response;

import br.mg.puc.sica.evento.evento.Enum.Categoria;
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
public class EnvolvidoResponse {

  private Long idEnvolvido;
  private String email;
  private Categoria categoria;
}
