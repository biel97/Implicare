/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmf.implicare.servlet;

import br.cefetmg.implicare.model.domain.Empresa;
import br.cefetmg.implicare.model.service.EmpresaManagement;
import br.cefetmg.implicare.model.serviceImpl.EmpresaManagementImpl;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Gabriel
 * 
 */

class AlterarUsuarioEmpresa {

    static String execute(HttpServletRequest request) {
        String jsp = "";
        try {

            Long CPF = (Long) request.getSession().getAttribute("CPF_CNPJ");
            String Email = request.getParameter("Email");
            String Foto = request.getParameter("Foto");
            String Endereco = request.getParameter("Endereco");
            Long Cod_CEP = Long.parseLong(request.getParameter("Cod_CEP"));
            String Desc_Usuario = request.getParameter("Desc_Usuario");
            String Nome_Fantasia = request.getParameter("Nome_Fantasia");
            String Nom_Razao_Social = request.getParameter("Nom_Razao_Social");

            EmpresaManagement EmpresaManagement = new EmpresaManagementImpl();
            Empresa Empr = new Empresa();
            
            Empr.setCPF_CNPJ(CPF);
            Empr.setEmail(Email);
            Empr.setFoto(Foto);
            Empr.setEndereco(Endereco);
            Empr.setCod_CEP(Cod_CEP);
            Empr.setDesc_Usuario(Desc_Usuario);
            Empr.setNome_Fantasia(Nome_Fantasia);
            Empr.setNom_Razao_Social(Nom_Razao_Social);
            
            boolean Empresa = EmpresaManagement.update(Empr);

            if (Empresa =! false) {
                jsp = "";
                request.setAttribute("FormacaoAcademica", Empr);
            } else {
                String Erro = "Erro ao Editar Formacao Academica";
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
