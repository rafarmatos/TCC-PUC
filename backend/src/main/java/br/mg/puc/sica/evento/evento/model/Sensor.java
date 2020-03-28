package br.mg.puc.sica.evento.evento.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "SENSOR")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Sensor {

  @Id
  @Column(name = "ID_SENSOR")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long idSensor;

  @Column(name = "NOME_SENSOR")
  private String nomeSensor;

  @Column(name = "LOCALIZACAO")
  private String localizacao;

  @ManyToOne
  @JoinColumn(name = "ID_ZONA")
  private Zona zona;
}
