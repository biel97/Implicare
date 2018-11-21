<%-- 
    Document   : index
    Created on : 17/11/2018, 15:05:06
    Author     : ADM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link href="css\bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css\bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>
        <link href="css\bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css\bootstrap-theme.css" rel="stylesheet" type="text/css"/>
        <link href="css\style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body id="pagPrincipal">

        <div class="container">
         <%@include file="header.jspf" %>
            <div class="pagina-inicial">
                <div class="main-div">
                    <div class="panel">
                        <h1>Logue ou cadastre-se</h1>
                    </div>
                    <div class="grupo-botao">
                        <div class="row">
                            <p class="botao-pg-principal"><a class="btn btn-primary botao-index" href="login.jsp" role="button">Login</a>
                            <a class="btn btn-primary botao-index" href="cadastro.jsp" role="button">Cadastro</a></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
            <script type="text/javascript" src="js/scripts.js"></script>
        <script type="text/javascript" src="js/jquery.js"></script>
            <script type="text/javascript" src="js/bootstrap.min.js"></script>
    </body>
</html>
