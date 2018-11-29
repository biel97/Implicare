
<%@ page pageEncoding="UTF-8" %>
<%@page import="java.util.ArrayList"%>
<%@page import="br.cefetmg.implicare.model.domain.AreaEstudo"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formação Acadêmica</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
        <link href="css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
        <link href="css/bootstrap-theme.css" rel="stylesheet" type="text/css">
        <link href="css/style.css" rel="stylesheet" type="text/css">
    </head>
<body id="LoginForm">
    <div class="container">
        <%@include file="headerCandidato.jspf" %>
        <div class="login-form">
            <div class="main-div">
                <form action="ImplicareServlet?acao=InserirFormacaoAcademica" method="POST">
                    <div class="form-group">
                        <input type="text" class="form-control" name="Instituicao_Ensino" placeholder="Instituição de Ensino" requeried>
                    </div>
                    <div class="form-group">
                        <label for="exampleFormControlSelect1">Area de Estudo</label>
                        <select class="form-control" id="AreaEstudo" name="Cod_Area_Estudo" requeried>
                            <% 
                                ArrayList<AreaEstudo> ListaArea = (ArrayList)request.getAttribute("ListaArea");
                                for(int i = 0; i < ListaArea.size(); i++) { 
                            %>
                                <option value="<%=ListaArea.get(i).getCod_Area_Estudo()%>">
                                               <%=ListaArea.get(i).getNom_Area_Estudo()%>
                                               </option> <% } %>
                        </select>
                    </div>


                    <div class="form-group">
                        <input type="text" class="form-control" name="Atividades_Desenvolvidas" placeholder="Atividades desenvolvidas">
                    </div>
                    <div class="form-group">
                        <input type="date" class="form-control" name="Dat_Inicio" requeried>
                    </div>
                    <div class="form-group">
                        <input type="date" class="form-control" name="Dat_Termino" requeried>
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" name="Desc_Formacao_Academica" placeholder="Descrição da formação acadêmica">
                    </div>
                    <button type="submit" class="btn btn-primary" id="InserirFormacaoAcademica">Inserir Formação Acadêmica</button>
                </form>
            </div>
        </div>
    </div>
    <%@include file="footer.jspf" %>
</body>
</html>
