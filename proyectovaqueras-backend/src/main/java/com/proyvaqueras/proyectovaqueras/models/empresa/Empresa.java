/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyvaqueras.proyectovaqueras.models.empresa;
import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author ludwi
 */

public class Empresa {
    private int idEmpresa;
    private String nombre;
    private String descripcion;
    private Double porcentajeComision; // Nullable
    private Timestamp fechaRegistro;
    
    public Empresa() {}
    
    public Empresa(int idEmpresa, String nombre, String descripcion, 
                   Double porcentajeComision, Timestamp fechaRegistro) {
        this.idEmpresa = idEmpresa;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.porcentajeComision = porcentajeComision;
        this.fechaRegistro = fechaRegistro;
    }
    
    public int getIdEmpresa() {
        return idEmpresa;
    }
    
    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public Double getPorcentajeComision() {
        return porcentajeComision;
    }
    
    public void setPorcentajeComision(Double porcentajeComision) {
        this.porcentajeComision = porcentajeComision;
    }
    
    public Timestamp getFechaRegistro() {
        return fechaRegistro;
    }
    
    public void setFechaRegistro(Timestamp fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
    @Override
    public String toString() {
        return "Empresa{" +
                "idEmpresa=" + idEmpresa +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", porcentajeComision=" + porcentajeComision +
                ", fechaRegistro=" + fechaRegistro +
                '}';
    }
}