<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello JSP Page</title>
</head>
<body style="font-family: Arial; text-align: center; margin-top: 50px;">
	<h2>Hello from JSP!</h2>
	<p>
		<strong>Message:</strong>
		<%= request.getAttribute("msg") %></p>

	<hr />
	<form action="HelloGenericServlet" method="get">
		<label for="user">Enter your name:</label> <input type="text"
			id="user" name="user" />
		<button type="submit">Submit</button>
	</form>
</body>
</html>