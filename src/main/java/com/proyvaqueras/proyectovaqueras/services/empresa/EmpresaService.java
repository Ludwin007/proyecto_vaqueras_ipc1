/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyvaqueras.proyectovaqueras.services.empresa;
import com.proyvaqueras.proyectovaqueras.models.DatabaseConnection;
import com.proyvaqueras.proyectovaqueras.dtos.RegistroEmpresaDTO;
import com.proyvaqueras.proyectovaqueras.dtos.DueñoDTO;
import com.proyvaqueras.proyectovaqueras.services.autenticacion.AutenticacionService;
import java.sql.*;

/**
 *
 * @author ludwi
 */

public class EmpresaService {
    
   private AutenticacionService autenticacionService = new AutenticacionService();
    
    public DueñoDTO registrarEmpresa(RegistroEmpresaDTO dto) {
        Connection conn = null;
        PreparedStatement stmtEmpresa = null;
        PreparedStatement stmtUsuario = null;
        ResultSet rs = null;
        
        try {
            if (autenticacionService.correoExiste(dto.getCorreo())) {
                System.err.println("El correo ya está registrado");
                return null;
            }
            
            conn = DatabaseConnection.getConnection();
            conn.setAutoCommit(false); 
            
            String sqlEmpresa = "INSERT INTO empresa (nombre, descripcion) VALUES (?, ?)";
            stmtEmpresa = conn.prepareStatement(sqlEmpresa, Statement.RETURN_GENERATED_KEYS);
            stmtEmpresa.setString(1, dto.getNombreEmpresa());
            stmtEmpresa.setString(2, dto.getDescripcion());
            
            int filasEmpresa = stmtEmpresa.executeUpdate();
            
            if (filasEmpresa == 0) {
                conn.rollback();
                return null;
            }
            
            rs = stmtEmpresa.getGeneratedKeys();
            if (!rs.next()) {
                conn.rollback();
                return null;
            }
            
            int idEmpresa = rs.getInt(1);
            rs.close();

            String sqlUsuario = "INSERT INTO dueño_empresa " +
                              "(id_empresa, correo, password, nombre, fecha_nacimiento) " +
                              "VALUES (?, ?, ?, ?, ?)";
            
            stmtUsuario = conn.prepareStatement(sqlUsuario, Statement.RETURN_GENERATED_KEYS);
            stmtUsuario.setInt(1, idEmpresa);
            stmtUsuario.setString(2, dto.getCorreo());
            stmtUsuario.setString(3, dto.getPassword()); 
            stmtUsuario.setString(4, dto.getNombre());
            stmtUsuario.setDate(5, dto.getFechaNacimiento());
            
            int filasUsuario = stmtUsuario.executeUpdate();
            
            if (filasUsuario == 0) {
                conn.rollback();
                return null;
            }
            
            rs = stmtUsuario.getGeneratedKeys();
            if (!rs.next()) {
                conn.rollback();
                return null;
            }
            
            int idUsuario = rs.getInt(1);
            
            conn.commit();
            
            return new DueñoDTO(
                idUsuario,
                idEmpresa,
                dto.getCorreo(),
                dto.getNombre(),
                dto.getNombreEmpresa()
            );
            
        } catch (SQLException e) {
            System.err.println("Error en registrarEmpresa: " + e.getMessage());
            e.printStackTrace();
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return null;
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmtEmpresa != null) stmtEmpresa.close();
                if (stmtUsuario != null) stmtUsuario.close();
                if (conn != null) {
                    conn.setAutoCommit(true);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}