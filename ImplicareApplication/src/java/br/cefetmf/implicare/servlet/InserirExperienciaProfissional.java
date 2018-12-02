/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmf.implicare.servlet;

import br.cefetmg.implicare.model.domain.AreaEstudo;
import br.cefetmg.implicare.model.domain.Candidato;
import br.cefetmg.implicare.model.domain.Cargo;
import br.cefetmg.implicare.model.domain.CargoInteresse;
import br.cefetmg.implicare.model.domain.ExperienciaProfissional;
import br.cefetmg.implicare.model.domain.FormacaoAcademica;
import br.cefetmg.implicare.model.domain.Telefone;
import br.cefetmg.implicare.model.service.AreaEstudoManagement;
import br.cefetmg.implicare.model.service.CandidatoManagement;
import br.cefetmg.implicare.model.service.CargoInteresseManagement;
import br.cefetmg.implicare.model.service.CargoManagement;
import br.cefetmg.implicare.model.service.ExperienciaProfissionalManagement;
import br.cefetmg.implicare.model.service.FormacaoAcademicaManagement;
import br.cefetmg.implicare.model.service.TelefoneManagement;
import br.cefetmg.implicare.model.serviceImpl.AreaEstudoManagementImpl;
import br.cefetmg.implicare.model.serviceImpl.CandidatoManagementImpl;
import br.cefetmg.implicare.model.serviceImpl.CargoInteresseManagementImpl;
import br.cefetmg.implicare.model.serviceImpl.CargoManagementImpl;
import br.cefetmg.implicare.model.serviceImpl.ExperienciaProfissionalManagementImpl;
import br.cefetmg.implicare.model.serviceImpl.FormacaoAcademicaManagementImpl;
import br.cefetmg.implicare.model.serviceImpl.TelefoneManagementImpl;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Gabriel
 * 
 */

class InserirExperienciaProfissional {

    static String execute(HttpServletRequest request) {
        String jsp = "";
        try {

            long CPF = (long) request.getSession().getAttribute("CPF_CNPJ");
            String Nom_Empresa = request.getParameter("Nom_Empresa");
            int Cod_Cargo = Integer.parseInt(request.getParameter("Cod_Cargo"));
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date Dat_Inicio = (Date) formato.parse(request.getParameter("Data_Inicio"));
            Date Data_Termino = (Date) formato.parse(request.getParameter("Data_Termino"));
            String Desc_Experiencia_Profissional = request.getParameter("Desc_Experiencia_Profissional");

            ExperienciaProfissionalManagement ExperienciaManagement = new ExperienciaProfissionalManagementImpl();
            ExperienciaProfissional Exp = new ExperienciaProfissional();
            
            Exp.setCPF(CPF);
            Exp.setNom_Empresa(Nom_Empresa);
            Exp.setCod_Cargo(Cod_Cargo);
            Exp.setData_Inicio(Dat_Inicio);
            Exp.setData_Termino(Data_Termino);
            Exp.setDesc_Experiencia_Profissional(Desc_Experiencia_Profissional);
            
            boolean Experiencia = ExperienciaManagement.insert(Exp);

            if (Experiencia =! false) {
                CandidatoManagement CandidatoManagement = new CandidatoManagementImpl();
                Candidato Cand = new Candidato();
                Cand = CandidatoManagement.pesquisar(CPF);

                FormacaoAcademicaManagement ForAcadManagement = new FormacaoAcademicaManagementImpl();
                ArrayList<FormacaoAcademica> ListaFormAcad = new ArrayList();
                ListaFormAcad = ForAcadManagement.listar(CPF);

                AreaEstudoManagement AreaManagement = new AreaEstudoManagementImpl();
                ArrayList<AreaEstudo> ListaArea = new ArrayList();
                ListaArea = AreaManagement.listar();

                ArrayList<ExperienciaProfissional> ListaExpProfissional = new ArrayList();
                ListaExpProfissional = ExperienciaManagement.listar(CPF);

                CargoManagement CargoManagement = new CargoManagementImpl();
                ArrayList<Cargo> ListaCargo = new ArrayList();
                ListaCargo = CargoManagement.listar();

                TelefoneManagement TelefoneManagement = new TelefoneManagementImpl();
                ArrayList<Telefone> ListaTelefone = new ArrayList();
                ListaTelefone = TelefoneManagement.listar(CPF);

                CargoInteresseManagement CargoInteresseManagement = new CargoInteresseManagementImpl();
                ArrayList<CargoInteresse> ListaCargoInt = new ArrayList();
                ListaCargoInt = CargoInteresseManagement.listar(CPF);

                ArrayList<Cargo> ListaCargoArea = new ArrayList();
                ListaCargoArea = CargoManagement.listarCargoAreaEstudo(CPF);

                if (Cand != null) {
                    request.setAttribute("Candidato", Cand);
                    request.setAttribute("ListaFormacaoAcademica", ListaFormAcad);
                    request.setAttribute("ListaAreaEstudo", ListaArea);
                    request.setAttribute("ListaExperienciaProfissional", ListaExpProfissional);
                    request.setAttribute("ListaCargo", ListaCargo);
                    request.setAttribute("ListaTelefone", ListaTelefone);
                    request.setAttribute("ListaCargoInteresse", ListaCargoInt);
                    request.setAttribute("ListaCargoAreaEstudo", ListaCargoArea);
                }
                jsp = "/TelaPerfilCandidato.jsp";
            } else {
                String Erro = "Erro ao Inserir Experiencia Profissional";
                jsp = "/WEB-Pages/Erro.jsp";
                request.setAttribute("Erro", Erro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsp;
    }
    
}
