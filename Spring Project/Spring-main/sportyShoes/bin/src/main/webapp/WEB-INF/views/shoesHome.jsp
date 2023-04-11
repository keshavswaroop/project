<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page
	import="javax.security.auth.message.callback.PrivateKeyCallback.Request"%>
<%@page import="java.awt.print.Book"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="style.css" rel="stylesheet" type="text/css">
<style>

table{
	border-collapse:collapse;
	width:100%;
}

td,th{
	padding:10px;
}

tr:nth-child(even){
	background-color:#f2f2f2;
}

th{
	background-color:#4CAF50;
	color:white;
	font-weight:bold;
}

tr:hover{
	background-color:#ddd;
}

td{
	text-align:center;
}

a{
	display:inline-block;
	background-color:#4CAF50;
	color:white;
	padding:10px 20px;
	text-align:center;
	text-decoration:none;
	font-size:16px;
	border-radius:5px;
	border:none;
	cursor:pointer;
	transition:background-color 0.3s ease;
	
}

.button:hover{
	background-color:#3e8e41;
}

h1,h2{
	text-align:center;
}
p{
	text-align:center;
}
</style>
</head>
<body>
	<h1>Shoes</h1>

	<table>
		<tr>
			<th>Id</th>
			<th>Shoe Name</th>
			<th>Category</th>
			<th>Price</th>
			<th>Delete</th>
			<th>Update</th>
		</tr>
		<c:forEach var="shoe" items="${shoes}">
			<tr>
				<td>${shoe.id }</td>
				<td>${shoe.name }</td>
				<td>${shoe.category.name }
				<td>${shoe.price }</td>
				
				<td><a href="shoesUpdate?shoesid=${shoe.id }">Update</a></td>
				<td><a href="shoesDelete?shoesid=${shoe.id }">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<p>
		Insert New Shoes : <a style="padding:5px 20px 5px 20px" href="insertShoes">Insert</a>
	</p>
	<p>
		<a href="adminHome">Home</a>
	</p>
	<p> <a style="color:red;background-color:white;border:1px solid red" href="admin">Logout</a>
</body>
</html>