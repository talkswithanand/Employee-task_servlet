<%@page import="com.model.dao.UserInfoDao"%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.model.dao.TaskDao"%>

<%@page import="com.dto.Task"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Task</title>
</head>
<body>
	<h1>Add Task Detail</h1>
	<%
		session.setAttribute("employeeId", request.getParameter("assign"));
	%>
	<form action="task-oper.jsp">
		Description <input type="text" name="description"> <br> <br>
		<input type="submit" value="Enter">
	</form>


</body>
</html>