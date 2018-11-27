/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmf.implicare.servlet;

import br.cefetmg.implicare.model.domain.Cargo;
import br.cefetmg.implicare.model.domain.ExperienciaProfissional;
import br.cefetmg.implicare.model.service.CargoManagement;
import br.cefetmg.implicare.model.service.ExperienciaProfissionalManagement;
import br.cefetmg.implicare.model.serviceImpl.CargoManagementImpl;
import br.cefetmg.implicare.model.serviceImpl.ExperienciaProfissionalManagementImpl;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Gabriel
 * 
 */

class PesquisarExperienciaProfissional {

    static String execute(HttpServletRequest request) {
        String jsp = "";
        try {

            int Seq_Experiencia = Integer.parseInt(request.getParameter("Seq_Experiencia"));

            ExperienciaProfissionalManagement ExperienciaManagement = new ExperienciaProfissionalManagementImpl();
            ExperienciaProfissional ExpProf = new ExperienciaProfissional();
            ExpProf = ExperienciaManagement.pesquisar(Seq_Experiencia);
            
            CargoManagement CargoManagement = new CargoManagementImpl();
            ArrayList<Cargo> ListaCargo = new ArrayList();
            ListaCargo = CargoManagement.listar();

            if (ExpProf != null) {
                jsp = "EditarExperienciaProfissional.jsp";
                request.setAttribute("ExperienciaProfissional", ExpProf);
                request.setAttribute("ListaCargo", ListaCargo);
            } 
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsp;
    }
    
}
