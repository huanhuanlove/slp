package com.slp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.slp.bean.Admin;
import com.slp.service.AdminService;
import com.slp.service.impl.AdminServiceImpl;

@WebServlet("/admin/adminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminService as = new AdminServiceImpl();
		Admin user = new Admin();
		String uname = request.getParameter("name").trim();
		String password = request.getParameter("pwd").trim();
		user.setAdminName(uname);
		user.setPassword(password);
		boolean flag = as.adminLogin(user);
		if(flag) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			request.getRequestDispatcher("/Content/index.jsp").forward(request, response);
		}else {
			response.sendRedirect(request.getContextPath()+"/Content/pages-login.jsp");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}