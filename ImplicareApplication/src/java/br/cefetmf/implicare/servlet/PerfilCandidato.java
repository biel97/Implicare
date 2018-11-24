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
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Gabriel
 * 
 */

class PerfilCandidato {

    static String execute(HttpServletRequest request) {
        String jsp = "";
        try {

            Long CPF = (Long) request.getSession().getAttribute("CPF_CNPJ");

            CandidatoManagement CandidatoManagement = new CandidatoManagementImpl();
            Candidato Cand = new Candidato();
            Cand = CandidatoManagement.pesquisar(CPF);
            
            jsp = "TelaPerfilCandidato.jsp";
            
            if(Cand == null) {
                jsp = "";
                CPF = Long.parseLong(request.getParameter("CPF"));
                Cand = CandidatoManagement.pesquisar(CPF);
            }
            
            FormacaoAcademicaManagement ForAcadManagement = new FormacaoAcademicaManagementImpl();
            ArrayList<FormacaoAcademica> ListaFormAcad = new ArrayList();
            ListaFormAcad = ForAcadManagement.listar(CPF);
            
            AreaEstudoManagement AreaManagement = new AreaEstudoManagementImpl();
            ArrayList<AreaEstudo> ListaArea = new ArrayList();
            ListaArea = AreaManagement.listar();
            
            ExperienciaProfissionalManagement ExperienciaManagement = new ExperienciaProfissionalManagementImpl();
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
            } else {
                String Erro = "Erro Candidato Não Existe";
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
