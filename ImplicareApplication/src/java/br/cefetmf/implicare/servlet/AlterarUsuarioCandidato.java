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

class AlterarUsuarioCandidato {

    static String execute(HttpServletRequest request) {
        String jsp = "";
        try {

            long CPF = (long) request.getSession().getAttribute("CPF_CNPJ");
            String Email = request.getParameter("Email");
            String Foto = request.getParameter("Foto");
            String Endereco = request.getParameter("Endereco");
            long Cod_CEP = Long.parseLong(request.getParameter("Cod_CEP"));
            String Desc_Usuario = request.getParameter("Desc_Usuario");
            String Nome = request.getParameter("Nome");
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date Data_Nascimento = (Date) formato.parse(request.getParameter("Data_Nascimento"));

            CandidatoManagement CandidatoManagement = new CandidatoManagementImpl();
            Candidato Cand = new Candidato();
            
            Cand.setCPF_CNPJ(CPF);
            Cand.setEmail(Email);
            Cand.setFoto(Foto);
            Cand.setEndereco(Endereco);
            Cand.setCod_CEP(Cod_CEP);
            Cand.setDesc_Usuario(Desc_Usuario);
            Cand.setNome(Nome);
            Cand.setData_Nascimento(Data_Nascimento);
            
            boolean Candidato = CandidatoManagement.update(Cand);

            if (Candidato =! false) {
                Cand = CandidatoManagement.pesquisar(CPF);

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
                }
                jsp = "/TelaPerfilCandidato.jsp";
            } else {
                String Erro = "Erro ao Editar Usuario Candidato";
                jsp = "/WEB-Pages/Erro.jsp";
                request.setAttribute("Erro", Erro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsp;
    }
    
}
