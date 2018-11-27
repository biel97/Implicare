/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmf.implicare.servlet;

import br.cefetmg.implicare.model.domain.Candidato;
import br.cefetmg.implicare.model.domain.CandidatoVaga;
import br.cefetmg.implicare.model.service.CandidatoManagement;
import br.cefetmg.implicare.model.service.CandidatoVagaManagement;
import br.cefetmg.implicare.model.serviceImpl.CandidatoManagementImpl;
import br.cefetmg.implicare.model.serviceImpl.CandidatoVagaManagementImpl;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Gabriel
 * 
 */

class ListarCandidatoVagaAceito {

    static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            int Seq_Vaga = Integer.parseInt(request.getParameter("Seq_Vaga"));
            
            CandidatoVagaManagement CandidatoVagaManagement = new CandidatoVagaManagementImpl();
            ArrayList<CandidatoVaga> ListaCandidatoVaga = new ArrayList();
            ListaCandidatoVaga = CandidatoVagaManagement.listar(Seq_Vaga);
            
            CandidatoManagement CandidatoManagement = new CandidatoManagementImpl();
            ArrayList<Candidato> ListaCandidato = new ArrayList();
            
            for(int i = 0; i < ListaCandidatoVaga.size(); i++) {
                Candidato Cand = new Candidato();
                Cand = CandidatoManagement.pesquisar(ListaCandidatoVaga.get(i).getCPF());
                ListaCandidato.add(Cand);
            }

            jsp = "/GerenciarCandidatos.jsp";
            request.setAttribute("ListaCandidatoVaga", ListaCandidatoVaga); 
            request.setAttribute("ListaCandidato", ListaCandidato); 
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsp;
    }
    
}
