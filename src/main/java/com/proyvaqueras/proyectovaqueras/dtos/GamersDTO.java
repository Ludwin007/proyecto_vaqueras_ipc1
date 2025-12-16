/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyvaqueras.proyectovaqueras.dtos;

/**
 *
 * @author ludwi
 */

public class GamersDTO {
private int idUsuario;
private String nickname;
private String correo;
private String pais;
private double saldoCartera;
private boolean bibliotecaPublica;
    
public GamersDTO() {}
    
    public GamersDTO(int idUsuario, String nickname, String correo, 
    String pais, double saldoCartera, boolean bibliotecaPublica) {
        this.idUsuario = idUsuario;
        this.nickname = nickname;
        this.correo = correo;
        this.pais = pais;
        this.saldoCartera = saldoCartera;
        this.bibliotecaPublica = bibliotecaPublica;
    }
    
    public int getIdUsuario() {
        return idUsuario;
    }
    
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    public String getNickname() {
        return nickname;
    }
    
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    
    public String getCorreo() {
        return correo;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public String getPais() {
        return pais;
    }
    
    public void setPais(String pais) {
        this.pais = pais;
    }
    
    public double getSaldoCartera() {
        return saldoCartera;
    }
    
    public void setSaldoCartera(double saldoCartera) {
        this.saldoCartera = saldoCartera;
    }
    
    public boolean isBibliotecaPublica() {
        return bibliotecaPublica;
    }
    
    public void setBibliotecaPublica(boolean bibliotecaPublica) {
        this.bibliotecaPublica = bibliotecaPublica;
    }
}
