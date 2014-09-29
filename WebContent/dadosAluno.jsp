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
			<h1>Dados do Aluno</h1>
		</div>
		<jsp:useBean id="aluno" class="br.com.ufpr.ees.soa.alunows.model.Aluno" scope="request" />
		<div align="center">
			${resultMsg}
			<br/>
			<form action="${pageContext.request.contextPath}/inserirAluno" method="POST">
				Matricula:&nbsp;${aluno.matricula}<br/>
				Nome:&nbsp;${aluno.nome}<br/>
				CPF:&nbsp;${aluno.cpf}<br/>
				Idade:&nbsp;${aluno.idade}<br/><br/>
				<a href="/index.jsp">Inicio</a>		
			</form>
		</div>
    	
	</body>
</html>