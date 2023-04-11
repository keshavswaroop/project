<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Manage Products</h1>
	<form action="products" method="post">
		<pre>
			Name : <input type="text" name="name"/>
			Descprtion : <input type="text" name="desc"/>
			Price : <input type="text" name="price"/>
			<input type="submit" value="submit"/>
		</pre>
	</form>
	
	<ul>
		<c:forEach items="${products }" var="product">
			<li>${product.id } | ${product.name } | ${product.desc } | ${product.price }
		</c:forEach>
	</ul>
</body>
</html>