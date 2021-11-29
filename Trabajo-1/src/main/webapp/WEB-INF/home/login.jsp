<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page='../template/header.jsp'/>
<body>
	<div class="container">
		<form:form method="post" action="/usuarios" modelAttribute="usuario">
			<input type="hidden" name="_method" value="put">
			<form:label path="nombreUsuario" class="col-sm-2 col-form-label">Nombre de usuario:</form:label>
			<form:input type="text" path="nombreUsuario" class="form-control"/>
			<br>
			<form:label path="password" class="col-sm-2 col-form-label">Password:</form:label>
			<form:input type="text" path="password" class="form-control"/>
			<br>
			<a href="" class="btn btn-success" role="button" data-bs-toggle="button">Volver</a>
			<input class="btn btn-warning" type="submit" value="Login">

		</form:form>
	</div>
</body>

</html>