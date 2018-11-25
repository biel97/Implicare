<%@ page pageEncoding="UTF-8" %>
<%@page import="java.util.ArrayList"%>
<%@page import="br.cefetmg.implicare.model.domain.Cargo"%>
<%@page import="br.cefetmg.implicare.model.domain.Vaga"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Experiência Profissional</title>
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
                <%Vaga Vaga = (Vaga)request.getAttribute("Vaga");%>
                <form action="ImplicareServlet?acao=AlterarVaga&Seq_Vaga=<%=Vaga.getSeq_Vaga()%>" method="POST">
                    <div class="form-group">
                        <label for="exampleFormControlSelect1">Cargo</label>
                        <select class="form-control" id="Cod_Cargo" name="Cod_Cargo" requeried>
                            <% 
                                ArrayList<Cargo> ListaCargo = (ArrayList)request.getAttribute("ListaCargo");
                                for(int i = 0; i < ListaCargo.size(); i++) { 
                                    if(ListaCargo.get(i).getCod_Cargo() == Vaga.getCod_Cargo()) {%>      
                                        <option value="<%=ListaCargo.get(i).getCod_Cargo()%>" selected>
                                            <%=ListaCargo.get(i).getNom_Cargo()%>
                                        </option> 
                                    <% } else { %>
                                            <option value="<%=ListaCargo.get(i).getCod_Cargo()%>">
                                                <%=ListaCargo.get(i).getNom_Cargo()%>
                                            </option>
                                        <%}
                                }%>
                        </select>
                    </div>
                    <div class="form-group">
                        <input type="date" class="form-control" id="Dat_Publicacao" value="<%=Vaga.getDat_Publicacao()%>" requeried>
                    </div>

                    <div class="form-group">
                        <input type="number" class="form-control" id="Num_Vagas" value="<%=Vaga.getNum_Vagas()%>">
                    </div>
                    
                    <div class="form-group">
                        <input type="number" class="form-control" id="Carga_Horaria" value="<%Vaga.getCarga_Horaria();%>">
                    </div>
                    <div class="form-group">
                        <input type="number" class="form-control" id="Remuneracao" value="<%=Vaga.getRemuneracao()%>">
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" id="Desc_Vaga" value="<%=Vaga.getDesc_Vaga()%>">
                    </div>
                    <button type="submit" class="btn btn-primary" id="EditarVaga">Editar Vaga</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
