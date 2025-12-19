/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyvaqueras.proyectovaqueras.models.administrador;
import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author ludwi
 */

public class Administrador {
    private int idAdministrador;
    private String correo;
    private String password;
    private String nombre;
    private Date fechaNacimiento;
    private Timestamp fechaRegistro;
    
    public Administrador() {}
    
    public Administrador(int idAdministrador, String correo, String password, 
                        String nombre, Date fechaNacimiento, Timestamp fechaRegistro) {
        this.idAdministrador = idAdministrador;
        this.correo = correo;
        this.password = password;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaRegistro = fechaRegistro;
    }
    
    public int getIdAdministrador() {
        return idAdministrador;
    }
    
    public void setIdAdministrador(int idAdministrador) {
        this.idAdministrador = idAdministrador;
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
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }
    
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public Timestamp getFechaRegistro() {
        return fechaRegistro;
    }
    
    public void setFechaRegistro(Timestamp fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
    @Override
    public String toString() {
        return "Administrador{" +
                "idAdministrador=" + idAdministrador +
                ", correo='" + correo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", fechaRegistro=" + fechaRegistro +
                '}';
    }
}