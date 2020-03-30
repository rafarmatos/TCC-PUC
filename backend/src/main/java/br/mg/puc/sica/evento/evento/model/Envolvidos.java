package br.mg.puc.sica.evento.evento.model;

import br.mg.puc.sica.evento.evento.Enum.Categoria;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ENVOLVIDOS")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Envolvidos {

  @Id
  @Column(name = "ID_ENVOLVIDO")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long idEnvolvido;

  @Column(name = "CATEGORIA")
  private Categoria categoria;

  @Column(name = "EMAIL")
  private String email;

  @ManyToOne
  @JoinColumn(name = "ID_ZONA")
  private Zona zona;

}
