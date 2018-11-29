<%-- 
    Document   : TelaPerfilEmpresa
    Created on : 26/11/2018, 04:12:57
    Author     : Gabriel
--%>

<%@page import="br.cefetmg.implicare.model.domain.Cargo"%>
<%@page import="br.cefetmg.implicare.model.domain.Vaga"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.cefetmg.implicare.model.domain.Empresa"%>
<%@page import="br.cefetmg.implicare.model.domain.Telefone"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Perfil</title>
        <link rel="icon" type="image/png" href="img/favicon-32x32.png" sizes="32x32" />
<link rel="icon" type="image/png" href="img/favicon-16x16.png" sizes="16x16" />

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link href="css\style.css" rel="stylesheet" type="text/css"/>
        
    </head>
    <body id="LoginForm">
        <%Vaga Vag = (Vaga)request.getAttribute("Vaga");
          Cargo Carg = (Cargo)request.getAttribute("Cargo");
          Empresa Empr = (Empresa)request.getAttribute("Empresa");
          ArrayList<Telefone> ListaTelefone = (ArrayList<Telefone>)request.getAttribute("ListaTelefone");
          %>
        <div class="container ">
            <%@include file="headerCandidato.jspf" %>
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
                                        <b><%=Carg.getNom_Cargo()%><%=Empr.getNome_Fantasia()%></b>
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
                                                <p><%=Carg.getNom_Cargo()%></p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Data Publicação</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p><%=Vag.getDat_Publicacao()%></p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Número de Vagas</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p><%=Vag.getNum_Vagas()%></p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Carga Horária</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p><%=Vag.getCarga_Horaria()%></p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Remuneração</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p><%=Vag.getRemuneracao()%></p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Descrição Vaga</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p><%=Vag.getDesc_Vaga()%></p>
                                            </div>
                                        </div>
                            </div>
                            
                            <div class="tab-pane fade show active" id="Perfil" role="tabpanel" aria-labelledby="Perfil-tab">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>CNPJ</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p><%=Empr.getCPF_CNPJ()%></p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Nome Fantasia</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p><%=Empr.getNome_Fantasia()%></p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Nome Razão Social</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p><%=Empr.getNom_Razao_Social()%></p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Email</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p><%=Empr.getEmail()%></p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Endereço</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p><%=Empr.getEndereco()%></p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Descrição</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p><%=Empr.getDesc_Usuario()%></p>
                                            </div>
                                        </div>
                            </div>

                            <div class="tab-pane fade" id="Telefone" role="tabpanel" aria-labelledby="Telefone-tab">
                                  <%for(int j = 0; j < ListaTelefone.size(); j++) {%> 
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
                                <%}%> 
                                    </div>
                                </div>
                            </div>
                        </div>
            </form>           
        </div>
        </div>
        <%@include file="footer.jspf" %>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </body>
</html>