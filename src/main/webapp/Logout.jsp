<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logged Out</title>
</head>
<body>
	<h1>Logged out successfully !!</h1>
	<%
		session.invalidate();
	%>
		<br>
		<form action="index.jsp">
			<input type="submit" value="Home Page">
		</form>
</body>
</html>