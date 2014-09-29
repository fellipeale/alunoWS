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
			<h1>Busca por NR</h1>
		</div>
		<div align="center">
			<form action="${pageContext.request.contextPath}/buscarAlunoNR" method="get">
				<input type="text" id="nr" name="nr" />
				<input type="submit" value="Buscar"/>		
			</form>
		</div>
    	
	</body>
</html>