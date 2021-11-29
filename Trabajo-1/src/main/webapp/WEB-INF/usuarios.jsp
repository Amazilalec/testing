<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page='template/header.jsp'/>
<body>
	<jsp:include page='template/navbar.jsp'/>
    <div class="container">
	<h1 style="text-align:center">Registro Usuarios</h1>
	<hr>
	<div align="center">
        <form:form method="post" action="/usuarios/login" modelAttribute="usuario">
            <form:label path="nombre">Nombre:</form:label>
            <form:input type="text" path="nombre"/> <br>
            <form:label path="apellido">Apellido:</form:label>
            <form:input type="text" path="apellido"/> <br>
            <form:label path="limite">Limite:</form:label>
            <form:input type="text" path="limite"/> <br>
            <form:label path="codigoPostal">Codigo Postal:</form:label>
            <form:input type="text" path="codigoPostal"/> <br>
            <form:label path="nombreUsuario">Nombre del Usuario:</form:label>
            <form:input type="text" path="nombreUsuario"/> <br>
            <form:label path="password">Contraseña del Usuario:</form:label>
            <form:input type="text" path="password"/> <br>
            <hr>
            <input type="button" value="Limpiar">
        	<input type="submit" value="Submit">       
        </form:form> 
        </div>  
        <br>
        <hr> 
        <h2>Añadir Usuarios</h2>  
        <table class="table">
 		 <thead>
    	<tr>
      <th scope="col">#</th>
      <th scope="col">Nombre</th>
      <th scope="col">Apellido</th>
      <th scope="col">Limite</th>
      <th scope="col">Codigo POSTAL</th>
      <th scope="col-2">Acciones</th>
      <th></th>
    	</tr>
  </thead>
  		<tbody>
  			<c:forEach items="${listaUsuarios}" var='usuario'>
   			<tr>
      			<th scope="row">${usuario.getId()}</th>
      			<td>${usuario.getNombre()}</td>
      			<td>${usuario.getApellido()}</td>
      			<td>${usuario.getLimite()}</td>
      			<td>${usuario.getCodigoPostal()}</td>
      			<td>
      			<a href="/usuarios/${usuario.getId()}/editar" class="btn btn-primary" role="button" data-bs-toggle="button">Modificar</a>
      			<form action="/usuarios/eliminar" method="get">
      				<input type="hidden" name="id" value="${usuario.getId()}">
      				<input type="submit" value="X">
      			</form>
      			</td>
    		</tr>
    </c:forEach>
  </tbody>
</table>

    </div>
</body>
</html>