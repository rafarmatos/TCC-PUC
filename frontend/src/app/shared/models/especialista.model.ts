import {Conta, Especialidade, Experiencia, Formacao} from "./conta.model";


interface Especialista {
  dtoConta : Conta;
  dtoContaEspecialidades: Especialidade[],
  dtoContaExeperiencias: Experiencia[],
  dtoContaFormacoes: Formacao[]
}

export {Especialista}
