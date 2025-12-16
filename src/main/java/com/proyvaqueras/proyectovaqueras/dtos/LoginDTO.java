/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyvaqueras.proyectovaqueras.dtos;

/**
 *
 * @author ludwi
 */

public class LoginDTO {
private String correo;
private String password;
    
public LoginDTO() {}
    
    public LoginDTO(String correo, String password) {
        this.correo = correo;
        this.password = password;
    }
    
    public String getCorreo() {
        return correo;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
}