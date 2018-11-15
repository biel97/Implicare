/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmf.implicare.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.registry.InvalidRequestException;

/**
 *
 * @author Gabriel
 */
public class ImplicareServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InvalidRequestException {

        request.setCharacterEncoding("UTF-8");

        String jsp;
        String action = request.getParameter("action");

        if(action == null || action.isEmpty()) { 
            throw new InvalidRequestException("Erro: nenhuma ação foi solicitada.");
        }

        switch (action) {
            
        }
        
        //Cria um dispatcher da solicita,c~ao.
        RequestDispatcher dispatcher = request.getRequestDispatcher(jsp);
        //Redireciona a p´agina.
        dispatcher.forward(request, response);
    }
    
}


