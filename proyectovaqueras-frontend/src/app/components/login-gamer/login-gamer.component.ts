import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AutenticacionService } from '../../services/autenticacion.service';
import { LoginDTO } from '../../models/usuario.model';

@Component({
  selector: 'app-login-gamer',
  templateUrl: './login-gamer.component.html',
  styleUrls: ['./login-gamer.component.css']
})
export class LoginGamerComponent {
  loginData: LoginDTO = {
    correo: '',
    password: ''
  };

  errorMessage: string = '';
  successMessage: string = '';
  isLoading: boolean = false;

  constructor(
    private autenticacionService: AutenticacionService,
    private router: Router
  ) {

    if (this.autenticacionService.isAuthenticated()) {
      this.router.navigate(['/dashboard-gamer']);
    }
  }

  onSubmit(): void {

    this.errorMessage = '';
    this.successMessage = '';

    if (!this.loginData.correo || !this.loginData.password) {
      this.errorMessage = 'Por favor complete todos los campos';
      return;
    }

    this.isLoading = true;

    this.autenticacionService.loginGamer(this.loginData).subscribe({
      next: (response) => {
        this.isLoading = false;
        if (response.success) {
          this.successMessage = response.message;
          setTimeout(() => {
            this.router.navigate(['/dashboard-gamer']);
          }, 1000);
        } else {
          this.errorMessage = response.message;
        }
      },
      error: (error) => {
        this.isLoading = false;
        console.error('Error en login:', error);
        if (error.status === 401) {
          this.errorMessage = 'Oops, Credenciales incorrectas';
        } else if (error.status === 0) {
          this.errorMessage = 'Oops, no se pudo conectar con el servidor. Verifique que el backend esté corriendo.';
        } else {
          this.errorMessage = error.error?.message || 'Error al iniciar sesión';
        }
      }
    });
  }

  clearMessages(): void {
    this.errorMessage = '';
    this.successMessage = '';
  }
}