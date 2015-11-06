<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Cadastrar Usuário</h1>
		
	<form action="CadastraUsuarioServlet" method="post">
		<p>
			<label for="nome">Nome</label>
			<input type="text" id="nome" name="attr_nome" required autofocus />
		</p>
		<p>
			<label for="login">Login</label>
			<input type="text" id="login" name="attr_login" required/>
		</p>
		<p>
			<label for="senha">Senha</label>
			<input type="password" id="senha" name="attr_senha" required/>
		</p>
		<input type="submit" value="Enviar"/>
	</form>
	<br>
	<form action="index.html" method="post">
		<input type="submit" value="Voltar"/>
	</form>
</body>
</html>