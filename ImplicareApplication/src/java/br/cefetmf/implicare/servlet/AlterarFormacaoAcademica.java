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

class AlterarFormacaoAcademica {

    static String execute(HttpServletRequest request) {
        String jsp = "";
        try {

            long CPF = (long) request.getSession().getAttribute("CPF_CNPJ");
            int Seq_Formacao = Integer.parseInt(request.getParameter("Seq_Formacao"));
            String Instituicao_Ensino = request.getParameter("Instituicao_Ensino");
            int Cod_Area_Estudo = Integer.parseInt(request.getParameter("Cod_Area_Estudo"));
            String Atividades_Desenvolvidas = request.getParameter("Atividades_Desenvolvidas");
            SimpleDateFormat formato = new SimpleDateFormat("YYYY-MM-dd");
            java.util.Date Data_Inicio = formato.parse(request.getParameter("Dat_Inicio"));
            java.sql.Date Dat_Inicio = convertUtilToSql(Data_Inicio);
            java.util.Date Data_Termino = formato.parse(request.getParameter("Dat_Termino"));
            java.sql.Date Dat_Termino = convertUtilToSql(Data_Termino);            
            String Desc_Formacao_Academica = request.getParameter("Desc_Formacao_Academica");

            FormacaoAcademicaManagement FormacaoManagement = new FormacaoAcademicaManagementImpl();
            FormacaoAcademica Form = new FormacaoAcademica();
            
            Form.setCPF(CPF);
            Form.setSeq_Formacao(Seq_Formacao);
            Form.setInstituicao_Ensino(Instituicao_Ensino);
            Form.setCod_Area_Estudo(Cod_Area_Estudo);
            Form.setAtividades_Desenvolvidas(Atividades_Desenvolvidas);
            Form.setData_Inicio(Dat_Inicio);
            Form.setData_Termino(Dat_Termino);
            Form.setDesc_Formacao_Academica(Desc_Formacao_Academica);
            
            boolean Formacao = FormacaoManagement.update(Form);

            if (Formacao =! false) {
                CandidatoManagement CandidatoManagement = new CandidatoManagementImpl();
                Candidato Cand = new Candidato();
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
                String Erro = "Erro ao Editar Formacao Academica";
                jsp = "/WEB-Pages/Erro.jsp";
                request.setAttribute("Erro", Erro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsp;
    }

    private static Date convertUtilToSql(java.util.Date Data_Inicio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
