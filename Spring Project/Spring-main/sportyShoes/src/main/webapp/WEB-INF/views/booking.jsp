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

#fixed-button{
	position:fixed;
	bottom:20px;
	right:20px;
	background-color:green;
	color:white;
	padding:10px;
	border-radius:5px;
	cursor:pointer;
	text-decoration: none;
}
</style>
</head>
<body>
	<h1>Cart</h1>

	<table>
		<tr>
			<th>Order No</th>
			<th>Shoe Name</th>
			<th>Category</th>
			<th>Price</th>
		</tr>
		<c:forEach var="shoe" items="${reportDetails}">
			<tr>
				<td>ONO${shoe.id }</td>
				<td>${shoe.shoe.name }</td>
				<td>${shoe.category.name }
				<td>&#x20B9;${shoe.shoe.price }</td>
				
			</tr>
		</c:forEach>
	</table>

	<p>
		<a href="userHome">Back</a>
	</p>
	<a href="payments" id="fixed-button">Proceed to Buy</a>
</body>
</html>