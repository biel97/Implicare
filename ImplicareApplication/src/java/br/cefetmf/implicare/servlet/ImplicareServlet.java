/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmf.implicare.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gabriel
 * 
 */

public class ImplicareServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        request.setCharacterEncoding("UTF-8");

        String jsp = null;
        String acao = request.getParameter("acao");

        switch (acao) {
            case "AlterarCandidatoVaga":
                jsp = AlterarCandidatoVaga.execute(request);
                break;
            case "AlterarExperienciaProfissional":
                jsp = AlterarExperienciaProfissional.execute(request);
                break;
            case "AlterarFormacaoAcademica":
                jsp = AlterarFormacaoAcademica.execute(request);
                break;
            case "AlterarTelefone":
                jsp = AlterarTelefone.execute(request);
                break;
            case "AlterarUsuarioCandidato":
                jsp = AlterarUsuarioCandidato.execute(request);
                break;
            case "AlterarUsuarioEmpresa":
                jsp = AlterarUsuarioEmpresa.execute(request);
                break;
            case "AlterarVaga":
                jsp = AlterarVaga.execute(request);
                break;
            case "ExcluirCargoInteresse":
                jsp = ExcluirCargoInteresse.execute(request);
                break;
            case "ExcluirExperienciaProfissional":
                jsp = ExcluirExperienciaProfissional.execute(request);
                break;
            case "ExcluirFormacaoAcademica":
                jsp = ExcluirFormacaoAcademica.execute(request);
                break;
            case "ExcluirTelefone":
                jsp = ExcluirTelefone.execute(request);
                break;
            case "ExcluirUsuarioCandidato":
                jsp = ExcluirUsuarioCandidato.execute(request);
                break;
            case "ExcluirUsuarioEmpresa":
                jsp = ExcluirUsuarioEmpresa.execute(request);
                break;
            case "ExcluirVaga":
                jsp = ExcluirVaga.execute(request);
                break;
            case "InserirCargoInteresse":
                jsp = InserirCargoInteresse.execute(request);
                break;
            case "InserirExperienciaProfissional":
                jsp = InserirExperienciaProfissional.execute(request);
                break;
            case "InserirFormacaoAcademica":
                jsp = InserirFormacaoAcademica.execute(request);
                break;
            case "InserirTelefone":
                jsp = InserirTelefone.execute(request);
                break;
            case "InserirUsuarioCandidato":
                jsp = InserirUsuarioCandidato.execute(request);
                break;
            case "InserirUsuarioEmpresa":
                jsp = InserirUsuarioEmpresa.execute(request);
                break;
            case "InserirVaga":
                jsp = InserirVaga.execute(request);
                break;
            case "ListarAreaEstudo":
                jsp = ListarAreaEstudo.execute(request);
                break;
            case "ListarCandidatoVaga":
                jsp = ListarCandidatoVaga.execute(request);
                break;
            case "ListarCandidatoVagaAceito":
                jsp = ListarCandidatoVagaAceito.execute(request);
                break;
            case "ListarCargo":
                jsp = ListarCargo.execute(request);
                break;
            case "ListarVagaCandidato":
                jsp = ListarVagaCandidato.execute(request);
                break;
            case "ListarVagaEmpresa":
                jsp = ListarVagaEmpresa.execute(request);
                break;
            case "Login":
                jsp = Login.execute(request);
                break;
            case "PerfilCandidato":
                jsp = PerfilCandidato.execute(request);
                break;
            case "PerfilEmpresa":
                jsp = PerfilEmpresa.execute(request);
                break;
            case "PesquisarUsuarioCandidato":
                jsp = PesquisarUsuarioCandidato.execute(request);
                break;
            case "PesquisarUsuarioEmpresa":
                jsp = PesquisarUsuarioEmpresa.execute(request);
                break;
            case "PesquisarExperienciaProfissional":
                jsp = PesquisarExperienciaProfissional.execute(request);
                break;
            case "PesquisarFormacaoAcademica":
                jsp = PesquisarFormacaoAcademica.execute(request);
                break;
            case "PesquisarTelefone":
                jsp = PesquisarTelefone.execute(request);
                break;
            case "PesquisarVaga":
                jsp = PesquisarVaga.execute(request);
                break;
            default:
                jsp = "/WEB-Pages/Erro.jsp";
                request.setAttribute("Erro", "A solicitação feita ao servlet é inválida.");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(jsp);
        dispatcher.forward(request, response);
    }
    
}


