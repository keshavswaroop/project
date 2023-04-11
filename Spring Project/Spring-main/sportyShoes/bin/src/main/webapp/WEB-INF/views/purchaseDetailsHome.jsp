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
<title>Shoe Shopping Page</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" type="text/css" href="style.css" />
<style>


body {
	font-family: Arial, sans-serif;
}

header {
	background-color: #333;
	color: #fff;
	display: flex;
	justify-content: space-between;
	align-items: center;
	padding: 10px;
}

.user-details {
	text-align: right;
}

main {
	max-width: 800px;
	margin: 20px auto;
	padding: 0 10px;
}

.filters {
	display: flex;
	justify-content: space-between;
	align-items: center;
	margin-bottom: 20px;
}

.filters label {
	margin-right: 10px;
}

.filters select {
	padding: 5px;
	border-radius: 5px;
	border: none;
	outline: none;
}

.filters .button {
	padding: 5px 10px;
	border-radius: 5px;
	border: 1px solid #fff;
	background-color: #333;
	color: #fff;
	cursor: pointer;
}

.filters .button:hover {
	background-color: #fff;
	color: #333;
	border: 1px solid #333;
}

.shoes {
	display: grid;
	grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
	gap: 20px;
}

.shoe {
	border: 1px solid #ccc;
	padding: 10px;
	text-align: center;
}

.shoe h2 {
	font-size: 24px;
	margin-bottom: 10px;
}

.shoe p {
	margin-bottom: 5px;
}

.select-btn {
	padding: 5px 10px;
	border-radius: 5px;
	border: none;
	background-color: #333;
	color: #fff;
	cursor: pointer;
}

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
</style>
</head>
<body>
	<h1>Purcase Report</h1>
	<main>
		<form action="filterPurchase" method="post">
			<div class="filters">

				<label for="category">Category:</label> <select id="category"
					name="category" required>
					<option value="all">All</option>
					<c:forEach var="category" items="${category}">
						<option>${category.name }</option>
					</c:forEach>
				</select> <label for="date">Date:</label> <select id="date" name="date"
					required>
					<option value="all">All</option>
					<c:forEach var="date" items="${date1}">
						<option>${date }</option>
					</c:forEach>
				</select> <input type="submit" id="filter-btn" class="button"
					value="Apply Filters" />
			</div>
		</form>

		<table>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Email</th>
				<th>Shoes</th>
				<th>Category</th>
				<th>Price</th>
				<th>Date</th>
			</tr>
			<c:forEach var="purchase" items="${purchases}">
				<tr>
					<td>${purchase.id }</td>
					<td>${purchase.user.name }</td>
					<td>${purchase.user.email }</td>
					<td>${purchase.shoe.name }
					<td>${purchase.category.name }
					<td>${purchase.shoe.price }</td>
					<td>${purchase.date }</td>
				</tr>
			</c:forEach>
		</table>

		<p>
			<a href="adminHome">Home</a>
		</p>
		<p>
			<a style="color: red; background-color: white; border: 1px solid red"
				href="admin">Logout</a>
	</main>
</body>
</html>