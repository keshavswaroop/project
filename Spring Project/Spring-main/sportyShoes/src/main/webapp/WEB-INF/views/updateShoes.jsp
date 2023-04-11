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
<link href="form.css" rel="stylesheet" type="text/css">
<style>

@charset "ISO-8859-1";
body{
	margin:0px;
	padding:0px;
	background-color=#666;
}
form{
	width:300px;
	margin:0 auto;
	padding : 20px;
	border:1px solid #ccc;
	border-radius:5px;
	text-align:center;
}



label{
	font-weight:bold;
	margin-bottom:10px;
	margin-right:10px
}

label,input[type="text"]{
	display:inline-block;
	vertical-align:middle;
}

input[type="text"],
input[type="number"],
input[type="date"],
input[type="password"],
select{
	width:93%;
	padding:10px;
	margin-bottom: 15px ;
	border:1px solid #ccc;
	border-radius:3px;
	
}

select{
	height:40px
}

input[type="submit"]{
	background-color:#4CAF50;
	color:white;
	padding:10px 20px;
	border:none;
	border-radius:3px;
	cursor:pointer;
	margin-top:20px;
}

input[type="submit"]:hover,
input[type="submit"]:focus {
	background-color:#3e3e41;
}

h1{
	text-align: center;
	background-color:gray;
	margin:0px;
	color:white;
	padding:20px;
}

h3{
	text-align:center;
}

</style>
</head>
<body>
	<h1>Update Shoes</h1>
	<form method="post" action="updateShoes">
		<label>Name : </label><input type="text" name="name" required/>
		<label>Category :</label> <select name="category" required>
			<c:forEach var="category" items="${category}">
				<option>${category.name }</option>
				
			</c:forEach>
		</select> 
		<label>Price :</label><input type="text" name="price" required/>
		<input type="submit" value="submit" required/>
	</form>
</body>
</html>