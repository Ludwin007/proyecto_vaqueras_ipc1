/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.proyvaqueras.proyectovaqueras.controllers;

import com.google.gson.Gson;
import com.proyvaqueras.proyectovaqueras.dtos.ResponseDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author ludwi
 */


@WebServlet(name = "LogoutController", urlPatterns = {"/api/logout"})
public class LogoutController extends HttpServlet {
    
    private Gson gson = new Gson();
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("application/json;charset=UTF-8");
        
        try {
            HttpSession session = request.getSession(false);
            
            if (session != null) {
                session.invalidate();
            }
            
            ResponseDTO successResponse = new ResponseDTO(true, "Bye, sesión cerrada exitosamente");
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().write(gson.toJson(successResponse));
            
        } catch (Exception e) {
            System.err.println("Error en LogoutController: " + e.getMessage());
            e.printStackTrace();
            
            ResponseDTO errorResponse = new ResponseDTO(false, "Opps, error al cerrar sesión");
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