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
table {
	border-collapse: collapse;
	width: 100%;
}

td, th {
	padding: 10px;
}

tr:nth-child(even) {
	background-color: #f2f2f2;
}

th {
	background-color: #4CAF50;
	color: white;
	font-weight: bold;
}

tr:hover {
	background-color: #ddd;
}

td {
	text-align: center;
}

a {
	display: inline-block;
	background-color: #4CAF50;
	color: white;
	padding: 10px 20px;
	text-align: center;
	text-decoration: none;
	font-size: 16px;
	border-radius: 5px;
	border: none;
	cursor: pointer;
	transition: background-color 0.3s ease;
}

.button:hover {
	background-color: #3e8e41;
}

h1, h2 {
	text-align: center;
}

p {
	text-align: center;
}

.search-container{
	display:flex;
	justify-content:center;
	margin:20px;
}

input[type="search"]{
	width:300px;
	padding:10px;
	border:none;
	border-radius:5px 0 0 5px;
}
input[type="submit"]{
	background-color:#4CAF50;
	color:white;
	padding:10px 20px;
	border:none;
	border-radius:0 5px 5px 0;
	cursor:pointer;
}
input[type="submit"]:hover{
	background-color:#45a049;
}
</style>
</head>
<body>
	<h1>Users</h1>
	<div class="search-container">
	<form action="userSearch" method="post">
		<input type="search" placeholder="Search Name here" name="search" /> <input
			type="submit" value="search" />
	</form>
	</div>
	
	<table>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Email</th>
			<th>Phone</th>
			<th>Address</th>
		</tr>
		<c:forEach var="user" items="${users}">
			<tr>
				<td>${user.id }</td>
				<td>${user.name }</td>
				<td>${user.email }
				<td>${user.phone }</td>
				<td>${user.address }</td>
			</tr>
		</c:forEach>
	</table>

	<p>
		<a href="adminHome">Home</a>
	</p>
	<p>
		<a style="color: red; background-color: white; border: 1px solid red"
			href="admin">Logout</a>
</body>
</html>