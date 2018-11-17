/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmf.implicare.servlet;

import br.cefetmg.implicare.model.domain.Candidato;
import br.cefetmg.implicare.model.service.CandidatoManagement;
import br.cefetmg.implicare.model.serviceImpl.CandidatoManagementImpl;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Gabriel
 * 
 */

class PesquisarUsuarioCandidato {

    static String execute(HttpServletRequest request) {
        String jsp = "";
        try {

            Long CPF = (Long) request.getSession().getAttribute("CPF_CNPJ");

            CandidatoManagement CandidatoManagement = new CandidatoManagementImpl();
            Candidato Cand = new Candidato();
            Cand = CandidatoManagement.pesquisar(CPF);

            if (Cand != null) {
                jsp = "";
                request.setAttribute("Candidato", Cand);
            } else {
                String Erro = "Erro Candidato Não Existe";
                jsp = "/WEB-Pages/Erro.jsp";
                request.setAttribute("Erro", Erro);
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
    
}
