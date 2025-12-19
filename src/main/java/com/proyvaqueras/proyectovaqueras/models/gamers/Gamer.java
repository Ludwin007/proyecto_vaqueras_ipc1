/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyvaqueras.proyectovaqueras.models.gamers;
import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author ludwi
 */

public class Gamer {
    private int idUsuario;
    private String nickname;
    private String password;
    private Date fechaNacimiento;
    private String correo;
    private String telefono;
    private String pais;
    private double saldoCartera;
    private Timestamp fechaRegistro;
    private boolean bibliotecaPublica;
    private String avatar;
    
    public Gamer() {}
    
    public Gamer(int idUsuario, String nickname, String password, 
                Date fechaNacimiento, String correo, String telefono, 
                String pais, double saldoCartera, Timestamp fechaRegistro, 
                boolean bibliotecaPublica, String avatar) {
        this.idUsuario = idUsuario;
        this.nickname = nickname;
        this.password = password;
        this.fechaNacimiento = fechaNacimiento;
        this.correo = correo;
        this.telefono = telefono;
        this.pais = pais;
        this.saldoCartera = saldoCartera;
        this.fechaRegistro = fechaRegistro;
        this.bibliotecaPublica = bibliotecaPublica;
        this.avatar = avatar;
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
    
    public double getSaldoCartera() {
        return saldoCartera;
    }
    
    public void setSaldoCartera(double saldoCartera) {
        this.saldoCartera = saldoCartera;
    }
    
    public Timestamp getFechaRegistro() {
        return fechaRegistro;
    }
    
    public void setFechaRegistro(Timestamp fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
    public boolean isBibliotecaPublica() {
        return bibliotecaPublica;
    }
    
    public void setBibliotecaPublica(boolean bibliotecaPublica) {
        this.bibliotecaPublica = bibliotecaPublica;
    }
    
    public String getAvatar() {
        return avatar;
    }
    
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    
    @Override
    public String toString() {
        return "Gamer{" +
                "idUsuario=" + idUsuario +
                ", nickname='" + nickname + '\'' +
                ", correo='" + correo + '\'' +
                ", pais='" + pais + '\'' +
                ", saldoCartera=" + saldoCartera +
                ", fechaRegistro=" + fechaRegistro +
                '}';
    }
}