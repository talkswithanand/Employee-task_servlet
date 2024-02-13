package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.UserInfo;
import com.model.dao.UserInfoDao;

@WebServlet(value="/reg-man")
public class RegisterManagerServlet extends HttpServlet{
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			HttpSession session = req.getSession();
			String userName = (String)session.getAttribute("userName");
			String password = (String)session.getAttribute("userPassword");
			
			//request properties
			String email = req.getParameter("userEmail");
			String role = req.getParameter("role");
			String designation = req.getParameter("userDesignation");
			double salary = Double.parseDouble(req.getParameter("userSalary"));
			
			// call userDaoInfo to persist Manager
			UserInfoDao.persistUserInfo(userName, password, email, role, designation, salary);
			
			//redirect to Manager Dashboard
			resp.sendRedirect("manager-dashboard.jsp");
			
		}
}
