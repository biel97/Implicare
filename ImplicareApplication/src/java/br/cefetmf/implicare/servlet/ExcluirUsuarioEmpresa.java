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

class ExcluirUsuarioEmpresa {

    static String execute(HttpServletRequest request) {
        String jsp = "";
        try {

            Long CNPJ = (Long) request.getSession().getAttribute("CPF_CNPJ");

            EmpresaManagement EmpresaManagement = new EmpresaManagementImpl();
            Empresa Empr = new Empresa();
            Empr = EmpresaManagement.pesquisar(CNPJ);
            
            boolean Empresa = EmpresaManagement.delete(Empr);

            if (Empresa =! false) {
                jsp = "index.jsp";
                request.setAttribute("Empresa", Empr);
            } else {
                String Erro = "Erro ao Excluir Empresa";
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
