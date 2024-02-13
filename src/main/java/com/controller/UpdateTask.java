package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.dao.TaskDao;

@WebServlet(value = "/update")
public class UpdateTask extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int taskId = Integer.parseInt(req.getParameter("taskId"));
		TaskDao.updateTask(taskId);
		PrintWriter printWriter = resp.getWriter();
		printWriter.print("<html><body>");
		printWriter.print("<h2>Updated Successfully!!</h2>");
		printWriter.print("<br><br>");
		printWriter.print("<form action='employee-dashboard.jsp'>");
		printWriter.print("<input type='submit' value='Main Menu'>");
		printWriter.print("</form>");
		printWriter.print("</body></html>");
		
	}
}
