package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.Task;
import com.dto.UserInfo;
import com.model.dao.TaskDao;
import com.model.dao.UserInfoDao;

@WebServlet(value="/add-task")
public class AddTask extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter printWriter = resp.getWriter();
		
		//showing all employees
		List<UserInfo> employees = UserInfoDao.showAllEmployees();
		printWriter.println("<html><body>");
		printWriter.print("<h1>List of Employees</h1><br>");
		for(UserInfo employee: employees) {
			printWriter.println(employee);
			printWriter.print("<br>");

		}
		
		// form to ask Task properties
		printWriter.print("<h1>Enter Task Details<br></h1>");
		printWriter.print("<form action='add-tasks.jsp' method='post'>");
		printWriter.print("Assign to Employee Id <input type='number' name='assign' size='10'><br><br>");
		printWriter.print("<input type='submit' value='Enter' size='10'>");
		printWriter.print("</form>");
		printWriter.print("<br>");
		printWriter.print("<form action='manager-dashboard.jsp'>");
		printWriter.print("<input type='submit' value='Main Menu'>");
		printWriter.print("</form>");
		printWriter.print("</body></html>");
		printWriter.print("</body></html>");
		
	}
	
}
