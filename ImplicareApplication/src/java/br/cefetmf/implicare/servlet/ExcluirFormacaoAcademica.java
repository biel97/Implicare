/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmf.implicare.servlet;

import br.cefetmg.implicare.model.domain.FormacaoAcademica;
import br.cefetmg.implicare.model.service.FormacaoAcademicaManagement;
import br.cefetmg.implicare.model.serviceImpl.FormacaoAcademicaManagementImpl;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Gabriel
 * 
 */

class ExcluirFormacaoAcademica {

    static String execute(HttpServletRequest request) {
        String jsp = "";
        try {

            int Seq_Formacao = Integer.parseInt(request.getParameter("Seq_Formacao"));

            FormacaoAcademicaManagement FormacaoManagement = new FormacaoAcademicaManagementImpl();
            FormacaoAcademica Form = new FormacaoAcademica();
            Form = FormacaoManagement.pesquisar(Seq_Formacao);
            
            boolean Formacao = FormacaoManagement.delete(Form);

            if (Formacao =! false) {
                jsp = "ImplicareServlet?acao=PerfilCandidato";
                request.setAttribute("FormacaoAcademica", Form);
            } else {
                String Erro = "Erro ao Excluir Formacao Academica";
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
