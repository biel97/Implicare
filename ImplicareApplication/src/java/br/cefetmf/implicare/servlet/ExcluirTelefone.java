/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmf.implicare.servlet;

import br.cefetmg.implicare.model.domain.Telefone;
import br.cefetmg.implicare.model.service.TelefoneManagement;
import br.cefetmg.implicare.model.serviceImpl.TelefoneManagementImpl;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Gabriel
 * 
 */

class ExcluirTelefone {

    static String execute(HttpServletRequest request) {
        String jsp = "";
        try {

            int Seq_Telefone = Integer.parseInt(request.getParameter("Seq_Telefone"));

            TelefoneManagement TelefoneManagement = new TelefoneManagementImpl();
            Telefone Tel = new Telefone();
            Tel = TelefoneManagement.pesquisar(Seq_Telefone);
            
            boolean Telefone = TelefoneManagement.delete(Tel);

            if (Telefone =! false) {
                jsp = "";
                request.setAttribute("Telefone", Tel);
            } else {
                String Erro = "Erro ao Excluir Telefone";
                jsp = "/WEB-Pages/Erro.jsp";
                request.setAttribute("Erro", Erro);
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
    
}
