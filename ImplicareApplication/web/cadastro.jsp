<%-- 
    Document   : cadastro
    Created on : 19/11/2018, 01:11:21
    Author     : ADM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
                    <a class="btn btn-primary op-cad bt1" id="bt1" onclick="bt1()" role="button">Empresa</a>
                    <a class="btn btn-primary op-cad bt2" id="bt2" onclick="bt2()" role="button">Candidato</a>
                </p>

        </div>
                <div id="conteudo-cadastro">
                    

                </div>
            </div>
        </div>
        <script type="text/javascript" src="js/scripts.js"></script>
        <script type="text/javascript" src="js/jquery.js"></script>
    </body>
</html>


