/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.proyvaqueras.proyectovaqueras.controllers;

import com.google.gson.Gson;
import com.proyvaqueras.proyectovaqueras.dtos.RegistroEmpresaDTO;
import com.proyvaqueras.proyectovaqueras.dtos.DueñoDTO;
import com.proyvaqueras.proyectovaqueras.dtos.ResponseDTO;
import com.proyvaqueras.proyectovaqueras.services.empresa.EmpresaService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author ludwi
 */


@WebServlet(name = "RegistroEmpresaController", urlPatterns = {"/api/registro/empresa"})
public class RegistroEmpresaController extends HttpServlet {
    
   /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */ 
    
    private EmpresaService empresaService = new EmpresaService();
    private Gson gson = new Gson();
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("application/json;charset=UTF-8");
        
        try {
            BufferedReader reader = request.getReader();
            RegistroEmpresaDTO registroDTO = gson.fromJson(reader, RegistroEmpresaDTO.class);
            
            if (!registroDTO.validar()) {
                ResponseDTO errorResponse = new ResponseDTO(false, "Opps, todos los campos son obligatorios");
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().write(gson.toJson(errorResponse));
                return;
            }
           
            DueñoDTO usuario = empresaService.registrarEmpresa(registroDTO);
            
            if (usuario != null) {
                ResponseDTO successResponse = new ResponseDTO(
                    true, 
                    "Listo, empresa registrada exitosamente", 
                    usuario
                );
                response.setStatus(HttpServletResponse.SC_CREATED);
                response.getWriter().write(gson.toJson(successResponse));
                
            } else {
                ResponseDTO errorResponse = new ResponseDTO(
                    false, 
                    "Opps, no se pudo registrar la empresa. El correo ya esta en uso."
                );
                response.setStatus(HttpServletResponse.SC_CONFLICT);
                response.getWriter().write(gson.toJson(errorResponse));
            }
            
        } catch (Exception e) {
            System.err.println("Error en RegistroEmpresaController: " + e.getMessage());
            e.printStackTrace();
            
            ResponseDTO errorResponse = new ResponseDTO(false, "Opps, error interno del servidor");
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
