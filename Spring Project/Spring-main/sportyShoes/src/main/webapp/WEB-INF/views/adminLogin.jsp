<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="/resources/static/css/style.css" rel="stylesheet" type="text/css">
<style>

@charset "ISO-8859-1";
body{
	margin:0px;
	padding:0px;
	
}
form{
	width:300px;
	margin:0 auto;
	padding : 20px;
	
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
	background-color:#666;
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
	background-color:black;
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
	<h1>Admin Login</h1>
	
	<form action = "adminCheck" method="post">
		Enter Email : &nbsp; &nbsp;<input type="text" name = "email" required/>
		Enter Password : <input type = "password" name = "password" required/>
		<input type="submit" value="submit"/>
		<p><a href="index">Back</a></p>
	</form>
	
	<p>Login Credentials</p>
	<p>Email    : simplilearn@gmail.com</p>
	<p>Password : admin</p>
</body>
</html>