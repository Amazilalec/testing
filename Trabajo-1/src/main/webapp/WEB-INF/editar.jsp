<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page='template/header.jsp'/>
<body>
	<jsp:include page='template/navbar.jsp'/>
	<div class="container">
		<form:form method="post" action="/usuarios/update/${usuario.id}" modelAttribute="usuario">
			<input type="hidden" name="_method" value="put">
			<form:label path="nombre" class="col-sm-2 col-form-label">Nombre:</form:label>
			<form:input type="text" path="nombre" class="form-control"/>
			<br>
			<form:label path="apellido" class="col-sm-2 col-form-label">Apellido:</form:label>
			<form:input type="text" path="apellido" class="form-control"/>
			<br>
			<form:label path="limite" class="col-sm-2 col-form-label">Limite:</form:label>
			<form:input type="text" path="limite" class="form-control"/>
			<br>
			<form:label path="codigoPostal" class="col-sm-2 col-form-label">Código Postal:</form:label>
			<form:input type="text" path="codigoPostal" class="form-control"/>
			<br>
			<a href="/usuario" class="btn btn-success" role="button" data-bs-toggle="button">Volver</a>
			<input class="btn btn-warning" type="submit" value="Editar">

		</form:form>
	</div>
</body>

</html>