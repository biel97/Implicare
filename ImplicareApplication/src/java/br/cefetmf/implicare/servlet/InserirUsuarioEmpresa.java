/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmf.implicare.servlet;

import br.cefetmg.implicare.model.domain.Empresa;
import br.cefetmg.implicare.model.domain.Telefone;
import br.cefetmg.implicare.model.service.EmpresaManagement;
import br.cefetmg.implicare.model.service.TelefoneManagement;
import br.cefetmg.implicare.model.serviceImpl.EmpresaManagementImpl;
import br.cefetmg.implicare.model.serviceImpl.TelefoneManagementImpl;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Gabriel
 * 
 */

class InserirUsuarioEmpresa {

    static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            jsp = "/TelaPerfilEmpresa.jsp";
            long CNPJ = (long) request.getSession().getAttribute("CPF_CNPJ");
            
            Long CPF = Long.parseLong(request.getParameter("CPF_CNPJ"));
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
            
            boolean Empresa = EmpresaManagement.insert(Empr);

            if (Empresa =! false) {
                Empr = EmpresaManagement.pesquisar(CNPJ);

                TelefoneManagement TelefoneManagement = new TelefoneManagementImpl();
                ArrayList<Telefone> ListaTelefone = new ArrayList();
                ListaTelefone = TelefoneManagement.listar(CNPJ);

                request.setAttribute("Empresa", Empr);
                request.setAttribute("ListaTelefone", ListaTelefone);
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
