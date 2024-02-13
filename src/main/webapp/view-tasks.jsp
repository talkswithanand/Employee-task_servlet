<%@page import="java.util.Collections"%>
<%@page import="com.model.dao.TaskDao"%>
<%@page import="java.util.*"%>
<%@page import="com.dto.Task"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Task List</title>
</head>
<body>
		<h1>List of tasks</h1>
		<%
			//sort List<Task>
			List<Task> tasks = TaskDao.showAllTask();
			Collections.sort(tasks);
			//showing all tasks
			for (Task task : tasks) {
		%>
		<%=task%>
		<br>
		<%
			}
		%>
		<br>
		<br>
		<form action="manager-dashboard.jsp">
			<input type="submit" value="Main Menu">
		</form>

</body>
</html>