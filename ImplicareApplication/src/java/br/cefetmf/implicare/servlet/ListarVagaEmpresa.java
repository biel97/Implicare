/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmf.implicare.servlet;

import br.cefetmg.implicare.model.domain.Cargo;
import br.cefetmg.implicare.model.domain.Vaga;
import br.cefetmg.implicare.model.service.CargoManagement;
import br.cefetmg.implicare.model.service.VagaManagement;
import br.cefetmg.implicare.model.serviceImpl.CargoManagementImpl;
import br.cefetmg.implicare.model.serviceImpl.VagaManagementImpl;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Gabriel
 * 
 */

class ListarVagaEmpresa {

    static String execute(HttpServletRequest request) {
         String jsp = "";
        try {
            
            Long CNPJ = (Long) request.getSession().getAttribute("CNPJ");
            
            VagaManagement VagaManagement = new VagaManagementImpl();
            ArrayList<Vaga> ListaVaga = new ArrayList();
            ListaVaga = VagaManagement.listarVagaEmpresa(CNPJ);
            
            CargoManagement CargoManagement = new CargoManagementImpl();
            ArrayList<Cargo> ListaCargo = new ArrayList();
            ListaCargo = CargoManagement.listar();

            jsp = "/GerenciarVaga.jsp";
            request.setAttribute("ListaVaga", ListaVaga); 
            request.setAttribute("ListaCargo", ListaCargo); 
            
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
    
}
