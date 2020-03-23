import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient, HttpParams} from '@angular/common/http';
import {ConsultaDTO} from '../../shared/dto/ConsultaDTO';
import {SICA_API} from '../../app.api';
import {Pagamento} from '../../shared/models/pagamento.model';
import {tap} from 'rxjs/operators';


@Injectable()
export class EnvolvidosService {

  consultaDTO: ConsultaDTO;
  pagamento: Pagamento;


  constructor(private http: HttpClient) {
  }


  buscarConsultaPorIdConta(idConta: string, sgStatusConsultaArray: Array<string>): Observable<ConsultaDTO[]> {


    let params = new HttpParams();

    // Lista de status
    sgStatusConsultaArray.forEach((sgStatus: string) => {
      params = params.append(`sgStatus`, sgStatus);
    });

    // id Conta
    params = params.append(`idConta`, idConta);

    // Parametro conta cliente esta fazendo a consulta
    params = params.append(`tpConta`, '3');


    return this.http.get<ConsultaDTO[]>(`${SICA_API}/Consulta/ObterConsultasPorIdConta`,
      {params});
  }

  consultaCheckout(idConsulta: string): Observable<String> {


    return this.http.post(`${SICA_API}/Pagamento/ConsultaCheckout/${idConsulta}`, null, {responseType: 'text'});

  }

  gravarPagamento(pagamento: Pagamento): Observable<Pagamento> {
    return this.http.post<Pagamento>(`${SICA_API}/Pagamento/Post`, pagamento)
      .pipe(tap(pagamento => this.pagamento = pagamento));
  }




}
