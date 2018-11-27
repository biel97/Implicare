/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmf.implicare.servlet;

import br.cefetmg.implicare.model.domain.Vaga;
import br.cefetmg.implicare.model.service.VagaManagement;
import br.cefetmg.implicare.model.serviceImpl.VagaManagementImpl;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Gabriel
 * 
 */

class ExcluirVaga {

    static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            
            int Seq_Vaga = Integer.parseInt(request.getParameter("Seq_Vaga"));
            
            VagaManagement VagaManagement = new VagaManagementImpl();
            Vaga Vag = new Vaga();
            Vag = VagaManagement.pesquisar(Seq_Vaga);
            
            boolean Vaga = VagaManagement.delete(Vag);

            if (Vaga =! false) {
                jsp = "ImplicareServlet?acao=ListarVagaEmpresa";
                request.setAttribute("Vaga", Vag);
            } else {
                String Erro = "Erro ao Excluir Vaga";
                jsp = "/WEB-Pages/Erro.jsp";
                request.setAttribute("Erro", Erro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsp;
    }
    
}
