<%@ page pageEncoding="UTF-8" %>
<%@page import="java.util.ArrayList"%>
<%@page import="br.cefetmg.implicare.model.domain.Cargo"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Experiência Profissional</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
        <link href="css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
        <link href="css/bootstrap-theme.css" rel="stylesheet" type="text/css">
        <link href="css/style.css" rel="stylesheet" type="text/css">
    </head>
<body id="LoginForm">
    <div class="container">
        <div class="login-form">
            <div class="main-div">
                <form>
                    <div class="form-group">
                        <input type="text" class="form-control" id="Nom_Empresa" placeholder="Nome da Empresa">
                    </div>
                    <div class="form-group">
                        <label for="exampleFormControlSelect1">Cargo</label>
                        <select class="form-control" id="Cod_Cargo" name="Cod_Cargo">
                            <% 
                                ArrayList<Cargo> ListaCargo = (ArrayList)request.getAttribute("ListaCargo");
                                for(int i = 0; i < ListaCargo.size(); i++) { 
                            %>
                                <option value="<% ListaCargo.get(i).getCod_Cargo(); %>">
                                               <% ListaCargo.get(i).getNom_Cargo(); %>
                                               </option> <% } %>
                        </select>
                    </div>


                    <div class="form-group">
                        <input type="text" class="form-control" id="Atividades_Desenvolvidas" placeholder="Atividades desenvolvidas">
                    </div>
                    <div class="form-group">
                        <input type="date" class="form-control" id="Data_Inicio" >
                    </div>
                    <div class="form-group">
                        <input type="date" class="form-control" id="Data_Termino" >
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" id="Desc_Experiencia_Profissional" placeholder="Descrição Experiência Profissional">
                    </div>
                    <button type="submit" class="btn btn-primary" id="Inserir Experiência Profissional">Inserir Experiência Profissional</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>