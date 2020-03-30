interface ConsultaDTO {
  idConsulta:	number;
  idConta:	number;
  idContaAgenda: number;
  sgStatus: string;
  nrAvaliacao: number;
  dhRegistro: string;
  dhAgenda: string;
  nomeAtendente: string;
  nomePaciente: string;
  dtNascimentoPaciente: string;
  urFotoPerfilAtendente: string;
  urFotoPerfilPaciente: string;
  stPagtoConsulta: string;
}



export {ConsultaDTO};
