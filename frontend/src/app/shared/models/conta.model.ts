class Conta {
  idConta:	number;
  tpConta:	number;
  dsNome: string;
  dsEmail:	string;
  nrCPF:	string;
  dtNascimento:	string;
  dsCRP:	string;
  vrConsulta:	number;
  cdGenero: number;
  cdEstadoCivil: 	number;
  dsProfissao:	string;
  nrTelefone:	string;
  nrCelular:	string;
  dsDescricao:	string;
  dsEtc:	string;
  fgNewsLetter:	boolean;
  fgWhatsapp:	boolean;
  fgLembreteEmail:	boolean;
  fgSMS:	boolean;
  sgStatus:	string;
  fgAtivo:	boolean;
  fgCobrar: boolean;
  urFotoPerfil: string;
  dsNaturalidade: string;
}

class Especialidade {
  idContaEspecialidade: number;
  idConta: number;
  dsEspecialidade: string;
  nrOrdem: number;
}

class Experiencia {
  idContaExperiencia: number;
  idConta: number;
  dsExperiencia: string;
  nrOrdem: string;
}

class Formacao {
  idContaFormacao: number;
  idConta: number;
  dsFormacao: string;
  dtFormacao: string;
  nrOrdem: number;
}

class ContaUsuario {
  idContaUsuario: number;
  idConta: number;
  dsUsuario: string;
  dsSenha: string;
}


export {Conta, Especialidade, Experiencia, Formacao, ContaUsuario};
