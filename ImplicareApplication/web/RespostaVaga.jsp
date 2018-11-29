<%-- 
    Document   : GerenciarVaga
    Created on : 26/11/2018, 04:00:00
    Author     : Gabriel
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.cefetmg.implicare.model.domain.Cargo"%>
<%@page import="br.cefetmg.implicare.model.domain.Vaga"%>
<%@page import="br.cefetmg.implicare.model.domain.Empresa"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gerenciar Vaga</title>
        <link href="css\bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css\bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>
        <link href="css\bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css\bootstrap-theme.css" rel="stylesheet" type="text/css"/>
        <link href="css\style.css" rel="stylesheet" type="text/css"/>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <script type="text/javascript" src="js/scripts.js"></script>
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
    </head>
    <body id="gerenciar-vaga">
        <%@include file="headerCandidato.jspf" %>   
            <%ArrayList<Empresa> ListaEmpresa = (ArrayList<Empresa>)request.getAttribute("ListaEmpresa");
            ArrayList<Vaga> ListaVaga = (ArrayList<Vaga>)request.getAttribute("ListaVaga");
            ArrayList<Cargo> ListaCargo = (ArrayList<Cargo>)request.getAttribute("ListaCargo");%>
            <%for(int i = 0; i < ListaVaga.size(); i++) { 
                int x = 0;
                for(;x < ListaEmpresa.size(); x++){
                    if(ListaVaga.get(i).getCNPJ() == ListaEmpresa.get(x).getCPF_CNPJ()){
                        break;
                    }
                }
                if(i%2 == 0){%>
                    <div class="row">
                <%}%>
                    <div class="col-md-6">
                        <div class="panel panel-primary1">
                            <div class="panel-heading">
                                
                                <%for(int j = 0; j < ListaCargo.size(); j++) {
                                    if(ListaVaga.get(i).getCod_Cargo() == ListaCargo.get(j).getCod_Cargo()){%>
                                        <h3 class="panel-title"><%=ListaCargo.get(j).getNom_Cargo()%> - <%=ListaEmpresa.get(x).getNome_Fantasia()%></h3>
                                <%  } 
                                } %>
                                
                                <span class="pull-right clickable"><i class="glyphicon glyphicon-chevron-up"></i></span>
                            </div>
                            <div class="panel-body">
                                <table class="col-md-12 col-lg-9 tabelinha">
                                    <tbody>
                                        <tr>
                                            <td>Data Publicação</td>
                                            <td><%=ListaVaga.get(i).getDat_Publicacao()%></td>
                                        </tr>
                                        <tr>
                                            <td>Número de Vagas</td>
                                            <td><%=ListaVaga.get(i).getNum_Vagas()%></td>
                                        </tr>
                                        <tr>
                                            <td>Carga Horária</td>
                                            <td><%=ListaVaga.get(i).getCarga_Horaria()%></td>
                                        </tr>
                                        <tr>
                                            <td>Remuneração</td>
                                            <td><%=ListaVaga.get(i).getRemuneracao()%></td>
                                        </tr>
                                        <tr>
                                            <td>Descrição Vaga</td>
                                            <td><%=ListaVaga.get(i).getDesc_Vaga()%></td>
                                        </tr>
                                        <tr>
                                            <td>Status Vaga</td>
                                            <%if(ListaVaga.get(i).getStatus_Vaga() == 'A'){%><td>Aberto</td><%}%>
                                        </tr>
                                    <tbody>
                                </table>
                                <div class="little-container col-lg-3 col-md-12 col-sm-12">
                                    <a type="submit" class="btn-gerenciar-vaga btn btn-primary1" id="Visualizar" href="ImplicareServlet?PesquisarRespostaVaga=<%=ListaVaga.get(i).getSeq_Vaga()%>">Visualizar</a>
                                </div>
                            </div>
                        </div>
                    </div>
                if(i%2 == 0){%>
                    </div>
                <%}%>                           
            <% } %>
        </div>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        
    </body>
</html>

