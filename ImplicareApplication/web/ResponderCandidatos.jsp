<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.cefetmg.implicare.model.domain.CandidatoVaga"%>
<%@page import="br.cefetmg.implicare.model.domain.Candidato"%>
<%@page import="br.cefetmg.implicare.model.domain.FormacaoAcademica"%>
<%@page import="br.cefetmg.implicare.model.domain.AreaEstudo"%>
<%@page import="br.cefetmg.implicare.model.domain.ExperienciaProfissional"%>
<%@page import="br.cefetmg.implicare.model.domain.Cargo"%>
<%@page import="br.cefetmg.implicare.model.domain.Telefone"%>
<%@page import="br.cefetmg.implicare.model.domain.CargoInteresse"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Avaliar Candidatos</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
       
        <link href="css\style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body id="pagPrincipal">
        <%ArrayList<CandidatoVaga> ListaCandidatoVaga = (ArrayList<CandidatoVaga>)request.getAttribute("ListaCandidatoVaga");
        ArrayList<Candidato> ListaCandidato = (ArrayList<Candidato>)request.getAttribute("ListaCandidato");
        ArrayList<FormacaoAcademica> ListaFormAcad = (ArrayList)request.getAttribute("ListaFormAcad");
        ArrayList<AreaEstudo> ListaArea = (ArrayList)request.getAttribute("ListaArea");
        ArrayList<ExperienciaProfissional> ListaExpProfissional = (ArrayList)request.getAttribute("ListaExpProfissional");
        ArrayList<Cargo> ListaCargo = (ArrayList)request.getAttribute("ListaCargo");
        ArrayList<Telefone> ListaTelefone = (ArrayList)request.getAttribute("ListaTelefone");
        ArrayList<CargoInteresse> ListaCargoInt = (ArrayList)request.getAttribute("ListaCargoInt");
        ArrayList<Cargo> ListaCargoArea = (ArrayList)request.getAttribute("ListaCargoArea");
        %>
        <div class="container">
            <div class="swipe">
                <div class="stack col-md-6">
                    <div class="swipe-area">
                        <ul>
                            <%for(int x=0; x<ListaCandidato.size(); x++) {%> 
                                <li>
                                    <div id="card+<%=x%>" class="card col-md-12 js-swiping-card">
                                        <div class="container emp-profile">
                                            <form method="post">
                                                <div class="row">
                                                    <div class="col-md-4">
                                                        <div class="profile-img">
                                                            <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS52y5aInsxSm31CvHOFHWujqUx_wWTS9iM6s7BAm21oEN_RiGoog" alt=""/>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-8">
                                                        <div class="profile-head">
                                                            <div class="row">
                                                                    <h5 class="nome-usuario">
                                                                        <b><%ListaCandidato.get(x).getNome();%></b>
                                                                    </h5>
                                                            </div>
                                                            <div class="row">
                                                                <ul class="nav nav-tabs" id="myTab" role="tablist">
                                                                    <li class="nav-item">
                                                                        <a class="nav-link active" id="perfil-tab" data-toggle="tab" href="#Perfil" role="tab" aria-controls="Perfil" aria-selected="true">Perfil</a>
                                                                    </li>
                                                                    <li class="nav-item">
                                                                        <a class="nav-link" id="Formacao_Academica-tab" data-toggle="tab" href="#Formacao_Academica" role="Formacao_Academica" aria-controls="profile" aria-selected="false">Formação</a>
                                                                    </li>
                                                                    <li class="nav-item">
                                                                        <a class="nav-link" id="Experiencia_Profissional-tab" data-toggle="tab" href="#Experiencia_Profissional" role="tab" aria-controls="profile" aria-selected="false">Experiência Profissional</a>
                                                                    </li>
                                                                    <li class="nav-item">
                                                                        <a class="nav-link" id="Telefone-tab" data-toggle="tab" href="#Telefone" role="tab" aria-controls="profile" aria-selected="false">Telefones</a>
                                                                    </li>
                                                                    <li class="nav-item">
                                                                        <a class="nav-link" id="Cargo_Interesse-tab" data-toggle="tab" href="#Cargo_Interesse" role="tab" aria-controls="Cargo_Interesse" aria-selected="false">Cargo Interesse</a>
                                                                    </li>
                                                                </ul>
                                                            </div>
                                                        </div>
                                                    </div>

                                                </div>
                                                <div class="row">
                                                    <div class="col-md-4">
                                                        <div class="profile-work">
                                                            <p>Experiências Profissional</p>
                                                            <%for(int i = 0; i < ListaExpProfissional.size(); i++) { 
                                                                if(ListaExpProfissional.get(i).getCPF() == ListaCandidato.get(x).getCPF_CNPJ()) {%>
                                                                    <a href=""><%=ListaExpProfissional.get(i).getNom_Empresa()%></a><br/>
                                                                <%} 
                                                            } %>
                                                            <p>Formações</p>
                                                            <%for(int i = 0; i < ListaFormAcad.size(); i++) { 
                                                                if(ListaFormAcad.get(i).getCPF() == ListaCandidato.get(x).getCPF_CNPJ()) {
                                                                    for(int j = 0; j < ListaArea.size(); j++) {
                                                                        if(ListaFormAcad.get(i).getCod_Area_Estudo() == ListaArea.get(j).getCod_Area_Estudo()) {%>
                                                                            <a href=""><%=ListaArea.get(j).getNom_Area_Estudo()%></a><br/>
                                                                        <%}
                                                                    }
                                                                }
                                                            }%>
                                                        </div>
                                                        <a type="button" class="btn-gerenciar-vaga btn btn-primary1" href="">Voltar</a>
                                                    </div>
                                                    <div class="col-md-8">
                                                        <div class="tab-content profile-tab" id="myTabContent">

                                                            <div class="tab-pane fade show active" id="Perfil" role="tabpanel" aria-labelledby="Perfil-tab">
                                                                        <div class="row">
                                                                            <div class="col-md-6">
                                                                                <label>CPF</label>
                                                                            </div>
                                                                            <div class="col-md-6">
                                                                                <p><%=ListaCandidato.get(x).getCPF_CNPJ()%></p>
                                                                            </div>
                                                                        </div>
                                                                        <div class="row">
                                                                            <div class="col-md-6">
                                                                                <label>Nome</label>
                                                                            </div>
                                                                            <div class="col-md-6">
                                                                                <p><%=ListaCandidato.get(x).getNome()%></p>
                                                                            </div>
                                                                        </div>
                                                                        <div class="row">
                                                                            <div class="col-md-6">
                                                                                <label>Email</label>
                                                                            </div>
                                                                            <div class="col-md-6">
                                                                                <p><%=ListaCandidato.get(x).getEmail()%></p>
                                                                            </div>
                                                                        </div>
                                                                        <div class="row">
                                                                            <div class="col-md-6">
                                                                                <label>Data Nascimento</label>
                                                                            </div>
                                                                            <div class="col-md-6">
                                                                                <p><%=ListaCandidato.get(x).getData_Nascimento()%></p>
                                                                            </div>
                                                                        </div>
                                                                        <div class="row">
                                                                            <div class="col-md-6">
                                                                                <label>Endereço</label>
                                                                            </div>
                                                                            <div class="col-md-6">
                                                                                <p><%=ListaCandidato.get(x).getEndereco()%></p>
                                                                            </div>
                                                                        </div>
                                                                        <div class="row">
                                                                            <div class="col-md-6">
                                                                                <label>Descrição</label>
                                                                            </div>
                                                                            <div class="col-md-6">
                                                                                <p><%=ListaCandidato.get(x).getDesc_Usuario()%></p>
                                                                            </div>
                                                                        </div>
                                                            </div>

                                                            <div class="tab-pane fade" id="Formacao_Academica" role="tabpanel" aria-labelledby="Formacao_Academica-tab">
                                                                    <%for(int j = 0; j < ListaFormAcad.size(); j++) {
                                                                        if(ListaFormAcad.get(j).getCPF() == ListaCandidato.get(x).getCPF_CNPJ()) {%>
                                                                            <div class="row">
                                                                                <div class="col-md-6">
                                                                                    <label>Nome da Instituição</label>
                                                                                </div>
                                                                                <div class="col-md-6">
                                                                                    <p><%=ListaFormAcad.get(j).getInstituicao_Ensino()%></p>
                                                                                </div>
                                                                            </div>
                                                                            <div class="row">
                                                                                <div class="col-md-6">
                                                                                    <label>Formação</label>
                                                                                </div>
                                                                                <div class="col-md-6">
                                                                                    <%for(int i = 0; i < ListaArea.size(); i++) {
                                                                                        if(ListaFormAcad.get(j).getCod_Area_Estudo() == ListaArea.get(i).getCod_Area_Estudo()) {%>
                                                                                            <p><%=ListaArea.get(i).getNom_Area_Estudo()%></p>
                                                                                        <% } 
                                                                                    } %>
                                                                                </div>
                                                                            </div>
                                                                            <div class="row">
                                                                                <div class="col-md-6">
                                                                                    <label>Atividades Desenvolvidas</label>
                                                                                </div>
                                                                                <div class="col-md-6">
                                                                                    <p><%=ListaFormAcad.get(j).getAtividades_Desenvolvidas()%></p>
                                                                                </div>
                                                                            </div>
                                                                            <div class="row">
                                                                                <div class="col-md-6">
                                                                                    <label>Data de Ingresso</label>
                                                                                </div>
                                                                                <div class="col-md-6">
                                                                                    <p><%=ListaFormAcad.get(j).getData_Inicio()%></p>
                                                                                </div>
                                                                            </div>
                                                                            <div class="row">
                                                                                <div class="col-md-6">
                                                                                    <label>Data de Termino</label>
                                                                                </div>
                                                                                <div class="col-md-6">
                                                                                    <p><%=ListaFormAcad.get(j).getData_Termino()%></p>
                                                                                </div>
                                                                            </div>
                                                                            <div class="row">
                                                                                <div class="col-md-6">
                                                                                    <label>Descrição Formação</label>
                                                                                </div>
                                                                                <div class="col-md-6">
                                                                                    <p><%=ListaFormAcad.get(j).getDesc_Formacao_Academica()%></p>
                                                                                </div>
                                                                            </div>

                                                                    <%} 
                                                                }%>
                                                            </div>

                                                            <div class="tab-pane fade" id="Experiencia_Profissional" role="tabpanel" aria-labelledby="Experiencia_Profissional-tab">
                                                                    <%for(int j = 0; j < ListaExpProfissional.size(); j++) {
                                                                        if(ListaExpProfissional.get(j).getCPF() == ListaCandidato.get(x).getCPF_CNPJ()) {%>
                                                                            <div class="row">
                                                                                <div class="col-md-6">
                                                                                    <label>Nome da Empresa</label>
                                                                                </div>
                                                                                <div class="col-md-6">
                                                                                    <p><%=ListaExpProfissional.get(j).getNom_Empresa()%></p>
                                                                                </div>
                                                                            </div>
                                                                            <div class="row">
                                                                                <div class="col-md-6">
                                                                                    <label>Cargo</label>
                                                                                </div>
                                                                                <div class="col-md-6">
                                                                                    <p>
                                                                                    <%for(int i = 0; i < ListaCargo.size(); i++) {
                                                                                        if(ListaFormAcad.get(j).getCod_Area_Estudo() == ListaCargo.get(i).getCod_Cargo()) {%>
                                                                                            <p><%=ListaCargo.get(i).getNom_Cargo()%></p>
                                                                                    <% } 
                                                                                    } %>
                                                                                    </p>
                                                                                </div>
                                                                            </div>
                                                                            <div class="row">
                                                                                <div class="col-md-6">
                                                                                    <label>Data de Ingresso</label>
                                                                                </div>
                                                                                <div class="col-md-6">
                                                                                    <p><%=ListaExpProfissional.get(j).getData_Inicio()%></p>
                                                                                </div>
                                                                            </div>
                                                                            <div class="row">
                                                                                <div class="col-md-6">
                                                                                    <label>Data de Termino</label>
                                                                                </div>
                                                                                <div class="col-md-6">
                                                                                    <%if(ListaExpProfissional.get(j).getData_Termino() == null){ %>
                                                                                        <p>Atual</p>
                                                                                        <% } else { %> <p><%=ListaExpProfissional.get(j).getData_Termino()%></p><%}%>
                                                                                </div>
                                                                            </div>
                                                                            <div class="row">
                                                                                <div class="col-md-6">
                                                                                    <label>Descrição Experiencia</label>
                                                                                </div>
                                                                                <div class="col-md-6">
                                                                                    <p><%=ListaExpProfissional.get(j).getDesc_Experiencia_Profissional()%></p>
                                                                                </div>
                                                                            </div>
                                                                        <%}
                                                                    }%>
                                                            </div>

                                                            <div class="tab-pane fade" id="Telefone" role="tabpanel" aria-labelledby="Telefone-tab">
                                                                    <%for(int j = 0; j < ListaTelefone.size(); j++) {
                                                                        if(ListaTelefone.get(j).getCPF_CNPJ() == ListaCandidato.get(x).getCPF_CNPJ()) {%>
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

                                                            <div class="tab-pane fade" id="Cargo_Interesse" role="tabpanel" aria-labelledby="Cargo_Interesse-tab">
                                                                <div class="row">
                                                                        <div class="form-group">
                                                                            <label for="CargoInteresse">Cargo Interesse</label>
                                                                            <select class="form-control" id="Cod_Cargo" name="Cod_Cargo">
                                                                                <%for(int i = 0; i < ListaCargoInt.size(); i++) {
                                                                                    if(ListaCargoInt.get(i).getCPF() == ListaCandidato.get(x).getCPF_CNPJ()) {
                                                                                        for(int j = 0; j < ListaCargo.size(); j++) {
                                                                                            if(ListaCargoInt.get(i).getCod_Cargo() == ListaCargo.get(j).getCod_Cargo()) {%>
                                                                                                <option value="<%=ListaCargoInt.get(i).getCod_Cargo()%>">
                                                                                                    <%=ListaCargo.get(j).getNom_Cargo()%>
                                                                                                </option>
                                                                                           <%}
                                                                                        }
                                                                                    }
                                                                                }%>
                                                                            </select>
                                                                        </div>
                                                                    </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </form>           
                                        </div>
                                    </div>
                                </li>
                            <%}%>
                        </ul>
                    </div>
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
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/hammer.js/2.0.8/hammer.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.lazyload/1.9.1/jquery.lazyload.js"></script>
        <script type="text/javascript" src="js/scripts.js"></script>
    </body>
</html>

