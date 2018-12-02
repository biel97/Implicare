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
import br.cefetmg.implicare.model.domain.Empresa;
import br.cefetmg.implicare.model.domain.ExperienciaProfissional;
import br.cefetmg.implicare.model.domain.FormacaoAcademica;
import br.cefetmg.implicare.model.domain.Telefone;
import br.cefetmg.implicare.model.service.AreaEstudoManagement;
import br.cefetmg.implicare.model.service.CandidatoManagement;
import br.cefetmg.implicare.model.service.CargoInteresseManagement;
import br.cefetmg.implicare.model.service.CargoManagement;
import br.cefetmg.implicare.model.service.EmpresaManagement;
import br.cefetmg.implicare.model.service.ExperienciaProfissionalManagement;
import br.cefetmg.implicare.model.service.FormacaoAcademicaManagement;
import br.cefetmg.implicare.model.service.TelefoneManagement;
import br.cefetmg.implicare.model.serviceImpl.AreaEstudoManagementImpl;
import br.cefetmg.implicare.model.serviceImpl.CandidatoManagementImpl;
import br.cefetmg.implicare.model.serviceImpl.CargoInteresseManagementImpl;
import br.cefetmg.implicare.model.serviceImpl.CargoManagementImpl;
import br.cefetmg.implicare.model.serviceImpl.EmpresaManagementImpl;
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

class InserirTelefone {

    static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            String Tipo = (String) request.getSession().getAttribute("Tipo");
            
            long CPF_CNPJ = (long) request.getSession().getAttribute("CPF_CNPJ");
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
               if(Tipo == "E") {
                    EmpresaManagement EmpresaManagement = new EmpresaManagementImpl();
                    Empresa Empr = new Empresa();
                    Empr = EmpresaManagement.pesquisar(CPF_CNPJ);

                    ArrayList<Telefone> ListaTelefone = new ArrayList();
                    ListaTelefone = TelefoneManagement.listar(CPF_CNPJ);

                    request.setAttribute("Empresa", Empr);
                    request.setAttribute("ListaTelefone", ListaTelefone);
                    jsp = "/TelaPerfilEmpresa.jsp";
                } else {
                    CandidatoManagement CandidatoManagement = new CandidatoManagementImpl();
                    Candidato Cand = new Candidato();
                    Cand = CandidatoManagement.pesquisar(CPF_CNPJ);

                    FormacaoAcademicaManagement ForAcadManagement = new FormacaoAcademicaManagementImpl();
                    ArrayList<FormacaoAcademica> ListaFormAcad = new ArrayList();
                    ListaFormAcad = ForAcadManagement.listar(CPF_CNPJ);

                    AreaEstudoManagement AreaManagement = new AreaEstudoManagementImpl();
                    ArrayList<AreaEstudo> ListaArea = new ArrayList();
                    ListaArea = AreaManagement.listar();

                    ExperienciaProfissionalManagement ExperienciaManagement = new ExperienciaProfissionalManagementImpl();
                    ArrayList<ExperienciaProfissional> ListaExpProfissional = new ArrayList();
                    ListaExpProfissional = ExperienciaManagement.listar(CPF_CNPJ);

                    CargoManagement CargoManagement = new CargoManagementImpl();
                    ArrayList<Cargo> ListaCargo = new ArrayList();
                    ListaCargo = CargoManagement.listar();

                    ArrayList<Telefone> ListaTelefone = new ArrayList();
                    ListaTelefone = TelefoneManagement.listar(CPF_CNPJ);

                    CargoInteresseManagement CargoInteresseManagement = new CargoInteresseManagementImpl();
                    ArrayList<CargoInteresse> ListaCargoInt = new ArrayList();
                    ListaCargoInt = CargoInteresseManagement.listar(CPF_CNPJ);

                    ArrayList<Cargo> ListaCargoArea = new ArrayList();
                    ListaCargoArea = CargoManagement.listarCargoAreaEstudo(CPF_CNPJ);

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
                }
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
