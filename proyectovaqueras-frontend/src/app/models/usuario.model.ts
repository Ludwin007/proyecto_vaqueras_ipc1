export interface LoginDTO {
  correo: string;
  password: string;
}

export interface ResponseDTO {
  success: boolean;
  message: string;
  data?: any;
}

export interface DueñoDTO {
  idUsuarioEmpresa: number;
  idEmpresa: number;
  correo: string;
  nombre: string;
  nombreEmpresa: string;
}

export interface GamersDTO {
  idUsuario: number;
  nickname: string;
  correo: string;
  pais: string;
  saldoCartera: number;
  bibliotecaPublica: boolean;
}

export interface RegistroEmpresaDTO {
  nombreEmpresa: string;
  descripcion: string;
  correo: string;
  nombre: string;
  password: string;
  fechaNacimiento: string;
}

export interface RegistroGamerDTO {
  nickname: string;
  password: string;
  confirmPassword: string;
  fechaNacimiento: string; 
  correo: string;
  telefono: string;
  pais: string;
}