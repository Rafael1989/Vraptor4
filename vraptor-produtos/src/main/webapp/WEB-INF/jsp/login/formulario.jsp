<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="../bootstrap/css/bootstrap.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Formulário de login</title>
</head>
<body>
	<div class="container">
		<form class="form-signin" method="post" action="<c:url value="/login/autentica"/>">
			<h2 class="form-signin-heading">Faça login para acessar o vraptor-produtos</h2>
			<input type="text" class="form-control" name="usuario.nome" placeholder="Nome" />
			<input type="password" class="form-control" name="usuario.senha" placeholder="Senha"/>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
		</form>
		<c:if test="${not empty errors}">
			<div class="alert alert-danger">
				<c:forEach var="error" items="${errors}">
					${error.message}
				</c:forEach>
			</div>
		</c:if>
	</div>
</body>
</html>