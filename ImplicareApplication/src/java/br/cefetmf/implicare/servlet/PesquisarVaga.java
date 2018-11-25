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

class PesquisarVaga {

    static String execute(HttpServletRequest request) {
        String jsp = "";
        try {

            int Seq_Vaga = (int) request.getSession().getAttribute("Seq_Vaga");

            VagaManagement VagaManagement = new VagaManagementImpl();
            Vaga Vag = new Vaga();
            Vag = VagaManagement.pesquisar(Seq_Vaga);
            
            CargoManagement CargoManagement = new CargoManagementImpl();
            ArrayList<Cargo> ListaCargo = new ArrayList();
            ListaCargo = CargoManagement.listar();

            if (Vag != null) {
                jsp = "EditarVaga.jsp";
                request.setAttribute("Vaga", Vag);
                request.setAttribute("ListaCargo", ListaCargo);
            } 
            
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
    
}
