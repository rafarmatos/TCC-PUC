package br.mg.puc.sica.evento.evento.service;

import br.mg.puc.sica.evento.evento.Enum.Categoria;
import br.mg.puc.sica.evento.evento.model.Envolvidos;
import br.mg.puc.sica.evento.evento.model.Evento;
import br.mg.puc.sica.evento.evento.model.Zona;
import br.mg.puc.sica.evento.evento.model.request.EnvolvidoRequest;
import br.mg.puc.sica.evento.evento.model.request.EnvolvidoUpdateRequest;
import br.mg.puc.sica.evento.evento.repositoy.EnvolvidoRepository;
import br.mg.puc.sica.evento.evento.repositoy.EventoRepository;
import br.mg.puc.sica.evento.evento.repositoy.ZonaRepository;
import java.util.List;
import java.util.Optional;
import org.apache.commons.lang3.EnumUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class EnvolvidoService {

  @Autowired
  EnvolvidoRepository envolvidoRepository;

  @Autowired
  ZonaService zonaService;


  public List<Envolvidos> getEnvolvidos() {
    return envolvidoRepository.findAll();
  }

  public void adicionarEnvolvido(EnvolvidoRequest envolvidoRequest) {

    Zona zona = zonaService.recuperarZona(envolvidoRequest.getIdZona());

    Categoria categoria = validarRetornarCategoria(envolvidoRequest.getCategoria());

    Envolvidos envolvidos = Envolvidos.builder()
        .email(envolvidoRequest.getEmail())
        .zona(zona)
        .categoria(categoria)
        .build();

    envolvidoRepository.save(envolvidos);
  }

  public void deleteEnvolvido(Long idEnvolvido) {

    Envolvidos envolvido = recuperarEnvolvido(idEnvolvido);

    envolvidoRepository.delete(envolvido);
  }

  public void updateEnvolvido(Long idEnvolvido, EnvolvidoUpdateRequest envolvidoUpdateRequest) {

    Envolvidos envolvido = recuperarEnvolvido(idEnvolvido);

    Zona zona = zonaService.recuperarZona(envolvidoUpdateRequest.getIdZona());

    Categoria categoria = validarRetornarCategoria(envolvidoUpdateRequest.getCategoria());

    envolvido.setCategoria(categoria);
    envolvido.setEmail(envolvidoUpdateRequest.getEmail());
    envolvido.setZona(zona);

    envolvidoRepository.save(envolvido);
  }

  private Envolvidos recuperarEnvolvido(Long idEnvolvido) {
    Optional<Envolvidos> envolvido = envolvidoRepository.findById(idEnvolvido);

    if (!envolvido.isPresent()) {
      throw new ResponseStatusException(
          HttpStatus.NOT_FOUND, "Envolvido não encontrado");
    }

    return envolvido.get();
  }

  private Categoria validarRetornarCategoria(String categoria) {
    if (!EnumUtils.isValidEnum(Categoria.class, categoria)) {
      throw new ResponseStatusException(
          HttpStatus.BAD_REQUEST, "Categoria inválida");
    }

    return Categoria.valueOf(categoria);
  }
}
