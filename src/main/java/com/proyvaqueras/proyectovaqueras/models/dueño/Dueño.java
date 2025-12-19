/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyvaqueras.proyectovaqueras.models.dueño;
import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author ludwi
 */

public class Dueño {
    private int idDueño;
    private int idEmpresa;
    private String correo;
    private String password;
    private String nombre;
    private Date fechaNacimiento;
    private Timestamp fechaCreacion;
    
    public Dueño() {}
    
    public Dueño(int idDueño, int idEmpresa, String correo, 
                         String password, String nombre, Date fechaNacimiento, 
                         Timestamp fechaCreacion) {
        this.idDueño = idDueño;
        this.idEmpresa = idEmpresa;
        this.correo = correo;
        this.password = password;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaCreacion = fechaCreacion;
    }
    
    public int getIdUsuarioEmpresa() {
        return idDueño;
    }
    
    public void setIdUsuarioEmpresa(int idUsuarioEmpresa) {
        this.idDueño = idDueño;
    }
    
    public int getIdEmpresa() {
        return idEmpresa;
    }
    
    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
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
    
    public Timestamp getFechaCreacion() {
        return fechaCreacion;
    }
    
    public void setFechaCreacion(Timestamp fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    
    @Override
    public String toString() {
        return "UsuarioEmpresa{" +
                "idDueñoEmpresa=" + idDueño +
                ", idEmpresa=" + idEmpresa +
                ", correo='" + correo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                '}';
    }
}