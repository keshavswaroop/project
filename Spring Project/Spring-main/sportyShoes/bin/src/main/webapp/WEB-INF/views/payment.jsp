<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment Portal</title>

<link href="payment.css" rel="stylesheet" type="text/css">

<style>
@charset "ISO-8859-1";

body {
	font-family: Arial, sans-serif;
}

.container {
	margin: 0 auto;
	max-width: 500px;
	padding: 20px;
	background-color: #f0f0f0;
	border-radius: 5px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
}

h1 {
	text-align: center;
	margin-bottom: 20px;
}

form {
	display: flex;
	flex-direction: column;
}

label {
	margin-top: 10px;
}

input {
	padding: 10px;
	border-radius: 5px;
	border: none;
	margin-bottom: 20px;
}

button {
	background-color: #4CAF50;
	color: white;
	border: none;
	padding: 10px;
	border-radius: 5px;
	cursor: pointer;
}

button:hover {
	background-color: #3e8e41;
}
</style>
</head>
<body>
	<div class="container">
		<h1>Payment Portal</h1>
		<form action="bookingConfirm" method="post">
			<label for="card-name">Cardholder Name</label> <input type="text"
				id="card-name" name="card-name" required> <label
				for="card-number">Card Number</label> <input type="text"
				id="card-name" name="number" required> <label
				for="expiry-date">Expiry Date</label> <input type="date"
				id="expiry-date" name="date" required> <label for="cvv">CVV</label>
			<input type="number" id="cvv" name="cvv" min="100" max="999" required>
			<button type="submit">Submit Payment</button>
		</form>
	</div>
</body>
</html>