<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="userlogin.css" rel="stylesheet" type="text/css">
<style>

form{
	width:300px;
	margin:0 auto;
	padding : 20px;
	border:1px solid #ccc;
	border-radius:5px;
	background-color=#666;
}

input[type="text"],
input[type="password"]{
	width:93%;
	padding:10px;
	margin-bottom: 15px ;
	border:1px solid #ccc;
	border-radius:3px;
}

input[type="submit"]{
	background-color:#4CAF50;
	color:white;
	padding:10px 20px;
	border:none;
	border-radius:3px;
	cursor:pointer;
}

input[type="submit"]:hover{
	background-color:#45a049;
}

h1{
	text-align:center;
}

p{
	text-align: center;
	display:block;
	margin:40px;
}

a{
	background-color:red;
	color:white;
	padding:10px 20px;
	border:none;
	border-radius:3px;
	cursor:pointer;

}
</style>
</head>
<body>
<h1>Register</h1>
	<form action="login" method="post">
		<label>Name : </label> <input type="text" name="name" required/>
		<label>Email : </label> <input type="text" name="email" required/>
		<label>Phone : </label> <input type="text" name="phone" required/>
		<label>Address : </label> <input type="text" name="address" required/>
		<label>Password : </label> <input type="password" name="password" required/>
		<input type="submit" value="submit"/>
		
	</form>
	<p><a href="signupregister">SignUp</a></p>
	<p><a href="index">Home</a></p>
</body>
</html>