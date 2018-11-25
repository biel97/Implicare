<%@ page pageEncoding="UTF-8" %>
<%@page import="java.util.ArrayList"%>
<%@page import="br.cefetmg.implicare.model.domain.Cargo"%>
<%@page import="br.cefetmg.implicare.model.domain.ExperienciaProfissional"%>

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
                <%ExperienciaProfissional ExperienciaProf = (ExperienciaProfissional)request.getAttribute("ExperienciaProfissional");%>
                <form action="ImplicareServlet?acao=AlterarExperienciaProfissional&Seq_Experiencia=<%=ExperienciaProf.getSeq_Experiencia()%>" method="POST">
                    <div class="form-group">
                        <input type="text" class="form-control" id="Nom_Empresa" value="<%=ExperienciaProf.getNom_Empresa()%>" required>
                    </div>
                    <div class="form-group">
                        <label for="exampleFormControlSelect1">Cargo</label>
                        <select class="form-control" id="Cod_Cargo" name="Cod_Cargo" required>
                            <% 
                                ArrayList<Cargo> ListaCargo = (ArrayList)request.getAttribute("ListaCargo");
                                for(int i = 0; i < ListaCargo.size(); i++) { 
                                    if(ListaCargo.get(i).getCod_Cargo() == ExperienciaProf.getCod_Cargo()) {%>
                                        <option value="<%=ListaCargo.get(i).getCod_Cargo()%>" selected>
                                            <%=ListaCargo.get(i).getNom_Cargo()%>
                                        </option> 
                                    <%} else {%>
                                            <option value="<%=ListaCargo.get(i).getCod_Cargo()%>">
                                                <%=ListaCargo.get(i).getNom_Cargo()%>
                                            </option> 
                                    <%}%>
                            <% } %>
                        </select>
                    </div>
                    <div class="form-group">
                        <input type="date" class="form-control" id="Data_Inicio" value="<%=ExperienciaProf.getData_Inicio()%>" requeried>
                    </div>
                    <div class="form-group">
                        <input type="date" class="form-control" id="Data_Termino" value="<%=ExperienciaProf.getData_Termino()%>" requeried>
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" id="Desc_Experiencia_Profissional" value="<%ExperienciaProf.getDesc_Experiencia_Profissional();%>">
                    </div>
                    <button type="submit" class="btn btn-primary" id="EditarExperiênciaProfissional">Editar Experiência Profissional</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>