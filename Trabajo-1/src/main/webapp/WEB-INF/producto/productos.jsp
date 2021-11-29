<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page='../template/header.jsp'/>

<body>
<jsp:include page='../template/navbar.jsp'/>
<br>
<h2 style="text-align:center">Administracion de productos</h2>
<hr>
<br>
    <div class="container">
	<h4>Agregar nuevo producto</h4>
	<br>
        <form:form method="post" action="/productos/login" modelAttribute="producto">
            <form:label path="nombre">Nombre:</form:label>
            <form:input type="text" path="nombre"/> <br>
            <form:label path="precio">Precio:</form:label>
            <form:input type="double" path="precio"/> <br>
            <form:label path="categoria">Categoria:</form:label>
            <form:input type="text" path="categoria"/> <br>
            <form:label path="caracteristica">Caracteristicas:</form:label>
            <form:input type="text" path="caracteristica"/> <br>
            <input type="button" value="Limpiar">
        	<input type="submit" value="Submit">       
        </form:form>   
        <br>
        <hr> 
        <h2>Editar productos registrados</h2>  
        <table class="table">
 		 <thead>
    	<tr>
      <th scope="col">#</th>
      <th scope="col">Nombre</th>
      <th scope="col">Precio</th>
      <th scope="col">Categoria</th>
      <th scope="col">Caracteristicas</th>
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
      			<td>${producto.getCategoria()}</td>
      			<td>${producto.getCaracteristica()}</td>
      			<td>
      			<a href="/productos/${producto.getId()}/editar" class="btn btn-primary" role="button" data-bs-toggle="button">Modificar</a>
      			<form action="/productos/eliminar" method="get">
      				<input type="hidden" name="id" value="${producto.getId()}">
      				<input class="btn btn-danger" type="submit" value="X">
      			</form>
      			</td>
    		</tr>
    </c:forEach>
  </tbody>
</table>

    </div>
</body>
</html>