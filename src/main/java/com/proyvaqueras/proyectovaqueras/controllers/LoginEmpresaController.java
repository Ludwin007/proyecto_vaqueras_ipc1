/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.proyvaqueras.proyectovaqueras.controllers;

import com.google.gson.Gson;
import com.proyvaqueras.proyectovaqueras.dtos.LoginDTO;
import com.proyvaqueras.proyectovaqueras.dtos.DueñoDTO;
import com.proyvaqueras.proyectovaqueras.dtos.ResponseDTO;
import com.proyvaqueras.proyectovaqueras.services.autenticacion.AutenticacionService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author ludwi
 */

@WebServlet(name = "LoginEmpresaController", urlPatterns = {"/api/login/empresa"})
public class LoginEmpresaController extends HttpServlet {
      
   /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    
    private AutenticacionService autenticacionService = new AutenticacionService();
    private Gson gson = new Gson();
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("application/json;charset=UTF-8");
        
        try {
  
            BufferedReader reader = request.getReader();
            LoginDTO loginDTO = gson.fromJson(reader, LoginDTO.class);
            
            if (loginDTO.getCorreo() == null || loginDTO.getCorreo().isEmpty()) {
                ResponseDTO errorResponse = new ResponseDTO(false, "Opps, el correo es obligatorio");
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().write(gson.toJson(errorResponse));
                return;
            }
            
            if (loginDTO.getPassword() == null || loginDTO.getPassword().isEmpty()) {
                ResponseDTO errorResponse = new ResponseDTO(false, "Opps, la contraseña es obligatoria");
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().write(gson.toJson(errorResponse));
                return;
            }
            
            DueñoDTO usuario = autenticacionService.loginEmpresa(
                loginDTO.getCorreo(), 
                loginDTO.getPassword()
            );
            
            if (usuario != null) {
                HttpSession session = request.getSession(true);
                session.setAttribute("tipoUsuario", "empresa");
                session.setAttribute("usuario", usuario);
                session.setAttribute("idUsuario", usuario.getIdDueño());
                session.setAttribute("idEmpresa", usuario.getIdEmpresa());
                
                ResponseDTO successResponse = new ResponseDTO(true, "Listo, login exitoso", usuario);
                response.setStatus(HttpServletResponse.SC_OK);
                response.getWriter().write(gson.toJson(successResponse));
                
            } else {
                ResponseDTO errorResponse = new ResponseDTO(false, "Correo o contraseña incorrectos");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write(gson.toJson(errorResponse));
            }
            
        } catch (Exception e) {
            System.err.println("Error en LoginEmpresaController: " + e.getMessage());
            e.printStackTrace();
            
            ResponseDTO errorResponse = new ResponseDTO(false, "Error interno del servidor");
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write(gson.toJson(errorResponse));
        }
    }
    
    @Override
    protected void doOptions(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "POST, OPTIONS");
            response.setHeader("Access-Control-Allow-Headers", "Content-Type");
            response.setStatus(HttpServletResponse.SC_OK);
    }
    
}