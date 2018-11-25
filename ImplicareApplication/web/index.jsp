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
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
       
        <link href="css\style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body id="pagPrincipal">

        <div class="container">

            <div class="pagina-inicial">
                <div class="main-div">
                    <div class="panel">
                        <h1>Logue ou cadastre-se</h1>
                    </div>
                    <div class="grupo-botao">
                        <div class="row">
                            <p class="botao-pg-principal"><a class="btn btn-primary1 botao-index" href="login.jsp" role="button">Login</a>
                            <a class="btn btn-primary1 botao-index" href="cadastro.jsp" role="button">Cadastro</a></p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="swipe">
                <%@include file="SwipeCarousel.jspf" %>
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
