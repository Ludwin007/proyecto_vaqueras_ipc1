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

public class RegistroGamerDTO {
private String nickname;
private String password;
private String confirmPassword;
private Date fechaNacimiento;
private String correo;
private String telefono;
private String pais;
    
public RegistroGamerDTO() {}
    
    public RegistroGamerDTO(String nickname, String password, String confirmPassword,
    Date fechaNacimiento, String correo, String telefono, 
    String pais) {
        this.nickname = nickname;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.fechaNacimiento = fechaNacimiento;
        this.correo = correo;
        this.telefono = telefono;
        this.pais = pais;
    }
    
   
    public String getNickname() {
        return nickname;
    }
    
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getConfirmPassword() {
        return confirmPassword;
    }
    
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
    
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }
    
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public String getCorreo() {
        return correo;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public String getTelefono() {
        return telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public String getPais() {
        return pais;
    }
    
    public void setPais(String pais) {
        this.pais = pais;
    }
    
    
public boolean validar() {
        return nickname != null && !nickname.trim().isEmpty()
            && password != null && !password.trim().isEmpty()
            && confirmPassword != null && !confirmPassword.trim().isEmpty()
            && fechaNacimiento != null
            && correo != null && !correo.trim().isEmpty()
            && telefono != null && !telefono.trim().isEmpty()
            && pais != null && !pais.trim().isEmpty();
 }
    
  
  public boolean passwordsCoinciden() {
        return password != null && password.equals(confirmPassword);
   }
    
  public boolean correoValido() {
        if (correo == null || correo.trim().isEmpty()) {
            return false;
        }
        return correo.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }
    
   
  public boolean nicknameValido() {
        return nickname != null && nickname.length() >= 3 && nickname.length() <= 50;
    }
    
    
   public boolean passwordValido() {
        return password != null && password.length() >= 6;
    }
    
    @Override
    public String toString() {
        return "RegistroGamerDTO{" +
                "nickname='" + nickname + '\'' +
                ", correo='" + correo + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }
}
