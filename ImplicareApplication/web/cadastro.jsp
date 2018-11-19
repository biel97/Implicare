<%-- 
    Document   : cadastro
    Created on : 19/11/2018, 01:11:21
    Author     : ADM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
        <link href="css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
        <link href="css/bootstrap-theme.css" rel="stylesheet" type="text/css">
        <link href="css/style.css" rel="stylesheet" type="text/css">
    </head>
    <body id="cadastro">
        <div class="container">
            <div class="cadastro">
                <div class="panel">
                    <h1>Cadastro</h1>
                </div>
        <div class="opcao-cadastro">

                <p class="linha-botao-op-cad">
                <div class="btn-group btn-group " role="group" aria-label="opCadastro">
                    <button type="button" onclick="bt1()" value="0" id="bt1" class="btn btn-secondary bt1">Empresa</button>
                    <button type="button" onclick="bt2()" value="0" id="bt2" class="btn btn-secondary bt2">Candidato</button>
                </div>
                    
                </p>

        </div>
                <div class="conteudo-cadastro">
                    <% if(true%><%){ %>
                        <%@ include file="formCadastroCandidato.jspf" %>
                    <% }else if(false){ %>
  
                        <%@ include file="formCadastroEmpresa.jspf" %>
                    <% } %>
                    
                        
                </div>
            </div>
        </div>
        <script type="text/javascript" src="js/scripts.js"></script>
        <script type="text/javascript" src="js/jquery.js"></script>
    </body>
</html>


