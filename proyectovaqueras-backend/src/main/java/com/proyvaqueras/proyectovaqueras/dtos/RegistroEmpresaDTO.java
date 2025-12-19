/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyvaqueras.proyectovaqueras.dtos;
import java.sql.Date;

/**
 *
 * @author ludwi
 */

public class RegistroEmpresaDTO {
private String nombreEmpresa;
private String descripcion;
private String correo;
private String nombre;
private String password;
private Date fechaNacimiento;
    
public RegistroEmpresaDTO() {}

public RegistroEmpresaDTO(String nombreEmpresa, String descripcion, 
     String correo, String nombre, String password, 
 Date fechaNacimiento) {
        this.nombreEmpresa = nombreEmpresa;
        this.descripcion = descripcion;
        this.correo = correo;
        this.nombre = nombre;
        this.password = password;
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public String getNombreEmpresa() {
        return nombreEmpresa;
    }
    
    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getCorreo() {
        return correo;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }
    
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    

public boolean validar() {
        return nombreEmpresa != null && !nombreEmpresa.trim().isEmpty()
            && descripcion != null && !descripcion.trim().isEmpty()
            && correo != null && !correo.trim().isEmpty()
            && nombre != null && !nombre.trim().isEmpty()
            && password != null && !password.trim().isEmpty()
            && fechaNacimiento != null;
 }
    
    @Override
 public String toString() {
  return "RegistroEmpresaDTO{" +
  "nombreEmpresa='" + nombreEmpresa + '\'' +
     ", correo='" + correo + '\'' +
     ", nombre='" + nombre + '\'' +
     '}';
    }
}