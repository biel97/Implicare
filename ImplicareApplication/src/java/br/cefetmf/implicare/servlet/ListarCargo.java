/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmf.implicare.servlet;

import br.cefetmg.implicare.model.domain.Cargo;
import br.cefetmg.implicare.model.service.CargoManagement;
import br.cefetmg.implicare.model.serviceImpl.CargoManagementImpl;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Gabriel
 * 
 */

class ListarCargo {

    static String execute(HttpServletRequest request) {
        String jsp = "";
        try {

            CargoManagement CargoManagement = new CargoManagementImpl();
            ArrayList<Cargo> ListaCargo = new ArrayList();
            ListaCargo = CargoManagement.listar();

            jsp = "/formVaga.jsp";
            request.setAttribute("ListaCargo", ListaCargo); 
            
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }

}
