/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyvaqueras.proyectovaqueras.models;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ludwi
 */

public class DatabaseConnection {

    public static Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
private Connection conn;
private String url = "jdbc:mysql://localhost:3306/proyectovaqueras";
private String usuario = "Gerard";
private String password = "12345";

public Connection conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
  
            conn = DriverManager.getConnection(url, usuario, password);
            System.out.println("Conexión exitosa");
            return conn;
        } catch (SQLException e) {
            System.err.println("Error al conectar: " + e.getMessage());
            return null;
        } catch (ClassNotFoundException e) {
            System.err.println("Error al cargar el driver: " + e.getMessage());
            return null;
        }
    }

    public void desconectar(Connection c) {
        if (c != null) {
            try {
                c.close();
                System.out.println("Conexión cerrada");
            } catch (SQLException e) {
                System.err.println("Error al cerrar conexión: " + e.getMessage());
            }
        }
    }

}