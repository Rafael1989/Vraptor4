<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../bootstrap/css/bootstrap.css">
<title>Lista de produtos</title>
</head>
<body>
	<div class="container">
		<h1>Lista de produtos do ${usuarioLogado.usuario.nome}</h1>
		<table class="table table-stripped table-hover table-bordered">
			<thead>
				<tr>
					<th>Nome</th>
					<th>Valor</th>
					<th>Quantidade</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${produtoList}" var="produto">
					<tr>
						<td>${produto.nome}</td>
						<td>${produto.valor}</td>
						<td>${produto.quantidade}</td>
						<td><a class="btn btn-primary" href="<c:url value="/produto/remove?produto.id=${produto.id}"/>">Remover</a></td>
						<td><a href="<c:url value="/produto/pedi?produto.nome=${produto.nome}"/>">Pedir</a>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a class="btn btn-primary" href="<c:url value="/produto/formulario"/>">Adicionar</a>
		<a class="btn btn-primary" href="<c:url value="/produto/listaXML"/>">Listar em formato XML</a>
		<c:if test="${not empty mensagem}">
			<div class="alert alert-success">${mensagem}</div>
		</c:if>
	</div>
</body>
</html>