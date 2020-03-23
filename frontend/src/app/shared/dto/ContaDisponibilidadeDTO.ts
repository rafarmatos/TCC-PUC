interface ContaDisponibilidadeDTO {
  idContaDisponibilidade:	number;
  idConta:	number;
  nrJanelaMinutos: number;
  dtoSegunda: DtoSegunda;
  dtoTerca: DtoTerca;
  dtoQuarta: DtoQuarta;
  dtoQuinta: DtoQuinta;
  dtoSexta: DtoSexta;
  dtoSabado: DtoSabado;
  dtoDomingo: DtoDomingo;
}

interface DtoSegunda {
  hrManhaInicio: string;
  hrManhaFim: string;
  hrTardeInicio: string;
  hrTardeFim: string;
  hrNoiteInicio: string;
  hrNoiteFim: string;
}

interface DtoTerca {
  hrManhaInicio: string;
  hrManhaFim: string;
  hrTardeInicio: string;
  hrTardeFim: string;
  hrNoiteInicio: string;
  hrNoiteFim: string;
}

interface DtoQuarta {
  hrManhaInicio: string;
  hrManhaFim: string;
  hrTardeInicio: string;
  hrTardeFim: string;
  hrNoiteInicio: string;
  hrNoiteFim: string;
}

interface DtoQuinta {
  hrManhaInicio: string;
  hrManhaFim: string;
  hrTardeInicio: string;
  hrTardeFim: string;
  hrNoiteInicio: string;
  hrNoiteFim: string;
}

interface DtoSexta {
  hrManhaInicio: string;
  hrManhaFim: string;
  hrTardeInicio: string;
  hrTardeFim: string;
  hrNoiteInicio: string;
  hrNoiteFim: string;
}

interface DtoSabado {
  hrManhaInicio: string;
  hrManhaFim: string;
  hrTardeInicio: string;
  hrTardeFim: string;
  hrNoiteInicio: string;
  hrNoiteFim: string;
}

interface DtoDomingo {
  hrManhaInicio: string;
  hrManhaFim: string;
  hrTardeInicio: string;
  hrTardeFim: string;
  hrNoiteInicio: string;
  hrNoiteFim: string;
}


export {ContaDisponibilidadeDTO, DtoSegunda, DtoTerca, DtoQuarta, DtoQuinta, DtoSexta, DtoSabado, DtoDomingo};
