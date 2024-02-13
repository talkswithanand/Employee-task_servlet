<%@page import="com.model.dao.TaskDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Task Added</title>
</head>

<body>

	<%
	String description = request.getParameter("description");
	int employeeId = Integer.parseInt((String)session.getAttribute("employeeId"));
	TaskDao.persistTask(employeeId, description);
	%>
	<h2>Task Added Successfully!!</h2>
		<br>
		<form action="manager-dashboard.jsp">
			<input type="submit" value="Main Menu">
		</form>
	
</body>
</html>