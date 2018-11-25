/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmf.implicare.servlet;

import br.cefetmg.implicare.model.domain.ExperienciaProfissional;
import br.cefetmg.implicare.model.service.ExperienciaProfissionalManagement;
import br.cefetmg.implicare.model.serviceImpl.ExperienciaProfissionalManagementImpl;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Gabriel
 * 
 */

class ExcluirExperienciaProfissional {

    static String execute(HttpServletRequest request) {
        String jsp = "";
        try {

            int Seq_Experiencia = Integer.parseInt(request.getParameter("Seq_Experiencia"));
           

            ExperienciaProfissionalManagement ExperienciaManagement = new ExperienciaProfissionalManagementImpl();
            ExperienciaProfissional Exp = new ExperienciaProfissional();
            Exp = ExperienciaManagement.pesquisar(Seq_Experiencia);
            
            boolean Experiencia = ExperienciaManagement.delete(Exp);

            if (Experiencia =! false) {
                jsp = "ImplicareServlet?acao=PerfilCandidato";
                request.setAttribute("ExperienciaProfissional", Exp);
            } else {
                String Erro = "Erro ao Excluir Experiencia Profissional";
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
