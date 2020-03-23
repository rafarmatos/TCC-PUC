import * as moment from 'moment';
import 'moment/locale/pt-br';
import {Injectable } from '@angular/core';


@Injectable()
export class Utility {
  public sortByAsc(collection: any, fieldName: string): any {
    return collection.sort((param1, param2) => {
      return param1[fieldName] < param2[fieldName] ? -1 :
        (param1[fieldName] > param2[fieldName] ? 1 : 0);
    });
  }

  public sortByDesc(collection: any, fieldName: string): any {
    return collection.sort((param1, param2) => {
      return param1[fieldName] > param2[fieldName] ? -1 :
        (param1[fieldName] < param2[fieldName] ? 1 : 0);
    });
  }

  public getMiniaturaPerfil(URLImagem: string): string {
    if (URLImagem) {
      let miniatura: string;
      miniatura = URLImagem.substr(0, URLImagem.length - 4);
      miniatura += '_thumb' + URLImagem.substr(-4);
      return miniatura;
    } else {
      return './assets/img/placeholder.jpg';
    }
  }

  public getDataCompleta(data: string): string {
    const week = moment(data).format('dddd').toString();
    const day = moment(data).format('DD').toString();
    const month = moment(data).format('MMMM').toString();
    const year = moment(data).format('YYYY').toString();
    const time = moment(data).format('HH:mm').toString();

    return `${week}, ${day} de ${month} de ${year} às ${time}`;
  }

  public getDataSimplificada(data: string): string {
    const day = moment(data).format('DD').toString();
    const month = moment(data).format('MM').toString();
    const year = moment(data).format('YYYY').toString();
    const time = moment(data).format('HH:mm').toString();

    return `${day}/${month}/${year} às ${time}`;
  }

  public getIdade(dataNascimento: string) {
    const idade = moment().diff(dataNascimento, 'years');
    return (idade > 110 || idade < 1) ? '-' : `${idade} anos`;
  }

  public getAno() {
    const d = new Date();
    return d.getFullYear();
  }

  public getMes() {
    const d = new Date();
    return d.getMonth();
  }
}
