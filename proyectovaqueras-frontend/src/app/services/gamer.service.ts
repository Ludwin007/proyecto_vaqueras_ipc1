import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../entornos/entornos';
import { RegistroGamerDTO, ResponseDTO } from '../models/usuario.model';

@Injectable({
  providedIn: 'root'
})
export class GamerService {
  private apiUrl = environment.apiUrl;

  constructor(private http: HttpClient) { }

  registrarGamer(registroData: RegistroGamerDTO): Observable<ResponseDTO> {
    return this.http.post<ResponseDTO>(`${this.apiUrl}/registro/gamer`, registroData);
  }
}