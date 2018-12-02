/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmf.implicare.servlet;

import br.cefetmg.implicare.model.domain.Empresa;
import br.cefetmg.implicare.model.domain.Telefone;
import br.cefetmg.implicare.model.service.EmpresaManagement;
import br.cefetmg.implicare.model.service.TelefoneManagement;
import br.cefetmg.implicare.model.serviceImpl.EmpresaManagementImpl;
import br.cefetmg.implicare.model.serviceImpl.TelefoneManagementImpl;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Gabriel
 * 
 */

class PerfilEmpresa {

    static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            String Tipo = (String) request.getSession().getAttribute("Tipo");
            long CNPJ;
            if(Tipo == "E") {
                jsp = "/TelaPerfilEmpresa.jsp";
                CNPJ = (long) request.getSession().getAttribute("CPF_CNPJ");
            } else {
                jsp = "/VisualizarEmpresa.jsp";
                CNPJ = Long.parseLong(request.getParameter("CPF_CNPJ"));
            }

            EmpresaManagement EmpresaManagement = new EmpresaManagementImpl();
            Empresa Empr = new Empresa();
            Empr = EmpresaManagement.pesquisar(CNPJ);
            
            TelefoneManagement TelefoneManagement = new TelefoneManagementImpl();
            ArrayList<Telefone> ListaTelefone = new ArrayList();
            ListaTelefone = TelefoneManagement.listar(CNPJ);

            request.setAttribute("Empresa", Empr);
            request.setAttribute("ListaTelefone", ListaTelefone);
   
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsp;
    }
    
}
