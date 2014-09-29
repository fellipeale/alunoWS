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
			<h1>Buscar Aluno - Resultado</h1>
		</div>
		<div align="center">
			<table border="1">
				<tr>
					<th>Matricula</th>
					<th>Nome</th>
					<th>CPF</th>
				</tr>
				<c:forEach var="aluno" items="${alunos}">
					<tr>
						<td>${aluno.matricula}</td>
						<td>${aluno.nome}</td>
						<td>${aluno.cpf}</td>
						<td><a href="">Visualizar</a></td>
						<td><a href="">Excluir</a></td>
					</tr>
				</c:forEach>
			</table>
			
		</div>
    	
	</body>
</html>