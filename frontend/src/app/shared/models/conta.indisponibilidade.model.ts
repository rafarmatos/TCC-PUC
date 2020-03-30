class ContaHorarioIndisponibilidade {

  private _idContaIndisponibilidade: number
  private _idConta: number
  private _dhInicio: string
  private _dhFim: string
  private _horaInicio: string
  private _horaFim: string
  private _dsMotivo: string


  constructor(idContaIndisponibilidade?: number,
              idConta?: number,
              dhInicio?: string,
              dhFim?: string,
              horaInicio?: string,
              horaFim?: string,
              dsMotivo?: string) {
    this._idContaIndisponibilidade = idContaIndisponibilidade
    this._idConta = idConta
    this._dhInicio = dhInicio
    this._dhFim = dhFim
    this._horaInicio = horaInicio
    this._horaFim = horaFim
    this._dsMotivo = dsMotivo
  }


  get idContaIndisponibilidade(): number {
    return this._idContaIndisponibilidade;
  }

  set idContaIndisponibilidade(value: number) {
    this._idContaIndisponibilidade = value;
  }

  get idConta(): number {
    return this._idConta;
  }

  set idConta(value: number) {
    this._idConta = value;
  }

  get dhInicio(): string {
    return this._dhInicio;
  }

  set dhInicio(value: string) {
    this._dhInicio = value;
  }

  get dhFim(): string {
    return this._dhFim;
  }

  set dhFim(value: string) {
    this._dhFim = value;
  }

  get horaInicio(): string {
    return this._horaInicio;
  }

  set horaInicio(value: string) {
    this._horaInicio = value;
  }

  get horaFim(): string {
    return this._horaFim;
  }

  set horaFim(value: string) {
    this._horaFim = value;
  }

  get dsMotivo(): string {
    return this._dsMotivo;
  }

  set dsMotivo(value: string) {
    this._dsMotivo = value;
  }
}


export {ContaHorarioIndisponibilidade}

