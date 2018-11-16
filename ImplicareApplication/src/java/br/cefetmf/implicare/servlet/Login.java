/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmf.implicare.servlet;

import br.cefetmg.implicare.model.domain.Usuario;
import br.cefetmg.implicare.model.service.UsuarioManagement;
import br.cefetmg.implicare.model.serviceImpl.UsuarioManagementImpl;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Gabriel
 * 
 */

class Login {

    static String execute(HttpServletRequest request) {
         String jsp = "";
        try {
            long CPF_CNPJ = Long.parseLong(request.getParameter("CPF_CNPJ"));
            String Senha = request.getParameter("Senha");

            UsuarioManagement UsuarioManagement = new UsuarioManagementImpl();
            Usuario user = new Usuario();
            user = UsuarioManagement.login(CPF_CNPJ, Senha);
            
            if(user == null) {
                return "/login.jsp";
            }
            
            
            if (CPF_CNPJ == 0 || Senha.isEmpty()) {
                jsp = "/erro.jsp";
            } 
            else {

                HttpSession session = request.getSession();
                request.getSession().setAttribute("CPF_CNPJ",user.getCPF_CNPJ());
                request.getSession().setAttribute("Email", user.getEmail());
                request.getSession().setAttribute("Foto",user.getFoto());
                request.getSession().setAttribute("Endereço", user.getEndereco());
                request.getSession().setAttribute("Cod_CEP",user.getCod_CEP());
                request.getSession().setAttribute("Desc_Usuario", user.getDesc_Usuario());
                
                jsp = "/VisualizarExcluirAnimal.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsp;
    }
    
    public static void validarSessao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        Long CPF_CNPJ = (Long) request.getSession().getAttribute("CPF_CNPJ");
        System.out.println(request.getSession().getAttribute("CPF_CNPJ"));
        String jsp = "";
        if (CPF_CNPJ == null) {
            jsp = "/index.jsp";
            RequestDispatcher rd = request.getRequestDispatcher(jsp);
            rd.forward(request, response);
        }
    }
   
}
