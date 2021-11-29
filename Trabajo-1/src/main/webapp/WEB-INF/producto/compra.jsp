<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page='../template/header.jsp'/>
<body>
	<jsp:include page='../template/navbar.jsp'/>
	<div class="container">
		<form:form method="post" action="/productos/listaproductos/comprar/finalizar" modelAttribute="venta">
			<input type="hidden" name="_method" value="put">
			<form:label path="detalle" class="col-sm-2 col-form-label">Fecha de Entrega:</form:label>
			<form:input type="text" path="detalle" class="form-control"/>
			<br>
			<form:select path="producto">
					<c:forEach items="${productoSeleccionado}" var="producto" >
						<form:option value="${producto.getId()}">
							${producto.getNombre()} ${producto.getPrecio()}
				     	</form:option>
					</c:forEach>
			</form:select>
			
			<a href="/productos/listaproductos" class="btn btn-success" role="button" data-bs-toggle="button">Volver</a>
			<input type="submit" value="Confirmar">  

		</form:form>
		
		 <table class="table">
 		 <thead>
    	<tr>
      <th scope="col">#</th>
      <th scope="col">Total</th>
      <th scope="col">Detalle</th>
      <th scope="col-2">Fecha</th>
      <th scope="col-2">Acciones</th>
      <th></th>
    	</tr>
  </thead>
  		<tbody>
  			<c:forEach items="${listaVentas}" var='venta'>
   			<tr>
      			<th scope="row">${venta.getId()}</th>
      			<td>${venta.producto.getPrecio()}</td>
      			<td>${venta.getDetalle()}</td>
      			<td>${venta.getFecha()}</td>
      			<td>
      			<a href="/ventas/${venta.getId()}/editar" class="btn btn-primary" role="button" data-bs-toggle="button">Modificar</a>
      			<form action="/ventas/eliminar" method="get">
      				<input type="hidden" name="id" value="${venta.getId()}">
      				<input type="submit" value="Eliminar compra">
      			</form>
      			</td>
    		</tr>
    </c:forEach>
  </tbody>
</table>
	</div>
</body>

</html>