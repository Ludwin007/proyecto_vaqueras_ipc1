import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AutenticacionService } from '../../services/autenticacion.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

  constructor(
    private router: Router,
    private autenticacionService: AutenticacionService
  ) {
    if (this.autenticacionService.isAuthenticated()) {
      this.redirectToDashboard();
    }
  }

  private redirectToDashboard(): void {
    const tipoUsuario = this.autenticacionService.getTipoUsuario();
    if (tipoUsuario === 'gamer') {
      this.router.navigate(['/dashboard-gamer']);
    } else if (tipoUsuario === 'empresa') {
      this.router.navigate(['/dashboard-empresa']);
    }
  }
}