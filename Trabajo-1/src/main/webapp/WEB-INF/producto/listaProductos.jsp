<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page='../template/header.jsp'/>

<body>
<jsp:include page='../template/navbar.jsp'/>
<br>
<h2 style="text-align:center">Lista de productos</h2>
<hr>
<br>
<div class="container">
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
      			<form action="/productos/listaproductos/comprar" method="get">
      			<input type="hidden" name="id" value="${producto.getId()}">
      			<input class="btn btn-danger" type="submit" value="Agregar al Carro">
      			</td>
    		</tr>
    </c:forEach>
  </tbody>
</table>
</div>
<jsp:include page='../template/footer.jsp'/>
</body>
</html>