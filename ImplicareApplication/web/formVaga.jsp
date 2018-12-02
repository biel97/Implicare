<%@ page pageEncoding="UTF-8" %>
<%@page import="java.util.ArrayList"%>
<%@page import="br.cefetmg.implicare.model.domain.Cargo"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vaga</title>
        <link rel="icon" type="image/png" href="img/favicon-32x32.png" sizes="32x32" />
        <link rel="icon" type="image/png" href="img/favicon-16x16.png" sizes="16x16" />
        
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link href="css/font.min.css" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
    <link href="css/blog.min.css" rel="stylesheet">
    
        


        <link href="css\style.css" rel="stylesheet" type="text/css"/>
        <link href="css/footer.css" rel="stylesheet">
    </head>
<body id="LoginForm">
    <%@include file="headerEmpresa.jspf" %>
    <div class="container" style="margin-bottom: 60px;">
        
        <div class="login-form">
            <div class="main-div">
                <form action="ImplicareServlet?acao=InserirVaga" method="POST">
                    <div class="form-group">
                        <label for="exampleFormControlSelect1">Cargo</label>
                        <select class="form-control" id="Cod_Cargo" name="Cod_Cargo" requeried>
                            <% 
                                ArrayList<Cargo> ListaCargo = (ArrayList)request.getAttribute("ListaCargo");
                                for(int i = 0; i < ListaCargo.size(); i++) { 
                            %>
                                <option value="<%=ListaCargo.get(i).getCod_Cargo()%>">
                                               <%=ListaCargo.get(i).getNom_Cargo()%>
                                               </option> <% } %>
                        </select>
                    </div>
                    <div class="form-group">
                        <input type="date" class="form-control" name="Dat_Publicacao" requeried>
                    </div>

                    <div class="form-group">
                        <input type="number" class="form-control" name="Num_Vagas" placeholder="Número de Vagas">
                    </div>
                    
                    <div class="form-group">
                        <input type="number" class="form-control" name="Carga_Horaria" placeholder="Carga Horária">
                    </div>
                    <div class="form-group">
                        <input type="number" class="form-control" name="Remuneracao" placeholder="Remuneração">
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" name="Desc_Vaga" placeholder="Descrição Vaga">
                    </div>
                    <button type="submit" class="btn btn-primary" id="Inserir Vaga">Inserir Vaga</button>
                </form>
            </div>
        </div>
    </div>
     <%@include file="footer.jspf" %>
     <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/hammer.js/2.0.8/hammer.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.lazyload/1.9.1/jquery.lazyload.js"></script>
        <script type="text/javascript" src="js/scripts.js"></script>
        <script src="js/clean-blog.min.js"></script>
</body>
</html>
