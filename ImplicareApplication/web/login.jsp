<%-- 
    Document   : login
    Created on : 17/11/2018, 13:49:57
    Author     : ADM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
        <link href="css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
        <link href="css/bootstrap-theme.css" rel="stylesheet" type="text/css">
        <link href="css/style.css" rel="stylesheet" type="text/css">
    </head>
    
        <body id="LoginForm">
        <div class="container">
            <h1 class="form-heading"><b>Implicare</b></h1>
        <div class="login-form">
        <div class="main-div">
            <div class="panel">
           <p>Insira login e senha</p>
           </div>
            <form action="ImplicareServlet?acao=Login" method="POST">

                <div class="form-group">


                    <input type="text" class="form-control" name="CPF_CNPJ" placeholder="Login" requeried>

                </div>

                <div class="form-group">

                    <input type="password" class="form-control" name="Senha" placeholder="Password" requeried>

                </div>
                
                <input type="submit" class="btn btn-primary" id="Login">

            </form>
            </div>

        </div></div></div>


        </body>
</html>
