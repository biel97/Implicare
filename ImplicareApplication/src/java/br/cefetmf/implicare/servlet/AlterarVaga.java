/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmf.implicare.servlet;

import br.cefetmg.implicare.model.domain.Cargo;
import br.cefetmg.implicare.model.domain.Vaga;
import br.cefetmg.implicare.model.service.CargoManagement;
import br.cefetmg.implicare.model.service.VagaManagement;
import br.cefetmg.implicare.model.serviceImpl.CargoManagementImpl;
import br.cefetmg.implicare.model.serviceImpl.VagaManagementImpl;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Gabriel
 * 
 */

class AlterarVaga {

    static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            
            int Seq_Vaga = Integer.parseInt(request.getParameter("Seq_Vaga"));
            long CNPJ = (long) request.getSession().getAttribute("CPF_CNPJ");
            int Cod_Cargo = Integer.parseInt(request.getParameter("Cod_Cargo"));
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date Dat_Publicacao = (Date) formato.parse(request.getParameter("Dat_Publicacao"));
            int Num_Vagas = Integer.parseInt(request.getParameter("Num_Vagas"));
            int Carga_Horaria = Integer.parseInt(request.getParameter("Carga_Horaria"));
            double Remuneracao = Double.parseDouble(request.getParameter("Remuneracao"));
            String Desc_Vaga = request.getParameter("Desc_Vaga");
            int Status_Vaga = Integer.parseInt(request.getParameter("Status_Vaga"));
            
            VagaManagement VagaManagement = new VagaManagementImpl();
            Vaga Vag = new Vaga();
            
            Vag.setSeq_Vaga(Seq_Vaga);
            Vag.setCNPJ(CNPJ);
            Vag.setCod_Cargo(Cod_Cargo);
            Vag.setDat_Publicacao(Dat_Publicacao);
            Vag.setNum_Vagas(Num_Vagas);
            Vag.setCarga_Horaria(Carga_Horaria);
            Vag.setRemuneracao(Remuneracao);
            Vag.setDesc_Vaga(Desc_Vaga);
            Vag.setStatus_Vaga(Status_Vaga);
            
            boolean Vaga = VagaManagement.update(Vag);

            if (Vaga =! false) {
                ArrayList<Vaga> ListaVaga = new ArrayList();
                ListaVaga = VagaManagement.listarVagaEmpresa(CNPJ);

                CargoManagement CargoManagement = new CargoManagementImpl();
                ArrayList<Cargo> ListaCargo = new ArrayList();
                ListaCargo = CargoManagement.listar();

                jsp = "/GerenciarVaga.jsp";
                request.setAttribute("ListaVaga", ListaVaga); 
                request.setAttribute("ListaCargo", ListaCargo);
            } else {
                String Erro = "Erro ao Editar Vaga";
                jsp = "/WEB-Pages/Erro.jsp";
                request.setAttribute("Erro", Erro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsp;
    }
    
}
