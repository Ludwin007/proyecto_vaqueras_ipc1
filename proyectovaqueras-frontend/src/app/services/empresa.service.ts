import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../entornos/entornos';
import { RegistroEmpresaDTO, ResponseDTO } from '../models/usuario.model';

@Injectable({
  providedIn: 'root'
})
export class EmpresaService {
  private apiUrl = environment.apiUrl;

  constructor(private http: HttpClient) { }

  registrarEmpresa(registroData: RegistroEmpresaDTO): Observable<ResponseDTO> {
    return this.http.post<ResponseDTO>(`${this.apiUrl}/registro/empresa`, registroData);
  }
}