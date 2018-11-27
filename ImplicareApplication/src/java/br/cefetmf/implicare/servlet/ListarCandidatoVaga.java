/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmf.implicare.servlet;

import br.cefetmg.implicare.model.domain.AreaEstudo;
import br.cefetmg.implicare.model.domain.Candidato;
import br.cefetmg.implicare.model.domain.CandidatoVaga;
import br.cefetmg.implicare.model.domain.Cargo;
import br.cefetmg.implicare.model.domain.ExperienciaProfissional;
import br.cefetmg.implicare.model.domain.FormacaoAcademica;
import br.cefetmg.implicare.model.domain.Telefone;
import br.cefetmg.implicare.model.service.AreaEstudoManagement;
import br.cefetmg.implicare.model.service.CandidatoManagement;
import br.cefetmg.implicare.model.service.CandidatoVagaManagement;
import br.cefetmg.implicare.model.service.CargoManagement;
import br.cefetmg.implicare.model.service.ExperienciaProfissionalManagement;
import br.cefetmg.implicare.model.service.FormacaoAcademicaManagement;
import br.cefetmg.implicare.model.service.TelefoneManagement;
import br.cefetmg.implicare.model.serviceImpl.AreaEstudoManagementImpl;
import br.cefetmg.implicare.model.serviceImpl.CandidatoManagementImpl;
import br.cefetmg.implicare.model.serviceImpl.CandidatoVagaManagementImpl;
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

class ListarCandidatoVaga {

    static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            int Seq_Vaga = Integer.parseInt(request.getParameter("Seq_Vaga"));
            
            CandidatoVagaManagement CandidatoVagaManagement = new CandidatoVagaManagementImpl();
            ArrayList<CandidatoVaga> ListaCandidatoVaga = new ArrayList();
            ListaCandidatoVaga = CandidatoVagaManagement.listar(Seq_Vaga);
            
            CandidatoManagement CandidatoManagement = new CandidatoManagementImpl();
            ArrayList<Candidato> ListaCandidato = new ArrayList();
            
            FormacaoAcademicaManagement FormacaoAcademicaManagement = new FormacaoAcademicaManagementImpl();
            ArrayList<FormacaoAcademica> ListaFormAcad = new ArrayList();
            
            AreaEstudoManagement AreaEstudoManagement = new AreaEstudoManagementImpl();
            ArrayList<AreaEstudo> ListaArea = new ArrayList();
            ListaArea = AreaEstudoManagement.listar();
            
            ExperienciaProfissionalManagement ExperienciaProfissionalManagement = new ExperienciaProfissionalManagementImpl();
            ArrayList<ExperienciaProfissional> ListaExpProfissional = new ArrayList();
            
            CargoManagement CargoManagement = new CargoManagementImpl();
            ArrayList<Cargo> ListaCargo = new ArrayList();
            ListaCargo = CargoManagement.listar();
            
            TelefoneManagement TelefoneManagement = new TelefoneManagementImpl();
            ArrayList<Telefone> ListaTelefone  = new ArrayList();
            
            for(int i = 0; i < ListaCandidatoVaga.size(); i++) {
                Candidato Cand = new Candidato();
                Cand = CandidatoManagement.pesquisar(ListaCandidatoVaga.get(i).getCPF());
                ListaCandidato.add(Cand);
                FormacaoAcademica FormAcad = new FormacaoAcademica();
                ArrayList<FormacaoAcademica> Acad = new ArrayList();
                Acad = FormacaoAcademicaManagement.listar(ListaCandidatoVaga.get(i).getCPF());
                for(int j = 0; j < Acad.size(); j++) {
                    FormAcad = FormacaoAcademicaManagement.pesquisar(Acad.get(j).getSeq_Formacao());
                    ListaFormAcad.add(FormAcad);
                }
                ExperienciaProfissional ExpProf = new ExperienciaProfissional();
                ArrayList<ExperienciaProfissional> Exp = new ArrayList();
                Exp = ExperienciaProfissionalManagement.listar(ListaCandidatoVaga.get(i).getCPF());
                for(int j = 0; j < Exp.size(); j++) {
                    ExpProf = ExperienciaProfissionalManagement.pesquisar(Exp.get(j).getSeq_Experiencia());
                    ListaExpProfissional.add(ExpProf);
                }
                Telefone Tel = new Telefone();
                ArrayList<Telefone> Tel1 = new ArrayList();
                Tel1 = TelefoneManagement.listar(ListaCandidatoVaga.get(i).getCPF());
                for(int j = 0; j < Tel1.size(); j++) {
                    Tel = TelefoneManagement.pesquisar(Tel1.get(j).getSeq_Telefone());
                    ListaTelefone.add(Tel);
                }

            }

            jsp = "/ResponderCandidatos.jsp";
            request.setAttribute("ListaCandidatoVaga", ListaCandidatoVaga); 
            request.setAttribute("ListaCandidato", ListaCandidato); 
            request.setAttribute("ListaFormAcad", ListaFormAcad); 
            request.setAttribute("ListaArea", ListaArea); 
            request.setAttribute("ListaExpProfissional", ListaExpProfissional); 
            request.setAttribute("ListaCargo", ListaCargo); 
            request.setAttribute("ListaTelefone", ListaTelefone);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsp;
    }
    
}
