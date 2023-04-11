<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="ticketConfirm.css" rel="stylesheet" type="text/css">
<link href="user.css" rel="stylesheet" type="text/css">
<style>
@charset "ISO-8859-1";

body{
	font-family:Arial,sans-serif;
	background-color: #f0f0f0;
}

.container{
	margin: 0 auto;
	max-width:500px;
	padding:20px;
	background-color:#fff;
	border-radius:5px;
	box-shadow:0 0 10px rgba(0,0,0,0.2);
	text-align:center;
}

h1{
	margin-bottom:20px;
}

a{
	display:block;
	margin-top:20px;
	color:#4CAF50;
	text-decoration:none;
}
a:hover{
	text-decoration:underline;
}

button:hover{
	color: white;
	background-color: black;
}

@charset "ISO-8859-1";

.user-details{
	display:flex;
	justify-content:space-between;
	margin:20px auto;
	max-width:800px;
	padding:20px;
	border:1px solid #ccc;
	border-radius:5px;
}

.user-info,.flight-info{
	width:45%;
}

.user-info h2,.flight-info h2{
	font-size:1.5rem;
	margin-bottom:10px;
}

.user-info p,.flight-info p{
	font-size:1.2rem;
	margin-bottom:5px;
}


</style>
</head>
<body>
	<div class="container">
		<h1>Thank You for Your Payment!</h1>
		<p>Your booking has been confirmed. Please check your email for your e-ticket.</p>
		<a href="userHome">Back to home</a>
	</div>
	<div style="background-color: white;font-size:10px" class="user-details">
		<div  class="user-info">
			<h2>User Information</h2>
			<p>Name : ${user.name }</p>
			<p>Email : ${user.email }</p>
			<p>Phone : ${user.phone }</p>
			<p>Address : ${user.address }</p>
			<%Random rand = new Random(); 
				int n=rand.nextInt(9000000)+100000;
			%>
		</div>
		<div class="flight-info">
			<h2>Order Information</h2>
			<p>Order ID : OID${n}
			<p>Number of Products : ${n }</p>
			<p>Total Price : &#x20B9;${total}</p>
			
			<button style="color: black;
	background-color: white;
	padding: 10px;
	border:1px solid black;margin-top:10px" type="button" onclick="window.print()">Download Order Details</button>
		</div>
	</div>
	
	
	
	
	
	
</body>
</html>