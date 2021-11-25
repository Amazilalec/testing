<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Productos</title>
</head>
<body>
    <div class="container">

        <form:form method="post" action="/productos/login" modelAttribute="producto">
            <form:label path="nombre">Nombre:</form:label>
            <form:input type="text" path="nombre"/> <br>
            <form:label path="precio">Precio:</form:label>
            <form:input type="text" path="precio"/> <br>
            <input type="button" value="Limpiar">
        	<input type="submit" value="Submit">       
        </form:form>   
        <br>
        <hr> 
        <h2>Editar</h2>  
        <table class="table">
 		 <thead>
    	<tr>
      <th scope="col">#</th>
      <th scope="col">Nombre</th>
      <th scope="col">Precio</th>
      <th scope="col-2">Acciones</th>
      <th></th>
    	</tr>
  </thead>
  		<tbody>
  			<c:forEach items="${listaProductos}" var='producto'>
   			<tr>
      			<th scope="row">${producto.getId()}</th>
      			<td>${producto.getNombre()}</td>
      			<td>${producto.getPrecio()}</td>
      			<td>
      			<a href="/productos/${producto.getId()}/editar" class="btn btn-primary" role="button" data-bs-toggle="button">Modificar</a>
      			<form action="/productos/eliminar" method="get">
      				<input type="hidden" name="id" value="${producto.getId()}">
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