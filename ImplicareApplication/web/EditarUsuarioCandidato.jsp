<%@ page pageEncoding="UTF-8" %>
<%@page import="br.cefetmg.implicare.model.domain.Candidato"%>

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
        <div class="login-form">
            <div class="main-div">
                <%Candidato Cand = (Candidato)request.getAttribute("Candidato");%>
                <form action="ImplicareServlet?acao=AlterarUsuarioEmpresa" method="POST">
                    <div class="form-group">
                        <input type="text" class="form-control" name="Nome" value="<%=Cand.getNome()%>" required>
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" name="CPF_CNPJ" value="<%=Cand.getCPF_CNPJ()%>" required>
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" name="Email" value="<%=Cand.getEmail()%>">
                    </div>
                    <div class="form-group">
                        <input type="file" name="Foto">
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" name="Email" value="<%=Cand.getEmail()%>" requeried>
                    </div>
                    <div class="form-group">
                         <input type="date" class="form-control" name="Data_Nascimento" value="<%=Cand.getData_Nascimento()%>" requeried>
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" name="Senha" value="<%=Cand.getSenha()%>">
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" name="Endereco" value="<%=Cand.getEndereco()%>">
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" name="Desc_Usuario" value="<%=Cand.getDesc_Usuario()%>">
                    </div>
                    <button type="submit" class="btn btn-primary" id="EditarCandidato">Editar</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
