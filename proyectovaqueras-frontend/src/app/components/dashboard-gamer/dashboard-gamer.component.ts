import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AutenticacionService } from '../../services/autenticacion.service';

@Component({
  selector: 'app-dashboard-gamer',
  templateUrl: './dashboard-gamer.component.html',
  styleUrls: ['./dashboard-gamer.component.css']
})
export class DashboardGamerComponent implements OnInit {
  usuario: any;

  constructor(
    private autenticacionService: AutenticacionService,
    private router: Router
  ) {}

  ngOnInit(): void {
    if (!this.autenticacionService.isAuthenticated()) {
      this.router.navigate(['/login-gamer']);
      return;
    }

    this.usuario = this.autenticacionService.getCurrentUser();
    
    if (this.usuario.tipoUsuario !== 'gamer') {
      this.router.navigate(['/']);
    }
  }

  logout(): void {
    this.autenticacionService.logout().subscribe({
      next: () => {
        this.router.navigate(['/']);
      },
      error: (error) => {
        console.error('Error al cerrar sesión:', error);
        this.router.navigate(['/']);
      }
    });
  }
}
