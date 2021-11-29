<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html xmlns:th="http://www.thymeLeaf.org">
<jsp:include page='../template/header.jsp'/>

<body>
<jsp:include page='../template/navbar.jsp'/>
<div class="container mt-5">
	<div class="row justify-content-center">
	<div class="col-md-8">
<h2>Buscador de productos</h2>
	<hr>
	 <form:form method="post" action="producto/busquedacategorias/categoria" modelAttribute="producto">
	 		<form:label path="categoria">Categoria:</form:label>
            <form:input type="text" path="categoria"/>
            <button type="submit" class="btn btn-success mt-4 mb-4">Buscar por Categoria</button>
            <br>
	 </form:form>
	 <hr>
	 <form:form method="post" action="producto/busquedacategorias/nombre" modelAttribute="producto">
	 		<form:label path="nombre">Nombre:  </form:label>
            <form:input type="text" path="nombre"/> 
            <button type="submit" class="btn btn-success mt-4 mb-4">Buscar por Nombre</button>
            <br>
	 </form:form>
	<!-- 
 	<form th:action="@{/categoria}" th:object="${producto}" method="get">
 		<input type="text" th:field="*{categoria}" class="form-control col-md-4"	 />
 		<button type="submit" class="btn btn-success mt-4 mb-4">buscar</button>
 	</form>  -->
 	<table class="table">
 	
 		<tbody>
 			<c:forEach items="${productoPorCategoria}" var='producto'>
   			<tr>
      			<th scope="row">${producto.getId()}</th>
      			<td>${producto.getNombre()}</td>
      			<td>${producto.getPrecio()}</td>
      			<td>${producto.getCategoria()}</td>
      			<td>${producto.getCaracteristica()}</td>
      			<td>
      			</td>
    		</tr>
    </c:forEach>
 		</tbody>
 		<tbody>
 			<c:forEach items="${productoPorNombre}" var='producto'>
   			<tr>
      			<th scope="row">${producto.getId()}</th>
      			<td>${producto.getNombre()}</td>
      			<td>${producto.getPrecio()}</td>
      			<td>${producto.getCategoria()}</td>
      			<td>${producto.getCaracteristica()}</td>
      			<td>
      			</td>
    		</tr>
    </c:forEach>
 		</tbody>
 	</table>
</div>
<jsp:include page='../template/footer.jsp'/>
</body>
</html>