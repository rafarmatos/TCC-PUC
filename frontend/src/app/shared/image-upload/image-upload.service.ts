import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';


import {HttpClient, HttpParams} from '@angular/common/http';
import {SICA_API} from '../../app.api';

@Injectable()
export class ImageUploadService {
  constructor(private http: HttpClient) {}

  uploadImage(idConta: string, file: File): Observable<any> {
    const fd = new FormData();
    fd.append('formFile', file, file.name);

    const observ =  this.http.put(`${SICA_API}/Conta/Upload?idConta=${idConta}&perfilFundo=1`, fd, {responseType: 'text'});

    return observ;
  }
}
