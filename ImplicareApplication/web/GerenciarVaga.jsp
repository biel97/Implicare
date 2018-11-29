<%-- 
    Document   : GerenciarVaga
    Created on : 21/11/2018, 18:17:14
    Author     : Gabriel
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.cefetmg.implicare.model.domain.Cargo"%>
<%@page import="br.cefetmg.implicare.model.domain.Vaga"%>
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
        <div class="container">
            <%@include file="headerEmpresa.jspf" %>
            <%ArrayList<Vaga> ListaVaga = (ArrayList<Vaga>)request.getAttribute("ListaVaga");
            ArrayList<Cargo> ListaCargo = (ArrayList<Cargo>)request.getAttribute("ListaCargo");
            if( ListaVaga != null) {%>
                <%for(int i = 0; i < ListaVaga.size(); i++) { 
                    if(i%2 == 0){%>
                        <div class="row">
                    <%}%>
                        <div class="col-md-6">
                            <div class="panel panel-primary1">
                                <div class="panel-heading">

                                    <%for(int j = 0; j < ListaCargo.size(); j++) {
                                        if(ListaVaga.get(i).getCod_Cargo() == ListaCargo.get(j).getCod_Cargo()){%>
                                            <h3 class="panel-title"><%=ListaCargo.get(j).getNom_Cargo()%></h3>
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
                                                <%if(ListaVaga.get(i).getStatus_Vaga() == 'E'){%><td>Encerrada</td><%}%>  
                                            </tr>
                                        <tbody>
                                    </table>
                                    <div class="little-container col-lg-3 col-md-12 col-sm-12">
                                        <%if(ListaVaga.get(i).getStatus_Vaga() == 'A'){%>
                                            <a type="submit" class="btn-gerenciar-vaga btn btn-primary1" id="ResponderCandidatos" href="ImplicareServlet?acao=ListarCandidatoVaga&Seq_Vaga=<%=ListaVaga.get(i).getSeq_Vaga()%>">Responder Candidatos</a>
                                            <a type="submit" class="btn-gerenciar-vaga btn btn-primary1" id="GerenciarCandidatos" href="ImplicareServlet?acao=ListarCandidatoVagaAceito&Seq_Vaga=<%=ListaVaga.get(i).getSeq_Vaga()%>">Gerenciar Candidatos</a>
                                            <a type="submit" class="btn-gerenciar-vaga btn btn-primary1" id="EditarVaga" href="ImplicareServlet?acao=PesquisarVaga&Seq_Vaga=<%=ListaVaga.get(i).getSeq_Vaga()%>">Editar Vaga</a>
                                            <a type="submit" class="btn-gerenciar-vaga btn btn-primary1" id="ExcluirVaga" href="ImplicareServlet?acao=ExcluirVaga&Seq_Vaga=<%=ListaVaga.get(i).getSeq_Vaga()%>">Excluir Vaga</a>
                                        <%} else {%>
                                                <a type="submit" class="btn-gerenciar-vaga btn btn-primary1" id="GerenciarCandidatos" href="ImplicareServlet?acao=ListarCandidatoVagaAceito&Seq_Vaga=<%=ListaVaga.get(i).getSeq_Vaga()%>">Gerenciar Candidatos</a>
                                                <a type="submit" class="btn-gerenciar-vaga btn btn-primary1" id="EditarVaga" href="ImplicareServlet?acao=PesquisarVaga&Seq_Vaga=<%=ListaVaga.get(i).getSeq_Vaga()%>">Editar Vaga</a>
                                                <a type="submit" class="btn-gerenciar-vaga btn btn-primary1" id="ExcluirVaga" href="ImplicareServlet?acao=ExcluirVaga&Seq_Vaga=<%=ListaVaga.get(i).getSeq_Vaga()%>">Excluir Vaga</a>
                                            <%}%>
                                    </div>
                                </div>
                            </div>
                        </div>
                    <%if(i%2 == 0){%>
                        </div>
                    <%}
                }
            }%>                           
            <div class="row ">
                <div class="col-md-3">
                    <a type="submit" class="btn btn-primary1 btn-gerenciar-vaga" id="CriarVaga" href="ImplicareServlet?acao=ListarCargo">Criar Vaga</a>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/hammer.js/2.0.8/hammer.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.lazyload/1.9.1/jquery.lazyload.js"></script>
        <script type="text/javascript" src="js/scripts.js"></script>
        <script src="js/clean-blog.min.js"></script>
        <%@include file="footer.jspf" %>
    </body>
</html>
