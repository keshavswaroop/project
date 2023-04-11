<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="/resources/static/css/style.css" rel="stylesheet" type="text/css">
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
	<div>
		<h2>Profile</h2>
		<div
			style="text-align: left; width: 300px; margin: 0 auto; padding: 20px; border: 1px solid #ccc; border-radius: 5px; text-align: center;">

			<p>Name : ${LoginCredentials.name }</p>
			<p>Email : ${LoginCredentials.email }</p>
			<p>
				<a href="resetpassword">Reset Password</a>
			</p>
		</div>
		<h2>Admin Options</h2>
		<div
			style="text-align: left; width: 300px; margin: 0 auto; padding: 20px; border: 1px solid #ccc; border-radius: 5px; text-align: center;">

			<p>
				<a style="background-color: black; color: white"
					href="category">Shoe Category</a>
			</p>
			<p>
				<a style="background-color: black; color: white"
					href="shoes">Shoes</a>
			</p>
			<p>
				<a style="background-color: black; color: white"
					href="purchasereport">Purchase Report</a>
			</p>
			<p>
				<a style="background-color: black; color: white"
					href="userDetails">User Details</a>
			</p>
		</div>
		<p>
			<a
				style="color: red; background-color: white; border: 1px solid red;"
				href="admin">Logout</a>
		</p>

	</div>


</body>
</html>