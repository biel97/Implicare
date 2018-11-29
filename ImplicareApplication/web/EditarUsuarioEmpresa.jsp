<%@ page pageEncoding="UTF-8" %>
<%@page import="br.cefetmg.implicare.model.domain.Empresa"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Experiência Profissional</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
        <link href="css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
        <link href="css/bootstrap-theme.css" rel="stylesheet" type="text/css">
        <link href="css/style.css" rel="stylesheet" type="text/css">
    </head>
<body id="LoginForm">
    <div class="container">
        <%@include file="headerEmpresa.jspf" %>
        <div class="login-form">
            <div class="main-div">
                <%Empresa Empr = (Empresa)request.getAttribute("Empresa");%>
                <form action="ImplicareServlet?acao=AlterarUsuarioEmpresa" method="POST">
                    <div class="form-group">
                        <input type="text" class="form-control" name="Nome_Fantasia" value="<%=Empr.getNome_Fantasia()%>" required>
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" name="Nom_Razao_Social" value="<%=Empr.getNom_Razao_Social()%>" required>
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" name="Email" value="<%=Empr.getEmail()%>">
                    </div>
                    <div class="form-group">
                        <input type="file" name="Foto">
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" name="Senha" value="<%=Empr.getSenha()%>">
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" name="Endereco" value="<%=Empr.getEndereco()%>">
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" name="Desc_Usuario" value="<%=Empr.getDesc_Usuario()%>">
                    </div>
                    <button type="submit" class="btn btn-primary" id="EditarEmpresa">Editar Empresa</button>
                </form>
            </div>
        </div>
    </div>
    <%@include file="footer.jspf" %>
</body>
</html>
