<%-- 
    Document   : GerenciarCandidatosVaga
    Created on : 22/11/2018, 02:47:36
    Author     : ADM
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.cefetmg.implicare.model.domain.Candidato"%>
<%@page import="br.cefetmg.implicare.model.domain.CandidatoVaga"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css\bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css\bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>
        <link href="css\bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css\bootstrap-theme.css" rel="stylesheet" type="text/css"/>
        <link href="css\style.css" rel="stylesheet" type="text/css"/>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <script type="text/javascript" src="js/scripts.js"></script>
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
<<<<<<< HEAD
    <div class="row">
		<div class="col-md-4 col-sm-12">
			<div class="panel panel-primary1">
				<div class="panel-heading">
					<h3 class="panel-title">Gabriel Vinicius dos Santos</h3>
					<span class="pull-right clickable"><i class="glyphicon glyphicon-chevron-up"></i></span>
				</div>
				<div class="panel-body">
				    <div class="profile-img" align="center">
                        <img src="" alt=""  width="75" height="75"/>
                    </div>
           
                        <table class="col-md-12 col-lg-12  col-sm-12 tabelinha">
                           <tbody>
                                <tr>
                                    <td>Email</td>
                                    <td>gv92769@gmail.com</td>
                                </tr>
                                <tr>
                                    <td>Data Nascimento</td>
                                    <td>02/10/1997</td>
                                </tr>
                                <tr>
                                    <td>Endereço</td>
                                    <td>ffgjfvffvghfgfhgffhfgfhdsg</td>
                                </tr>
                                <tr>
                                    <td>Descrição</td>
                                    <td>khsafjdpjkgkargbmvbkgjbt</td>
                                </tr>
                                <tr>
                                    <td>Status Candidato</td>
                                    <td>Espera</td>
                               </tr>
                            <tbody>
                        </table>
                                    <div class="row">
                        <button type="submit" class="btn-gerenciar-vaga btn btn-primary1" id="EditarVaga">Vizualizar</button>
                                    </div>
				</div>
			</div>
		</div>
		<div class="col-md-4 col-sm-12">
			<div class="panel panel-primary1">
				<div class="panel-heading">
					<h3 class="panel-title">Gabriel Vinicius dos Santos</h3>
					<span class="pull-right clickable"><i class="glyphicon glyphicon-chevron-up"></i></span>
				</div>
				<div class="panel-body">
				    <div class="profile-img" align="center">
                        <img src="" alt=""  width="75" height="75"/>
                    </div>
               
                        <table class="col-md-12 col-lg-12  col-sm-12 tabelinha">
                           <tbody>
                                <tr>
                                    <td>Email</td>
                                    <td>gv92769@gmail.com</td>
                                </tr>
                                <tr>
                                    <td>Data Nascimento</td>
                                    <td>02/10/1997</td>
                                </tr>
                                <tr>
                                    <td>Endereço</td>
                                    <td>ffgjfvffvghfgfhgffhfgfhdsg</td>
                                </tr>
                                <tr>
                                    <td>Descrição</td>
                                    <td>khsafjdpjkgkargbmvbkgjbt</td>
                                </tr>
                                <tr>
                                    <td>Status Candidato</td>
                                    <td>Espera</td>
                               </tr>
                            <tbody>
                        </table>
                        <div class="row">
                        <button type="submit" class="btn-gerenciar-vaga btn btn-primary1" id="EditarVaga">Vizualizar</button>
                                    </div>
                  
				</div>
			</div>
		</div>
	    <div class="col-md-4 col-sm-12">
			<div class="panel panel-primary1">
				<div class="panel-heading">
					<h3 class="panel-title">Gabriel Vinicius dos Santos</h3>
					<span class="pull-right clickable"><i class="glyphicon glyphicon-chevron-up"></i></span>
				</div>
				<div class="panel-body">
				    <div class="profile-img" align="center">
                        <img src="" alt=""  width="75" height="75"/>
                    </div>
               
                        <table class="col-md-12 col-lg-12  col-sm-12  tabelinha">
                           <tbody> 
                                <tr>
                                    <td>Email</td>
                                    <td>gv92769@gmail.com</td>
                                </tr>
                                <tr>
                                    <td>Data Nascimento</td>
                                    <td>02/10/1997</td>
                                </tr>
                                <tr>
                                    <td>Endereço</td>
                                    <td>ffgjfvffvghfgfhgffhfgfhdsg</td>
                                </tr>
                                <tr>
                                    <td>Descrição</td>
                                    <td>khsafjdpjkgkargbmvbkgjbt</td>
                                </tr>
                                <tr>
                                    <td>Status Candidato</td>
                                    <td>Espera</td>
                               </tr>
                            <tbody>
                        </table>
                        <div class="row">
                        <button type="submit" class="btn-gerenciar-vaga btn btn-primary1" id="EditarVaga">Vizualizar</button>
                                    </div>
                   
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-4 col-sm-12">
			<div class="panel panel-primary1">
				<div class="panel-heading">
					<h3 class="panel-title">Gabriel Vinicius dos Santos</h3>
					<span class="pull-right clickable"><i class="glyphicon glyphicon-chevron-up"></i></span>
				</div>
				<div class="panel-body">
				    <div class="profile-img" align="center">
                        <img src="" alt=""  width="75" height="75"/>
                    </div>
                
                        <table class="col-md-12 col-lg-12  col-sm-12  tabelinha">
                           <tbody>
                                <tr>
                                    <td>Email</td>
                                    <td>gv92769@gmail.com</td>
                                </tr>
                                <tr>
                                    <td>Data Nascimento</td>
                                    <td>02/10/1997</td>
                                </tr>
                                <tr>
                                    <td>Endereço</td>
                                    <td>ffgjfvffvghfgfhgffhfgfhdsg</td>
                                </tr>
                                <tr>
                                    <td>Descrição</td>
                                    <td>khsafjdpjkgkargbmvbkgjbt</td>
                                </tr>
                                <tr>
                                    <td>Status Candidato</td>
                                    <td>Espera</td>
                               </tr>
                            <tbody>
                        </table>
                        <div class="row">
                        <button type="submit" class="btn-gerenciar-vaga btn btn-primary1" id="EditarVaga">Vizualizar</button>
                                    </div>
                   
				</div>
			</div>
		</div>
		<div class="col-md-4  col-sm-12">
			<div class="panel panel-primary1">
				<div class="panel-heading">
					<h3 class="panel-title">Gabriel Vinicius dos Santos</h3>
					<span class="pull-right clickable"><i class="glyphicon glyphicon-chevron-up"></i></span>
				</div>
				<div class="panel-body">
				    <div class="profile-img" align="center">
                        <img src="" alt=""  width="75" height="75"/>
                    </div>
          
                        <table class="col-md-12 col-lg-12  col-sm-12 tabelinha">
                           <tbody>
                                <tr>
                                    <td>Email</td>
                                    <td>gv92769@gmail.com</td>
                                </tr>
                                <tr>
                                    <td>Data Nascimento</td>
                                    <td>02/10/1997</td>
                                </tr>
                                <tr>
                                    <td>Endereço</td>
                                    <td>ffgjfvffvghfgfhgffhfgfhdsg</td>
                                </tr>
                                <tr>
                                    <td>Descrição</td>
                                    <td>khsafjdpjkgkargbmvbkgjbt</td>
                                </tr>
                                <tr>
                                    <td>Status Candidato</td>
                                    <td>Espera</td>
                               </tr>
                            <tbody>
                        </table>
                        <div class="row">
                        <button type="submit" class="btn-gerenciar-vaga btn btn-primary1" id="EditarVaga">Vizualizar</button>
                                    </div>
                  
				</div>
			</div>
		</div>
	    <div class="col-md-4 col-sm-12">
			<div class="panel panel-primary1">
				<div class="panel-heading">
					<h3 class="panel-title">Gabriel Vinicius dos Santos</h3>
					<span class="pull-right clickable"><i class="glyphicon glyphicon-chevron-up"></i></span>
				</div>
				<div class="panel-body">
				    <div class="profile-img">
                        <img src="" alt=""  width="75" height="75"/>
                    </div>
                  
                        <table class="col-md-12 col-lg-12 col-sm-12  tabelinha">
                           <tbody>
                                <tr>
                                    <td>Email</td>
                                    <td>gv92769@gmail.com</td>
                                </tr>
                                <tr>
                                    <td>Data Nascimento</td>
                                    <td>02/10/1997</td>
                                </tr>
                                <tr>
                                    <td>Endereço</td>
                                    <td>ffgjfvffvghfgfhgffhfgfhdsg</td>
                                </tr>
                                <tr>
                                    <td>Descrição</td>
                                    <td>khsafjdpjkgkargbmvbkgjbt</td>
                                </tr>
                                <tr>
                                    <td>Status Candidato</td>
                                    <td>Espera</td>
                               </tr>
                            <tbody>
                        </table>
                        <div class="row">
                        <button type="submit" class="btn-gerenciar-vaga btn btn-primary1" id="EditarVaga">Vizualizar</button>
                                    </div>
                 
				</div>
			</div>
		</div>
	</div>
</div>
=======
            <%ArrayList<Candidato> ListaCandidato = (ArrayList<Candidato>)request.getAttribute("ListaCandidato");
            ArrayList<CandidatoVaga> ListaCandidatoVaga = (ArrayList<CandidatoVaga>)request.getAttribute("ListaCandidatoVaga");
            for(int i = 0; i < ListaCandidato.size(); i++) { 
                if(i%3 == 0){%>
                    <div class="row">
                <%}%>
                    <div class="col-md-4">
                        <div class="panel panel-primary1">
                            <div class="panel-heading">
                                <h3 class="panel-title"><%=ListaCandidato.get(i).getNome()%></h3>
                                <span class="pull-right clickable"><i class="glyphicon glyphicon-chevron-up"></i></span>
                            </div>
                            <div class="panel-body">
                                <div class="profile-img" align="center">
                                    <img src="<=%ListaCandidato.get(i).getFoto()%>" alt=""  width="75" height="75"/>
                                </div>
                                <table class="col-md-12 col-lg-12">
                                    <tbody>
                                        <tr>
                                            <td>Email</td>
                                            <td><%=ListaCandidato.get(i).getEmail()%></td>
                                        </tr>
                                        <tr>
                                            <td>Data Nascimento</td>
                                            <td><%=ListaCandidato.get(i).getData_Nascimento()%></td>
                                        </tr>
                                        <tr>
                                            <td>Endereço</td>
                                            <td><%=ListaCandidato.get(i).getEndereco()%></td>
                                        </tr>
                                        <tr>
                                            <td>Descrição</td>
                                            <td><%=ListaCandidato.get(i).getDesc_Usuario()%></td>
                                        </tr>
                                        <tr>
                                            <td>Status Candidato</td>
                                            <%if(ListaCandidatoVaga.get(i).getStatus_Candidato() == "E"){%><td>Espera</td><%}%>
                                            <%if(ListaCandidatoVaga.get(i).getStatus_Candidato() == "A"){%><td>Aceito</td><%}%>
                                            <%if(ListaCandidatoVaga.get(i).getStatus_Candidato() == "R"){%><td>Rejeitado</td><%}%>
                                       </tr>
                                    <tbody>
                                </table>
                                <div class="row">
                                    <button type="submit" class="btn-gerenciar-vaga btn btn-primary1" id="EditarVaga" href="ImplicareServlet?acao=PerfilUsuarioCandidato&CPF=<%=ListaCandidato.get(i).getCPF_CNPJ()%>">Vizualizar</button>
                                </div>
                            </div>
                        </div>
                    </div>
                if(i%3 == 0){%>
                    </div>
                <%}
            }%>
        </div>
>>>>>>> 78a1a319ac3b62b33a95ee4cbe3796e1d9ac38dc
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
    </body>
</html>
