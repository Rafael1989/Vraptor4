<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="../bootstrap/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="../base.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Formulário de produtos</title>
</head>
<body>
	<div class="container">
		<h1>Formulário de produtos</h1>
		<form method="post" action="<c:url value="/produto/adiciona"/>">
			Nome: <input class="form-control" type="text" name="produto.nome" value="${produto.nome}"/>
			Valor: <input class="form-control" type="text" name="produto.valor" value="${produto.valor}"/>
			Quantidade:<input class="form-control" type="text" name="produto.quantidade" value="${produto.quantidade}"/>
			<input type="submit" class="btn btn-primary" value="Adicionar"/>
		</form>
	</div>
</body>
</html>