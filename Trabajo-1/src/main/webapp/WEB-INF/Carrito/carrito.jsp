	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	    pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<!DOCTYPE html>
	<html lang="en">
	
	<head>
	    <meta charset="UTF-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <title>Carrito</title>
	    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	</head>
	
	<body>
	<jsp:include page='../template/navbar.jsp'/>
		<div class="container">
	    	<br>
	    	<hr>
	    	<h2> Filler, falta linkear las ventas ya presentes</h2>
	    	<table class="table">
	    	<thread>
	    	<tr>
	    	    <th scope="col">#</th>
	      		<th scope="col">Nombre</th>
	      		<th scope="col">Apellido</th>
	      		<th scope="col">Limite</th>
	      		<th scope="col">Codigo POSTAL</th>
	
	      	<tr></tr>
	      	</tr>
	      	</thread>
	      	<tbody>
	      		<c:forEach items="${listaUsuarios}" var='usuario'>
	   			<tr>
	      			<th scope="row">${usuario.getId()}</th>
	      			<td>${usuario.getNombre()}</td>
	      			<td>${usuario.getApellido()}</td>
	      			<td>${usuario.getLimite()}</td>
	      			<td>${usuario.getCodigoPostal()}</td>       		
	    		</td>
	    		</tr>
	    		</c:forEach>
	    		<div></div>
	    		<tr></tr>
	    		<tr></tr>
	    </div>
	
	</body>
	
	</html>
