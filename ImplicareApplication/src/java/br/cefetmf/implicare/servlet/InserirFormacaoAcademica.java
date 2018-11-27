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

class InserirFormacaoAcademica {

    static String execute(HttpServletRequest request) {
        String jsp = "";
        try {

            Long CPF = (Long) request.getSession().getAttribute("CPF_CNPJ");
            String Instituicao_Ensino = request.getParameter("Instituicao_Ensino");
            int Cod_Area_Estudo = Integer.parseInt(request.getParameter("Cod_Area_Estudo"));
            String Atividades_Desenvolvidas = request.getParameter("Atividades_Desenvolvidas");
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date Dat_Inicio = (Date) formato.parse(request.getParameter("Dat_Inicio"));
            Date Dat_Termino = (Date) formato.parse(request.getParameter("Dat_Termino"));
            String Desc_Formacao_Academica = request.getParameter("Desc_Formacao_Academica");

            FormacaoAcademicaManagement FormacaoManagement = new FormacaoAcademicaManagementImpl();
            FormacaoAcademica Form = new FormacaoAcademica();
            
            Form.setCPF(CPF);
            Form.setInstituicao_Ensino(Instituicao_Ensino);
            Form.setCod_Area_Estudo(Cod_Area_Estudo);
            Form.setAtividades_Desenvolvidas(Atividades_Desenvolvidas);
            Form.setData_Inicio(Dat_Inicio);
            Form.setData_Termino(Dat_Termino);
            Form.setDesc_Formacao_Academica(Desc_Formacao_Academica);
            
            boolean Formacao = FormacaoManagement.insert(Form);

            if (Formacao =! false) {
                jsp = "ImplicareServlet?acao=PerfilCandidato";
                request.setAttribute("FormacaoAcademica", Form);
            } else {
                String Erro = "Erro ao Inserir Formacao Academica";
                jsp = "/WEB-Pages/Erro.jsp";
                request.setAttribute("Erro", Erro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsp;
    }
    
}
