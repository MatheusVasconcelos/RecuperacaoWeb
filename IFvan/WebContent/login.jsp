<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="Login.do" method="post"> 
		Nome <input type="text" name="nome" size="30" maxlength="100"> 
		<br> 
		Senha  <input type="text" name="senha" size="30" maxlength="100"> 
		<br>
		<input type="submit" name="login" size="30" maxlength"80">
	</form>
	<form action="Cadastro.do" method="post">
		Nome: <input type="text" name="nome"><br>
		Idade: <input type="text" name="idade"><br>
		CPF: <input type="text" name="cpf"><br>
		Sexo: <input type="text" name="sexo"><br>
		Ocupacao: <input type="text" name="ocupacao"><br>
		Senha: <input type="text" name="senha"><br>
		<input type="submit" name="cadastrar">
	</form>
</body>
</html>