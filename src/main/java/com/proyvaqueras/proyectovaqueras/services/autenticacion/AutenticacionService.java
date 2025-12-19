/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyvaqueras.proyectovaqueras.services.autenticacion;

import com.proyvaqueras.proyectovaqueras.models.DatabaseConnection;
import com.proyvaqueras.proyectovaqueras.models.dueño.Dueño;
import com.proyvaqueras.proyectovaqueras.models.gamers.Gamer;
import com.proyvaqueras.proyectovaqueras.dtos.DueñoDTO;
import com.proyvaqueras.proyectovaqueras.dtos.GamersDTO;
import java.sql.*;

/**
 *
 * @author ludwi
 */

public class AutenticacionService{
    
    public DueñoDTO loginEmpresa(String correo, String password) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = DatabaseConnection.getConnection();
            
            String sql = "SELECT ue.id_dueño, ue.id_empresa, ue.correo, " +
                        "ue.nombre, e.nombre as nombre " +
                        "FROM dueño_empresa ue " +
                        "INNER JOIN empresa e ON ue.id_empresa = e.id_empresa " +
                        "WHERE ue.correo = ? AND ue.password = ?";
            
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, correo);
            stmt.setString(2, password);
            
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                return new DueñoDTO(
                    rs.getInt("id_dueño"),
                    rs.getInt("id_empresa"),
                    rs.getString("correo"),
                    rs.getString("nombre"),
                    rs.getString("nombre_empresa")
                );
            }
            
            return null;
            
        } catch (SQLException e) {
            System.err.println("Error en loginEmpresa: " + e.getMessage());
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public GamersDTO loginGamer(String correo, String password) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = DatabaseConnection.getConnection();
            
            String sql = "SELECT id_usuario, nickname, correo, pais, saldo_cartera, " +
                        "biblioteca_publica FROM gamers " +
                        "WHERE (correo = ? OR nickname = ?) AND password = ?";
            
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, correo);
            stmt.setString(2, correo);
            stmt.setString(3, password); 
            
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                return new GamersDTO(
                    rs.getInt("id_usuario"),
                    rs.getString("nickname"),
                    rs.getString("correo"),
                    rs.getString("pais"),
                    rs.getDouble("saldo_cartera"),
                    rs.getBoolean("biblioteca_publica")
                );
            }
            
            return null;
            
        } catch (SQLException e) {
            System.err.println("Error en loginGamer: " + e.getMessage());
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public boolean correoExiste(String correo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = DatabaseConnection.getConnection();
            
            String sql = "SELECT 1 FROM dueño_empresa WHERE correo = ? " +
                        "UNION " +
                        "SELECT 1 FROM gamers WHERE correo = ? " +
                        "UNION " +
                        "SELECT 1 FROM administrador_del_sistema WHERE correo = ?";
            
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, correo);
            stmt.setString(2, correo);
            stmt.setString(3, correo);
            
            rs = stmt.executeQuery();
            
            return rs.next(); 
            
        } catch (SQLException e) {
            System.err.println("Error en correoExiste: " + e.getMessage());
            e.printStackTrace();
            return true; 
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    

    public boolean nicknameExiste(String nickname) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = DatabaseConnection.getConnection();
            
            String sql = "SELECT 1 FROM gamers WHERE nickname = ?";
            
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, nickname);
            
            rs = stmt.executeQuery();
            
            return rs.next();
            
        } catch (SQLException e) {
            System.err.println("Error en nicknameExiste: " + e.getMessage());
            e.printStackTrace();
            return true;
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}