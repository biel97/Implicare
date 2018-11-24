/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmf.implicare.servlet;

import br.cefetmg.implicare.model.domain.AreaEstudo;
import br.cefetmg.implicare.model.service.AreaEstudoManagement;
import br.cefetmg.implicare.model.serviceImpl.AreaEstudoManagementImpl;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Gabriel
 * 
 */

class ListarAreaEstudo {

    static String execute(HttpServletRequest request) {
        String jsp = "";
        try {

            AreaEstudoManagement AreaEstudoManagement = new AreaEstudoManagementImpl();
            ArrayList<AreaEstudo> ListaArea = new ArrayList();
            ListaArea = AreaEstudoManagement.listar();

            jsp = "/formFormacaoAcademica.jsp";
            request.setAttribute("ListaArea", ListaArea); 
            
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
    
}
