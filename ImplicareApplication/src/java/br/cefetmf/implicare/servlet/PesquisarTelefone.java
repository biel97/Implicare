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

class PesquisarTelefone {

    static String execute(HttpServletRequest request) {
        String jsp = "";
        try {

            int Seq_Telefone = (int) request.getSession().getAttribute("Seq_Telefone");

            TelefoneManagement TelefoneManagement = new TelefoneManagementImpl();
            Telefone Tel = new Telefone();
            Tel = TelefoneManagement.pesquisar(Seq_Telefone);
            
            if (Tel != null) {
                jsp = "EditarTelefone.jsp";
                request.setAttribute("Telefone", Tel);
            } 
            
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
    
}
