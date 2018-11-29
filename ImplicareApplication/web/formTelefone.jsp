<%@ page pageEncoding="UTF-8" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Telefone</title>
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
                <form action="ImplicareServlet?acao=InserirTelefone" method="POST">
                    <div class="form-group">
                        <input type="number" class="form-control" name="Num_Telefone" placeholder="Némero de Telefone" requeried>
                    </div>
                    <div class="form-group">
                        <label for="exampleFormControlSelect1">Area de Estudo</label>
                        <select class="form-control" id="Tipo_Telefone" name="Tipo_Telefone" requeried>
                            <option value="C">Telefone Comercial</option> 
                            <option value="F">Telefone Fixo</option> 
                            <option value="M">Telefone Móvel</option> 
                        </select>
                    </div>
                    <div class="form-group">
                        <input type="number" class="form-control" name="DDD" placeholder="DDD" requeried>
                    </div>
                    <div class="form-group">
                        <input type="number" class="form-control" name="Ramal" >
                    </div>
                    <button type="submit" class="btn btn-primary" id="Inserir Telefone">Inserir Telefone</button>
                </form>
            </div>
        </div>
    </div>
    <%@include file="footer.jspf" %>
</body>
</html>