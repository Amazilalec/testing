<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Clientes</title>
</head>
<body>
    <div class="container">

        <form:form method="post" action="/usuarios/login" modelAttribute="usuario">
            <form:label path="nombre">Nombre:</form:label>
            <form:input type="text" path="nombre"/> <br>
            <form:label path="apellido">Apellido:</form:label>
            <form:input type="text" path="apellido"/> <br>
            <form:label path="limite">Limite:</form:label>
            <form:input type="text" path="limite"/> <br>
            <form:label path="codigoPostal">Codigo Postal:</form:label>
            <form:input type="text" path="codigoPostal"/> <br>
            <input type="button" value="Limpiar">
        	<input type="submit" value="Submit">       
        </form:form>   
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