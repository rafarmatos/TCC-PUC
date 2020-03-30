package br.mg.puc.sica.evento.evento.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Id;

@Entity
@Table(name = "EVENTO")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Evento {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String evento;

  private String data;

  private String sensor;

  private Integer intensidade;

}
