<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.Collection"%>
<%@page import="com.dto.Task"%>
<%@page import="java.util.List"%>
<%@page import="com.model.dao.TaskDao"%>
<%@page import="com.model.dao.UserInfoDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Task</title>
</head>
<body>

	<%
		int employeeId = (Integer) session.getAttribute("userId");
		List<Task> tasks = TaskDao.showEmployeeSpecificTask(employeeId);
		if (tasks != null || tasks.size() != 0) {
			PrintWriter printWriter = response.getWriter();
			printWriter.println("<h1>List of tasks</h1>");
			for (Task task : tasks) {
	%>
	<%=task%>
	<br>
	<%
		}
	%>
	<%
		}
	%>

	<h3>Enter Task id to be updated</h3>
	<form action="update" method="post">
		<input type="number" name="taskId"> <br> <br> <input
			type="submit" value="Enter">
	</form>
	<br>
	<form action="employee-dashboard">
		<input type="submit" value="Go back">
	</form>

</body>
</html>