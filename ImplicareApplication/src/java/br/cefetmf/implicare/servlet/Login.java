/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmf.implicare.servlet;

import br.cefetmg.implicare.model.domain.Candidato;
import br.cefetmg.implicare.model.domain.Cargo;
import br.cefetmg.implicare.model.domain.Empresa;
import br.cefetmg.implicare.model.domain.Telefone;
import br.cefetmg.implicare.model.domain.Usuario;
import br.cefetmg.implicare.model.domain.Vaga;
import br.cefetmg.implicare.model.service.CandidatoManagement;
import br.cefetmg.implicare.model.service.CargoManagement;
import br.cefetmg.implicare.model.service.EmpresaManagement;
import br.cefetmg.implicare.model.service.TelefoneManagement;
import br.cefetmg.implicare.model.service.UsuarioManagement;
import br.cefetmg.implicare.model.service.VagaManagement;
import br.cefetmg.implicare.model.serviceImpl.CandidatoManagementImpl;
import br.cefetmg.implicare.model.serviceImpl.CargoManagementImpl;
import br.cefetmg.implicare.model.serviceImpl.EmpresaManagementImpl;
import br.cefetmg.implicare.model.serviceImpl.TelefoneManagementImpl;
import br.cefetmg.implicare.model.serviceImpl.UsuarioManagementImpl;
import br.cefetmg.implicare.model.serviceImpl.VagaManagementImpl;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Gabriel
 * 
 */

class Login {

    static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            long CPF_CNPJ = Long.parseLong(request.getParameter("CPF_CNPJ"));
            String Senha = request.getParameter("Senha");

            UsuarioManagement UsuarioManagement = new UsuarioManagementImpl();
            Usuario user = new Usuario();
            user = UsuarioManagement.login(CPF_CNPJ, Senha);
            
            if(user == null) {
                return "/login.jsp";
            }
            
            
            if (CPF_CNPJ == 0 || Senha.isEmpty()) {
                jsp = "/login.jsp";
            } 
            else {
                
                HttpSession session = request.getSession();
                CandidatoManagement CandidatoManagement = new CandidatoManagementImpl();
                Candidato Cand = new Candidato();
                Cand = CandidatoManagement.pesquisar(CPF_CNPJ);
                if(Cand == null) {
                    request.getSession().setAttribute("Tipo","E");
                    VagaManagement VagaManagement = new VagaManagementImpl();
                    ArrayList<Vaga> ListaVaga = new ArrayList();
                    ListaVaga = VagaManagement.listarVagaEmpresa(CPF_CNPJ);

                    CargoManagement CargoManagement = new CargoManagementImpl();
                    ArrayList<Cargo> ListaCargo = new ArrayList();
                    ListaCargo = CargoManagement.listar();

                    jsp = "/GerenciarVaga.jsp";
                    request.setAttribute("ListaVaga", ListaVaga); 
                    request.setAttribute("ListaCargo", ListaCargo);
                } else {
                    request.getSession().setAttribute("Tipo","C");
                    VagaManagement VagaManagement = new VagaManagementImpl();
                    ArrayList<Vaga> ListaVaga = new ArrayList();
                    ListaVaga = VagaManagement.listarVagaCandidato(CPF_CNPJ);

                    CargoManagement CargoManagement = new CargoManagementImpl();
                    ArrayList<Cargo> ListaCargo = new ArrayList();
                    ListaCargo = CargoManagement.listar();

                    EmpresaManagement EmpresaManagement = new EmpresaManagementImpl();
                    ArrayList<Empresa> ListaEmpresa = new ArrayList();

                    TelefoneManagement TelefoneManagement = new TelefoneManagementImpl();
                    ArrayList<Telefone> ListaTelefone = new ArrayList();
                    if(ListaVaga != null) {
                        for(int i = 0; i < ListaVaga.size(); i++) {
                            Empresa Empr = new Empresa();
                            Empr = EmpresaManagement.pesquisar(ListaVaga.get(i).getCNPJ());
                            ListaEmpresa.add(Empr);

                            Telefone Tel = new Telefone();
                            ArrayList<Telefone> tel1 = new ArrayList();
                            tel1 = TelefoneManagement.listar(ListaVaga.get(i).getCNPJ());

                            for(int j = 0; j < tel1.size(); j++){
                                Tel = TelefoneManagement.pesquisar(tel1.get(i).getSeq_Telefone());
                                ListaTelefone.add(Tel);
                            }
                        }
                    }
                    jsp = "/AvaliarVagas.jsp";
                    request.setAttribute("ListaVaga", ListaVaga); 
                    request.setAttribute("ListaCargo", ListaCargo); 
                    request.setAttribute("ListaEmpresa", ListaEmpresa); 
                    request.setAttribute("ListaTelefone", ListaTelefone);
                }
                request.getSession().setAttribute("CPF_CNPJ",user.getCPF_CNPJ());
                request.getSession().setAttribute("Email", user.getEmail());
                request.getSession().setAttribute("Foto",user.getFoto());
                request.getSession().setAttribute("Endereço", user.getEndereco());
                request.getSession().setAttribute("Cod_CEP",user.getCod_CEP());
                request.getSession().setAttribute("Desc_Usuario", user.getDesc_Usuario());
                
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsp;
    }
    
    public static void validarSessao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        Long CPF_CNPJ = (Long) request.getSession().getAttribute("CPF_CNPJ");
        System.out.println(request.getSession().getAttribute("CPF_CNPJ"));
        String jsp = "";
        if (CPF_CNPJ == null) {
            jsp = "/index.jsp";
            RequestDispatcher rd = request.getRequestDispatcher(jsp);
            rd.forward(request, response);
        }
    }
   
}
