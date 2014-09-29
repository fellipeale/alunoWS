<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Aluno Web Service Application</title>
	</head>
	<body>
		<div align="center">
			<h1>ALUNO WS</h1>
		</div>
		<div>
			<ul>
				<li>
					<a href="${pageContext.request.contextPath}/buscarAlunos">Buscar todos os alunos</a>
				</li>
				<li>
					<a href="${pageContext.request.contextPath}/buscarAlunoNR.jsp">Buscar aluno por NR</a>
				</li>
				<li>
					<a href="${pageContext.request.contextPath}/inserirAluno.jsp">Inserir novo aluno</a>
				</li>
			</ul>
		</div>
    	
	</body>
</html>