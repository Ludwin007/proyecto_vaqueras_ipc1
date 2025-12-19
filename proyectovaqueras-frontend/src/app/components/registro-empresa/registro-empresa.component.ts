import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { EmpresaService } from '../../services/empresa.service';
import { RegistroEmpresaDTO } from '../../models/usuario.model';

@Component({
  selector: 'app-registro-empresa',
  templateUrl: './registro-empresa.component.html',
  styleUrls: ['./registro-empresa.component.css']
})
export class RegistroEmpresaComponent {
  registroData: RegistroEmpresaDTO = {
    nombreEmpresa: '',
    descripcion: '',
    correo: '',
    nombre: '',
    password: '',
    fechaNacimiento: ''
  };

  confirmPassword: string = '';
  errorMessage: string = '';
  successMessage: string = '';
  isLoading: boolean = false;

  constructor(
    private empresaService: EmpresaService,
    private router: Router
  ) {}

  onSubmit(): void {
    this.errorMessage = '';
    this.successMessage = '';

    if (!this.registroData.nombreEmpresa || !this.registroData.descripcion ||
        !this.registroData.correo || !this.registroData.nombre ||
        !this.registroData.password || !this.registroData.fechaNacimiento) {
      this.errorMessage = 'Por favor complete todos los campos';
      return;
    }

    if (this.registroData.password !== this.confirmPassword) {
      this.errorMessage = 'Las contraseñas no coinciden';
      return;
    }

    if (this.registroData.password.length < 6) {
      this.errorMessage = 'La contraseña debe tener al menos 6 caracteres';
      return;
    }

    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailRegex.test(this.registroData.correo)) {
      this.errorMessage = 'El formato del correo no es válido';
      return;
    }

    this.isLoading = true;

    this.empresaService.registrarEmpresa(this.registroData).subscribe({
      next: (response) => {
        this.isLoading = false;
        if (response.success) {
          this.successMessage = '¡Empresa registrada exitosamente! Redirigiendo al login...';
          setTimeout(() => {
            this.router.navigate(['/login-empresa']);
          }, 2000);
        } else {
          this.errorMessage = response.message;
        }
      },
      error: (error) => {
        this.isLoading = false;
        console.error('Error en registro:', error);
        if (error.status === 409) {
          this.errorMessage = 'El correo ya está registrado';
        } else if (error.status === 0) {
          this.errorMessage = 'No se pudo conectar con el servidor';
        } else {
          this.errorMessage = error.error?.message || 'Error al registrar empresa';
        }
      }
    });
  }

  clearMessages(): void {
    this.errorMessage = '';
    this.successMessage = '';
  }
}