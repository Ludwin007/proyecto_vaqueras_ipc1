/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyvaqueras.proyectovaqueras.dtos;

/**
 *
 * @author ludwi
 */

public class DueñoDTO {
private int idDueño;
private int idEmpresa;
private String correo;
private String nombre;
private String nombreEmpresa;
    
public DueñoDTO() {}
 public DueñoDTO(int idDueño, int idEmpresa, String correo, 
   String nombre, String nombreEmpresa) {
        this.idDueño = idDueño;
        this.idEmpresa = idEmpresa;
        this.correo = correo;
        this.nombre = nombre;
        this.nombreEmpresa = nombreEmpresa;
    }
    
 public int getIdUsuarioEmpresa() {
        return idDueño;
    }
    
public void setIdUsuarioEmpresa(int idDueño) {
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
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombreEmpresa() {
        return nombreEmpresa;
    }
    
    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }
}