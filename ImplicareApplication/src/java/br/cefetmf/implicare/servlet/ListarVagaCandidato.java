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

class ListarVagaCandidato {

    static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            
            Long CPF = (Long) request.getSession().getAttribute("CPF_CNPJ");
            
            VagaManagement VagaManagement = new VagaManagementImpl();
            ArrayList<Vaga> ListaVaga = new ArrayList();
            ListaVaga = VagaManagement.listarVagaCandidato(CPF);
            
            CargoManagement CargoManagement = new CargoManagementImpl();
            ArrayList<Cargo> ListaCargo = new ArrayList();
            ListaCargo = CargoManagement.listar();

            jsp = "/AvaliarVagas.jsp";
            request.setAttribute("ListaVaga", ListaVaga); 
            request.setAttribute("ListaCargo", ListaCargo); 
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsp;
    }
    
}
