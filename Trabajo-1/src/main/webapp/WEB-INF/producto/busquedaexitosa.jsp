<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page='../template/header.jsp'/>

<body>
<jsp:include page='../template/navbar.jsp'/>
<div class="container">
        <table class="table">
 		 <thead>
    	<tr>
      <th scope="col">#</th>
      <th scope="col">Nombre</th>
      <th scope="col">Precio</th>
      <th scope="col">Categoria</th>
      <th scope="col">Caracteristicas</th>
      <th></th>
    	</tr>
  </thead>
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