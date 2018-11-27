/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmf.implicare.servlet;

import br.cefetmg.implicare.model.domain.Telefone;
import br.cefetmg.implicare.model.service.TelefoneManagement;
import br.cefetmg.implicare.model.serviceImpl.TelefoneManagementImpl;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Gabriel
 * 
 */

class InserirTelefone {

    static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            String Tipo = (String) request.getSession().getAttribute("Tipo");
            
            if(Tipo == "E") {
                jsp = "ImplicareServlet?acao=PerfilEmpresa";
            } else {
                jsp = "ImplicareServlet?acao=PerfilCandidato";
            }
            
            Long CPF_CNPJ = (Long) request.getSession().getAttribute("CPF_CNPJ");
            String Num_Telefone = request.getParameter("Num_Telefone");
            String Tipo_Telefone = request.getParameter("Tipo_Telefone");
            int DDD = Integer.parseInt(request.getParameter("DDD"));
            int Ramal = Integer.parseInt(request.getParameter("Ramal"));

            TelefoneManagement TelefoneManagement = new TelefoneManagementImpl();
            Telefone Tel = new Telefone();
            
            Tel.setCPF_CNPJ(CPF_CNPJ);
            Tel.setNum_Telefone(Num_Telefone);
            Tel.setTipo_Telefone(Tipo_Telefone);
            Tel.setDDD(DDD);
            Tel.setRamal(Ramal);
            
            boolean Telefone = TelefoneManagement.insert(Tel);

            if (Telefone =! false) {
                request.setAttribute("Telefone", Tel);
            } else {
                String Erro = "Erro ao Inserir Telefone";
                jsp = "/WEB-Pages/Erro.jsp";
                request.setAttribute("Erro", Erro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsp;
    }
    
}
