<%@ page pageEncoding="UTF-8" %>
<%@page import="java.util.ArrayList"%>
<%@page import="br.cefetmg.implicare.model.domain.AreaEstudo"%>
<%@page import="br.cefetmg.implicare.model.domain.FormacaoAcademica"%>

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
                <%FormacaoAcademica FormAcad = (FormacaoAcademica)request.getAttribute("FormAcad");%>
                <form action="ImplicareServlet?acao=AlterarFormacaoAcademica&Seq_Formacao=<%=FormAcad.getSeq_Formacao()%>" method="POST">
                    <div class="form-group">
                        <input type="text" class="form-control" id="Instituicao_Ensino" value="<%=FormAcad.getInstituicao_Ensino()%>" requeried>
                    </div>
                    <div class="form-group">
                        <label for="exampleFormControlSelect1">Area de Estudo</label>
                        <select class="form-control" id="AreaEstudo" name="Cod_Area_Estudo" requeried>
                            <% 
                                ArrayList<AreaEstudo> ListaArea = (ArrayList)request.getAttribute("ListaArea");
                                for(int i = 0; i < ListaArea.size(); i++) { 
                                    if(ListaArea.get(i).getCod_Area_Estudo() == FormAcad.getCod_Area_Estudo()) {
                            %>
                                        <option value="<%=ListaArea.get(i).getCod_Area_Estudo()%>" selected>
                                            <%=ListaArea.get(i).getNom_Area_Estudo()%>
                                        </option> 
                                 <% } else { %>
                                        <option value="<%=ListaArea.get(i).getCod_Area_Estudo()%>">
                                            <%=ListaArea.get(i).getNom_Area_Estudo()%>
                                        </option>
                                    <% }
                                } %>
                        </select>
                    </div>


                    <div class="form-group">
                        <input type="text" class="form-control" id="Atividades_Desenvolvidas" value="<%=FormAcad.getAtividades_Desenvolvidas()%>">
                    </div>
                    <div class="form-group">
                        <input type="date" class="form-control" id="Dat_Inicio" value="<%=FormAcad.getData_Inicio()%>" requeried>
                    </div>
                    <div class="form-group">
                        <input type="date" class="form-control" id="Dat_Termino" value="<%=FormAcad.getData_Termino()%>" requeried>
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" id="Desc_Formacao_Academica" value="<%=FormAcad.getDesc_Formacao_Academica()%>">
                    </div>
                    <button type="submit" class="btn btn-primary" id="EditarFormacaoAcademica">Editar Formação Acadêmica</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>