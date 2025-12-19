/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyvaqueras.proyectovaqueras.services.gamer;

import com.proyvaqueras.proyectovaqueras.models.DatabaseConnection;
import com.proyvaqueras.proyectovaqueras.dtos.RegistroGamerDTO;
import com.proyvaqueras.proyectovaqueras.dtos.GamersDTO;
import com.proyvaqueras.proyectovaqueras.services.autenticacion.AutenticacionService;

import java.sql.*;

/**
 *
 * @author ludwi
 */

public class GamerService {
    
    private AutenticacionService autenticacionService = new AutenticacionService();
    
    public GamersDTO registrarGamer(RegistroGamerDTO dto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            if (autenticacionService.correoExiste(dto.getCorreo())) {
                System.err.println("El correo ya está registrado");
                return null;
            }
            
            if (autenticacionService.nicknameExiste(dto.getNickname())) {
                System.err.println("El nickname ya está en uso");
                return null;
            }
            
            conn = DatabaseConnection.getConnection();
            
            String sql = "INSERT INTO gamers (nickname, password, fecha_nacimiento, " +
                        "correo, telefono, pais, saldo_cartera, biblioteca_publica) " +
                        "VALUES (?, ?, ?, ?, ?, ?, 0.00, TRUE)";
            
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, dto.getNickname());
            stmt.setString(2, dto.getPassword());
            stmt.setDate(3, dto.getFechaNacimiento());
            stmt.setString(4, dto.getCorreo());
            stmt.setString(5, dto.getTelefono());
            stmt.setString(6, dto.getPais());
            
            int filasAfectadas = stmt.executeUpdate();
            
            if (filasAfectadas > 0) {
                
                rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    int idGenerado = rs.getInt(1);
                    
                    return new GamersDTO(
                        idGenerado,
                        dto.getNickname(),
                        dto.getCorreo(),
                        dto.getPais(),
                        0.00,
                        true
                    );
                }
            }
            
            return null;
            
        } catch (SQLException e) {
            System.err.println("Error en registrarGamer: " + e.getMessage());
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
}