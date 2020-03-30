package br.mg.puc.sica.evento.evento.model.request;

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
public class EnvolvidoUpdateRequest {

  private Categoria categoria;
  private String email;
  private Long idZona;
}
