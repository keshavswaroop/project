<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false" %>
<html>
<head>

<title>Insert title here</title>
</head>
<body>
	<h1>Hello!! Welcome to Spring</h1>
	
	<%
	
		out.println("Id: "+request.getAttribute("id"));
	out.println("Name: "+request.getAttribute("name"));
	out.println("Salary: "+request.getAttribute("salary"));
	%>
	
	<p>Id : ${id }</p>
	<p>Name : ${name }</p>
	<p>Salary : ${salary }</p>
	
	<p>${employee }</p>
</body>
</html>