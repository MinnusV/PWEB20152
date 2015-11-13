<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="br.edu.nassau.pweb.dao.DaoUsuario"%>
<%@ page import="br.edu.nassau.pweb.dao.DaoUsuarioImpl"%>
<%@ page import="br.edu.nassau.pweb.model.Usuario"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Lista de Usuarios</title>
</head>
<body>
	<h1>LISTA DE USUARIOS</h1>
	
	<table>
		<tr>
			<td>ID</td>
			<td>Nome</td>
			<td>Login</td>
			<td>Oper.</td>			
		</tr>
			<%
				DaoUsuario daoUsuario = new DaoUsuarioImpl();
				List<Usuario> lista = daoUsuario.list();
				for(Usuario us : lista){
			%>
		<tr>
			<td> <%=us.getId()%> </td>
			<td> <%=us.getNome()%> </td>
			<td> <%=us.getLogin()%> </td>
			<td>
				<a href="RemoveUsuarioServlet?id=<%=us.getId()%>">X</a> 
				<a href="AtualizaUsuarioServlet?id=<%=us.getId() %>">?</a>
			</td>
		</tr>
		<%
				}
		%>
	</table>
	<br>
	<form action="index.html" method="post">
		<input type="submit" value="Voltar"/>
	</form>
</body>
</html>