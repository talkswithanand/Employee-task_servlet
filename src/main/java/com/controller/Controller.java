package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.dao.UserInfoDao;

@WebServlet(value = "/control")
public class Controller extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String option = req.getParameter("choose");
		String userName = req.getParameter("loginId");
		String password = req.getParameter("password");

		HttpSession session = req.getSession();
		session.setAttribute("userName", userName);
		session.setAttribute("userPassword", password);

		if (option.equals("Register Manager")) {
			// form to ask Manager properties
			PrintWriter printWriter = resp.getWriter();
			printWriter.print("<h1>Enter Manager Details<br></h1>");
			printWriter.print("<form action='reg-man' method='post'>");
			printWriter.print("Email <input type='email' name='userEmail' size='10'><br><br>");
			printWriter.print("Role <input type='text' value='Manager' name='role' readonly size='10'><br><br>");
			printWriter.print("Designation <input type='text' name='userDesignation' size='10'><br><br>");
			printWriter.print("Salary <input type='number' name='userSalary' size='10'><br><br>");
			printWriter.print("<input type='submit' value='Enter' size='10'>");
			printWriter.print("</form>");
		}
		else if (option.equals("Login Manager")) {
			// check existence of manager with userName & password
			int id = UserInfoDao.findUserByUserName(userName, password);
			if (id != -1) {
				resp.sendRedirect("manager-dashboard.jsp");
			} else {
				PrintWriter printWriter = resp.getWriter();
				printWriter.print("<div style='text-align: center;'><h1>Manager does not exist !!</h1></div>");
			}
		}
		else if(option.equals("Register Employee")) {
			//form to ask employee properties
			PrintWriter printWriter = resp.getWriter();
			printWriter.print("<h1>Enter Employee Details<br></h1>");
			printWriter.print("<form action='reg-emp' method='post'>");
			printWriter.print("Email <input type='email' name='userEmail' size='10'><br><br>");
			printWriter.print("Role <input type='text' value='Employee' name='role' readonly size='10'><br><br>");
			printWriter.print("Designation <input type='text' name='userDesignation' size='10'><br><br>");
			printWriter.print("Salary <input type='number' name='userSalary' size='10'><br><br>");
			printWriter.print("<input type='submit' value='Enter' size='10'>");
			printWriter.print("</form>");
		}
		else {
			// check existence of employee with userName & password
			int id = UserInfoDao.findUserByUserName(userName, password);
			if (id != -1) {
				session.setAttribute("userId", id);
				resp.sendRedirect("employee-dashboard.jsp");
			} else {
				PrintWriter printWriter = resp.getWriter();
				printWriter.print("<div style='text-align: center;'><h1>Employee does not exist !!</h1></div>");
			}
		}
	}
}
