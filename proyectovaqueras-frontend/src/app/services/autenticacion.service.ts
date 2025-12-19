import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';
import { tap } from 'rxjs/operators';
import { environment } from '../../entornos/entornos';
import { 
  LoginDTO, 
  ResponseDTO, 
  DueñoDTO, 
  GamersDTO 
} from '../models/usuario.model';

@Injectable({
  providedIn: 'root'
})
export class AutenticacionService {
  private apiUrl = environment.apiUrl;
  private currentUserSubject = new BehaviorSubject<any>(null);
  public currentUser$ = this.currentUserSubject.asObservable();

  constructor(private http: HttpClient) {
    const storedUser = sessionStorage.getItem('currentUser');
    if (storedUser) {
      this.currentUserSubject.next(JSON.parse(storedUser));
    }
  }

  loginEmpresa(loginData: LoginDTO): Observable<ResponseDTO> {
    return this.http.post<ResponseDTO>(`${this.apiUrl}/login/empresa`, loginData)
      .pipe(
        tap(response => {
          if (response.success) {
            const userData = {
              ...response.data,
              tipoUsuario: 'empresa'
            };
            sessionStorage.setItem('currentUser', JSON.stringify(userData));
            this.currentUserSubject.next(userData);
          }
        })
      );
  }

  loginGamer(loginData: LoginDTO): Observable<ResponseDTO> {
    return this.http.post<ResponseDTO>(`${this.apiUrl}/login/gamer`, loginData)
      .pipe(
        tap(response => {
          if (response.success) {
            const userData = {
              ...response.data,
              tipoUsuario: 'gamer'
            };
            sessionStorage.setItem('currentUser', JSON.stringify(userData));
            this.currentUserSubject.next(userData);
          }
        })
      );
  }

  logout(): Observable<ResponseDTO> {
    return this.http.post<ResponseDTO>(`${this.apiUrl}/logout`, {})
      .pipe(
        tap(() => {
          sessionStorage.removeItem('currentUser');
          this.currentUserSubject.next(null);
        })
      );
  }

  getCurrentUser(): any {
    return this.currentUserSubject.value;
  }

  isAuthenticated(): boolean {
    return this.currentUserSubject.value !== null;
  }

  getTipoUsuario(): string | null {
    const user = this.getCurrentUser();
    return user ? user.tipoUsuario : null;
  }
}