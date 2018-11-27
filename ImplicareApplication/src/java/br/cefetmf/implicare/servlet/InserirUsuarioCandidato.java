/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmf.implicare.servlet;

import br.cefetmg.implicare.model.domain.Candidato;
import br.cefetmg.implicare.model.service.CandidatoManagement;
import br.cefetmg.implicare.model.serviceImpl.CandidatoManagementImpl;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Gabriel
 * 
 */

class InserirUsuarioCandidato {

    static String execute(HttpServletRequest request) {
        String jsp = "";
        try {

<<<<<<< HEAD
            String CPF = request.getParameter("CPF_CNPJ");
=======
            Long CPF = Long.parseLong(request.getParameter("CPF_CNPJ"));
>>>>>>> e17be5e0a0ca6eb5a5cddaa1428fe4efeea894e9
            String Email = request.getParameter("Email");
            String Senha = request.getParameter("Senha");
            String Foto = request.getParameter("Foto");
            String Endereco = request.getParameter("Endereco");
            Long Cod_CEP = Long.parseLong(request.getParameter("Cod_CEP"));
            String Desc_Usuario = request.getParameter("Desc_Usuario");
            String Nome = request.getParameter("Nome");
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date Data_Nascimento = (Date) formato.parse(request.getParameter("Data_Nascimento"));

            CandidatoManagement CandidatoManagement = new CandidatoManagementImpl();
            Candidato Cand = new Candidato();
            
            Cand.setCPF_CNPJ(CPF);
            Cand.setSenha(Senha);
            Cand.setEmail(Email);
            Cand.setFoto(Foto);
            Cand.setEndereco(Endereco);
            Cand.setCod_CEP(Cod_CEP);
            Cand.setDesc_Usuario(Desc_Usuario);
            Cand.setNome(Nome);
            Cand.setData_Nascimento(Data_Nascimento);
            
            boolean Candidato = CandidatoManagement.insert(Cand);

            if (Candidato =! false) {
                jsp = "ImplicareServlet?acao=PerfilCandidato";
                request.setAttribute("FormacaoAcademica", Cand);
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
