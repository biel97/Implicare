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
        <link rel="icon" type="image/png" href="img/favicon-32x32.png" sizes="32x32" />
        <link rel="icon" type="image/png" href="img/favicon-16x16.png" sizes="16x16" />

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
 
        <link href="css/font.min.css" rel="stylesheet" type="text/css">
        <link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
        <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
  
  

        <link href="css/footer.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body id="cadastro">        
        <div class="container" style="margin-bottom: 120px;">
            <div class="cadastro">
                <div class="panel">
           <p>Insira login e senha</p>
           </div>
                <div class="opcao-cadastro">
                    <div class="row">
                        <ul class="nav nav-tabs" id="myTab" role="tablist">
                            <li class="nav-item">
                                <a class="nav-link active" id="perfil-tab" data-toggle="tab" href="#Empresa" role="tab" aria-controls="Perfil" aria-selected="true">Empresa</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" id="Telefone-tab" data-toggle="tab" href="#Candidato" role="tab" aria-controls="profile" aria-selected="false">Candidato</a>
                            </li>
                        </ul>
                    </div>
                    <div class="row">
        
                    <div class="col-md-12">
                        <div class="tab-content profile-tab" id="myTabContent">
                            
                            <div class="tab-pane fade show active" id="Empresa" role="tabpanel" aria-labelledby="Perfil-tab">
                                <%@include file="formCadastroEmpresa.jspf" %>        
                                
                            </div>

                            <div class="tab-pane fade" id="Candidato" role="tabpanel" aria-labelledby="Telefone-tab">
                                  <%@include file="formCadastroCandidato.jspf" %>
                                      
                                
                            </div>
                        </div>
                    </div>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="footer.jspf" %>


        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    
    </body>
</html>


