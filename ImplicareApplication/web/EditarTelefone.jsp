<%@ page pageEncoding="UTF-8" %>
<%@page import="br.cefetmg.implicare.model.domain.Telefone"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Telefone</title>
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
                <%Telefone Tel = (Telefone)request.getAttribute("Tel");%>
                <form action="ImplicareServlet?acao=AlterarTelefone&Seq_Telefone<%=Tel.getSeq_Telefone()%>" method="POST">
                    <div class="form-group">
                        <input type="number" class="form-control" name="Num_Telefone" value="<%=Tel.getNum_Telefone()%>" requeried>
                    </div>
                    <div class="form-group">
                        <label for="exampleFormControlSelect1">Area de Estudo</label>
                        <select class="form-control" id="Tipo_Telefone" name="Tipo_Telefone" requeried>
                            <%if(Tel.getTipo_Telefone() == "C") {%>
                                <option value="C" selected>Telefone Comercial</option> 
                            <%}else {%>
                                <option value="C">Telefone Comercial</option> 
                            <%}
                             if(Tel.getTipo_Telefone() == "F") {%>
                                <option value="F" selected>Telefone Fixo</option>
                            <%} else {%>
                                    <option value="F">Telefone Fixo</option>
                            <% }
                             if(Tel.getTipo_Telefone() == "M") {%>
                                <option value="M" selected>Telefone Móvel</option>
                            <%} else {%>
                                <option value="M" selected>Telefone Móvel</option>
                            <% }%>
                        </select>
                    </div>
                    <div class="form-group">
                        <input type="number" class="form-control" name="DDD" value="<%=Tel.getDDD()%>" requeried>
                    </div>
                    <div class="form-group">
                        <input type="number" class="form-control" name="Ramal" value="<%=Tel.getRamal()%>" >
                    </div>
                    <button type="submit" class="btn btn-primary" id="EditarTelefone">Editar Telefone</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>