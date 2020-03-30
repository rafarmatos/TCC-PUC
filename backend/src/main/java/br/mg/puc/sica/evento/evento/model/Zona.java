package br.mg.puc.sica.evento.evento.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ZONA")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Zona {

  @Id
  @Column(name = "ID_ZONA")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long idZona;

  @Column(name = "NOME_ZONA")
  private String nomeZona;

  @JsonIgnore
  @OneToMany(mappedBy = "zona")
  private List<Sensor> sensores;

  @JsonIgnore
  @OneToMany(mappedBy = "zona")
  private List<Envolvidos> envolvidos;
}
