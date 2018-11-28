<%-- 
    Document   : AvaliarVagas
    Created on : 26/11/2018, 04:27:04
    Author     : Gabriel  
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.cefetmg.implicare.model.domain.Vaga"%>
<%@page import="br.cefetmg.implicare.model.domain.Empresa"%>
<%@page import="br.cefetmg.implicare.model.domain.Cargo"%>
<%@page import="br.cefetmg.implicare.model.domain.Telefone"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Avaliar Vagas</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
       
        <link href="css\style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body id="pagPrincipal">
        <%ArrayList<Vaga> ListaVaga = (ArrayList<Vaga>)request.getAttribute("ListaVaga");
        ArrayList<Empresa> ListaEmpresa = (ArrayList<Empresa>)request.getAttribute("ListaEmpresa");
        ArrayList<Cargo> ListaCargo = (ArrayList<Cargo>)request.getAttribute("ListaCargo");
        ArrayList<Telefone> ListaTelefone = (ArrayList<Telefone>)request.getAttribute("ListaTelefone");
        %>
        <div class="container">
            <%if(ListaVaga != null) {%>
                <div class="stack col-md-6">
                    <div class="swipe-area">
                        <div class="final-message"><b>Sem correspondências</b></div>
                        <ul>
                            
                                <%for(int x=0; x<ListaVaga.size(); x++) {%> 
                                <li>
                                    <div class="emp-profile">
                                        <form method="post">
                                            <div class="row">
                                                <div class="col-md-4">
                                                    <div class="profile-img">
                                                        <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS52y5aInsxSm31CvHOFHWujqUx_wWTS9iM6s7BAm21oEN_RiGoog" alt=""/>
                                                        <div class="file btn btn-lg btn-primary1">
                                                            Mudar Foto
                                                            <input type="file" name="file"/>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-8">
                                                    <div class="profile-head">
                                                        <div class="row">
                                                                <h5 class="nome-usuario">
                                                                    <%int count = 0;
                                                                    int count1 = 0;
                                                                    for(; count < ListaCargo.size(); count++) {
                                                                        if(ListaVaga.get(x).getCod_Cargo() == ListaCargo.get(count).getCod_Cargo()) {
                                                                            break;
                                                                        }
                                                                    }
                                                                    for(; count1 < ListaEmpresa.size(); count1++) {
                                                                        if(ListaVaga.get(x).getCNPJ() == ListaEmpresa.get(count1).getCPF_CNPJ()) {
                                                                            break;
                                                                        }
                                                                    }%>
                                                                           
                                                                    <b><%=ListaCargo.get(count).getNom_Cargo()%><%=ListaEmpresa.get(count1).getNome_Fantasia()%></b>
                                                                </h5>
                                                        </div>
                                                        <div class="row">
                                                            <ul class="nav nav-tabs" id="myTab" role="tablist">
                                                                <li class="nav-item">
                                                                    <a class="nav-link active" id="Vaga-tab" data-toggle="tab" href="#Vaga" role="tab" aria-controls="Perfil" aria-selected="true">Vaga</a>
                                                                </li>
                                                                <li class="nav-item">
                                                                    <a class="nav-link active" id="perfil-tab" data-toggle="tab" href="#Perfil" role="tab" aria-controls="Perfil" aria-selected="true">Perfil</a>
                                                                </li>
                                                                <li class="nav-item">
                                                                    <a class="nav-link" id="Telefone-tab" data-toggle="tab" href="#Telefone" role="tab" aria-controls="profile" aria-selected="false">Telefones</a>
                                                                </li>
                                                            </ul>
                                                        </div>
                                                    </div>
                                                </div>

                                            </div>
                                             <div class="row">
                                                <div class="col-md-4"></div>
                                                <div class="col-md-8">
                                                    <div class="tab-content profile-tab" id="myTabContent">
                                                            <div class="tab-pane fade show active" id="Vaga" role="tabpanel" aria-labelledby="Pefil-tab">
                                                                    <div class="row">
                                                                        <div class="col-md-6">
                                                                            <label>Cargo</label>
                                                                        </div>
                                                                        <div class="col-md-6">
                                                                            <p><%=ListaCargo.get(count).getNom_Cargo()%></p>
                                                                        </div>
                                                                    </div>
                                                                    <div class="row">
                                                                        <div class="col-md-6">
                                                                            <label>Data Publicação</label>
                                                                        </div>
                                                                        <div class="col-md-6">
                                                                            <p><%=ListaVaga.get(x).getDat_Publicacao()%></p>
                                                                        </div>
                                                                    </div>
                                                                    <div class="row">
                                                                        <div class="col-md-6">
                                                                            <label>Número de Vagas</label>
                                                                        </div>
                                                                        <div class="col-md-6">
                                                                            <p><%=ListaVaga.get(x).getNum_Vagas()%></p>
                                                                        </div>
                                                                    </div>
                                                                    <div class="row">
                                                                        <div class="col-md-6">
                                                                            <label>Carga Horária</label>
                                                                        </div>
                                                                        <div class="col-md-6">
                                                                            <p><%=ListaVaga.get(x).getCarga_Horaria()%></p>
                                                                        </div>
                                                                    </div>
                                                                    <div class="row">
                                                                        <div class="col-md-6">
                                                                            <label>Remuneração</label>
                                                                        </div>
                                                                        <div class="col-md-6">
                                                                            <p><%=ListaVaga.get(x).getRemuneracao()%></p>
                                                                        </div>
                                                                    </div>
                                                                    <div class="row">
                                                                        <div class="col-md-6">
                                                                            <label>Descrição Vaga</label>
                                                                        </div>
                                                                        <div class="col-md-6">
                                                                            <p><%=ListaVaga.get(x).getDesc_Vaga()%></p>
                                                                        </div>
                                                                    </div>
                                                        </div>

                                                        <div class="tab-pane fade show active" id="Perfil" role="tabpanel" aria-labelledby="Perfil-tab">
                                                                    <div class="row">
                                                                        <div class="col-md-6">
                                                                            <label>CNPJ</label>
                                                                        </div>
                                                                        <div class="col-md-6">
                                                                            <p><%=ListaEmpresa.get(count1).getCPF_CNPJ()%></p>
                                                                        </div>
                                                                    </div>
                                                                    <div class="row">
                                                                        <div class="col-md-6">
                                                                            <label>Nome Fantasia</label>
                                                                        </div>
                                                                        <div class="col-md-6">
                                                                            <p><%=ListaEmpresa.get(count1).getNome_Fantasia()%></p>
                                                                        </div>
                                                                    </div>
                                                                    <div class="row">
                                                                        <div class="col-md-6">
                                                                            <label>Nome Razão Social</label>
                                                                        </div>
                                                                        <div class="col-md-6">
                                                                            <p><%=ListaEmpresa.get(count1).getNom_Razao_Social()%></p>
                                                                        </div>
                                                                    </div>
                                                                    <div class="row">
                                                                        <div class="col-md-6">
                                                                            <label>Email</label>
                                                                        </div>
                                                                        <div class="col-md-6">
                                                                            <p><%=ListaEmpresa.get(count1).getEmail()%></p>
                                                                        </div>
                                                                    </div>
                                                                    <div class="row">
                                                                        <div class="col-md-6">
                                                                            <label>Endereço</label>
                                                                        </div>
                                                                        <div class="col-md-6">
                                                                            <p><%=ListaEmpresa.get(count1).getEndereco()%></p>
                                                                        </div>
                                                                    </div>
                                                                    <div class="row">
                                                                        <div class="col-md-6">
                                                                            <label>Descrição</label>
                                                                        </div>
                                                                        <div class="col-md-6">
                                                                            <p><%ListaEmpresa.get(count1).getDesc_Usuario();%></p>
                                                                        </div>
                                                                    </div>
                                                        </div>

                                                        <div class="tab-pane fade" id="Telefone" role="tabpanel" aria-labelledby="Telefone-tab">
                                                              <%for(int j = 0; j < ListaTelefone.size(); j++) {
                                                                    if(ListaEmpresa.get(count1).getCPF_CNPJ() == ListaTelefone.get(j).getCPF_CNPJ()) {%>
                                                                        <div class="row">
                                                                            <div class="col-md-6">
                                                                                <label>Tipo de Telefone</label>
                                                                            </div>
                                                                            <div class="col-md-6">
                                                                                <%if(ListaTelefone.get(j).getTipo_Telefone() == "C"){%>Telefone Comercial<%}%>
                                                                                <%if(ListaTelefone.get(j).getTipo_Telefone() == "F"){%>Telefone Fixo<%}%>
                                                                                <%if(ListaTelefone.get(j).getTipo_Telefone() == "M"){%>Telefone Móvel<%}%>
                                                                            </div>
                                                                        </div>
                                                                        <div class="row">
                                                                            <div class="col-md-6">
                                                                                <label>Número de Telefone</label>
                                                                            </div>
                                                                            <div class="col-md-6">
                                                                                <p><%=ListaTelefone.get(j).getNum_Telefone()%></p>
                                                                            </div>
                                                                        </div>
                                                                        <div class="row">
                                                                            <div class="col-md-6">
                                                                                <label>DDD</label>
                                                                            </div>
                                                                            <div class="col-md-6">
                                                                                <p><%=ListaTelefone.get(j).getDDD()%></p>
                                                                            </div>
                                                                        </div>
                                                                        <div class="row">
                                                                            <div class="col-md-6">
                                                                                <label>Ramal</label>
                                                                            </div>
                                                                            <div class="col-md-6">
                                                                                <p><%=ListaTelefone.get(j).getRamal()%></p>
                                                                            </div>
                                                                        </div>
                                                                    <%}
                                                                }%>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                        </form>           
                                    </div>
                                </li>
                            <%}%>
                        </ul>
                    </div>
                <div class="botoes-swipe">
                    <div class="espacamentobotaoswipe"></div>
                    <div class="espacobotaoswipe">
                        <button type="button" class="btn btn-primary1 js-left-trigger col-md-2">
                            Não Gostei
                        </button>
                        <button type="button" class="btn btn-primary1 js-right-trigger col-md-2">
                            Gostei
                        </button>
                    </div>
                </div>
            </div>
            <%} else {%>
                  <%@include file="SwipeCarousel.jspf"%>
            <%}%>
        </div>
    </body>
</html>