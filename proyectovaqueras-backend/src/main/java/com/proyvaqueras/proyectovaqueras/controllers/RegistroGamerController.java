/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.proyvaqueras.proyectovaqueras.controllers;

import com.google.gson.Gson;
import com.proyvaqueras.proyectovaqueras.dtos.RegistroGamerDTO;
import com.proyvaqueras.proyectovaqueras.dtos.GamersDTO;
import com.proyvaqueras.proyectovaqueras.dtos.ResponseDTO;
import com.proyvaqueras.proyectovaqueras.services.gamer.GamerService;
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


@WebServlet(name = "RegistroGamerController", urlPatterns = {"/api/registro/gamer"})
public class RegistroGamerController extends HttpServlet {
    
   /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */   
    
    private GamerService gamerService = new GamerService();
    private Gson gson = new Gson();
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("application/json;charset=UTF-8");
        
        try {
            BufferedReader reader = request.getReader();
            RegistroGamerDTO registroDTO = gson.fromJson(reader, RegistroGamerDTO.class);
            
            if (!registroDTO.validar()) {
                ResponseDTO errorResponse = new ResponseDTO(false, "Opps, todos los campos son obligatorios");
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().write(gson.toJson(errorResponse));
                return;
            }
            
            if (!registroDTO.passwordsCoinciden()) {
                ResponseDTO errorResponse = new ResponseDTO(false, "Opps, las contraseñas no coinciden");
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().write(gson.toJson(errorResponse));
                return;
            }
            
            if (!registroDTO.correoValido()) {
                ResponseDTO errorResponse = new ResponseDTO(false, "Opps, el formato del correo no es válido");
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().write(gson.toJson(errorResponse));
                return;
            }
            
            if (!registroDTO.nicknameValido()) {
                ResponseDTO errorResponse = new ResponseDTO(false, "Opps, el nickname debe tener entre 3 y 50 caracteres");
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().write(gson.toJson(errorResponse));
                return;
            }
            
            if (!registroDTO.passwordValido()) {
                ResponseDTO errorResponse = new ResponseDTO(false, "Opps, la contraseña debe tener al menos 6 caracteres");
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().write(gson.toJson(errorResponse));
                return;
            }
            
            GamersDTO gamer = gamerService.registrarGamer(registroDTO);
            
            if (gamer != null) {
                ResponseDTO successResponse = new ResponseDTO(
                    true, 
                    "Listo, Usuario registrado exitosamente", 
                    gamer
                );
                response.setStatus(HttpServletResponse.SC_CREATED);
                response.getWriter().write(gson.toJson(successResponse));
                
            } else {
                ResponseDTO errorResponse = new ResponseDTO(
                    false, 
                    "Opps, no se pudo registrar el usuario. El correo o nickname ya podrían estar en uso."
                );
                response.setStatus(HttpServletResponse.SC_CONFLICT);
                response.getWriter().write(gson.toJson(errorResponse));
            }
            
        } catch (Exception e) {
            System.err.println("Error en RegistroGamerController: " + e.getMessage());
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