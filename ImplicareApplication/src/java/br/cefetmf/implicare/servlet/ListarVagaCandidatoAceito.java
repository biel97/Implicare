/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmf.implicare.servlet;

import br.cefetmg.implicare.model.domain.Cargo;
import br.cefetmg.implicare.model.domain.Empresa;
import br.cefetmg.implicare.model.domain.Telefone;
import br.cefetmg.implicare.model.domain.Vaga;
import br.cefetmg.implicare.model.service.CargoManagement;
import br.cefetmg.implicare.model.service.EmpresaManagement;
import br.cefetmg.implicare.model.service.TelefoneManagement;
import br.cefetmg.implicare.model.service.VagaManagement;
import br.cefetmg.implicare.model.serviceImpl.CargoManagementImpl;
import br.cefetmg.implicare.model.serviceImpl.EmpresaManagementImpl;
import br.cefetmg.implicare.model.serviceImpl.TelefoneManagementImpl;
import br.cefetmg.implicare.model.serviceImpl.VagaManagementImpl;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Gabriel
 * 
 */

class ListarVagaCandidatoAceito {

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
            
            EmpresaManagement EmpresaManagement = new EmpresaManagementImpl();
            ArrayList<Empresa> ListaEmpresa = new ArrayList();
            
            for(int i = 0; i < ListaVaga.size(); i++) {
                Empresa Empr = new Empresa();
                Empr = EmpresaManagement.pesquisar(ListaVaga.get(i).getCNPJ());
                ListaEmpresa.add(Empr);
            }
            
            jsp = "/RespostaVaga.jsp";
            request.setAttribute("ListaVaga", ListaVaga); 
            request.setAttribute("ListaCargo", ListaCargo); 
            request.setAttribute("ListaEmpresa", ListaEmpresa); 
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsp;
    }
    
}
