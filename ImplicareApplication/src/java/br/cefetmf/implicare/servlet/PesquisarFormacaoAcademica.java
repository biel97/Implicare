/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmf.implicare.servlet;

import br.cefetmg.implicare.model.domain.AreaEstudo;
import br.cefetmg.implicare.model.domain.FormacaoAcademica;
import br.cefetmg.implicare.model.service.AreaEstudoManagement;
import br.cefetmg.implicare.model.service.FormacaoAcademicaManagement;
import br.cefetmg.implicare.model.serviceImpl.AreaEstudoManagementImpl;
import br.cefetmg.implicare.model.serviceImpl.FormacaoAcademicaManagementImpl;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Gabriel
 * 
 */

class PesquisarFormacaoAcademica {

    static String execute(HttpServletRequest request) {
        String jsp = "";
        try {

            int Seq_Formacao = Integer.parseInt(request.getParameter("Seq_Formacao"));
            
            FormacaoAcademicaManagement FormacaoAcademicaManagement = new FormacaoAcademicaManagementImpl();
            FormacaoAcademica FormAcad = new FormacaoAcademica();
            FormAcad = FormacaoAcademicaManagement.pesquisar(Seq_Formacao);
            
            AreaEstudoManagement AreaEstudoManagement = new AreaEstudoManagementImpl();
            ArrayList<AreaEstudo> ListaArea = new ArrayList();
            ListaArea = AreaEstudoManagement.listar();

            if (FormAcad != null) {
                jsp = "EditarFormacaoAcademica.jsp";
                request.setAttribute("FormacaoAcademica", FormAcad);
                request.setAttribute("ListaArea", ListaArea);
            } 
            
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;    
    }
    
}
