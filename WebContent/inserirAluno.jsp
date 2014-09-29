<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Aluno Web Service Application</title>
	</head>
	<body>
		<div align="center">
			<h1>Inserir Aluno</h1>
		</div>
		<div align="center">
			<form action="${pageContext.request.contextPath}/inserirAluno" method="POST">
				Matricula:&nbsp;<input type="text" name="matricula" /><br/>
				Nome:&nbsp;<input type="text" name="nome" /><br/>
				CPF:&nbsp;<input type="text" name="cpf" /><br/>
				Idade:&nbsp;<input type="text" name="idade" /><br/>
				<input type="submit" value="Inserir"/>		
			</form>
		</div>
    	
	</body>
</html>