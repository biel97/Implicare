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
        <link rel="icon" type="image/png" href="img/favicon-32x32.png" sizes="32x32" />
        <link rel="icon" type="image/png" href="img/favicon-16x16.png" sizes="16x16" />
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
        <link href="css/font.min.css" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
    <link href="css/blog.min.css" rel="stylesheet">
  
        <link href="css/style.css" rel="stylesheet" type="text/css">
        <link href="css/footer.css" rel="stylesheet">
    </head>
    
        <body id="LoginForm">
            
        <div class="container" style="margin-bottom: 120px;">
            <h1 class="form-heading" style="color: #fff"><b>Implicare</b></h1>
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
                
                <input type="submit" class="btn btn-primary1 col-md-12" id="Login" name="Login">

            </form>
            </div>

        </div>
            
        </div>
            <%@include file="footer.jspf" %>
        

<script src="js/clean-blog.min.js"></script>
        </body>
</html>
