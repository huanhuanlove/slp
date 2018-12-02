package com.slp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slp.bean.Admin;
import com.slp.service.AdminService;
import com.slp.service.impl.AdminServiceImpl;

@WebServlet("/admin/adminAdd")
public class AdminAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminService as = new AdminServiceImpl();
		Admin user = new Admin();
		String uname = request.getParameter("adminName");
		String pwd = request.getParameter("adminPwd");
		user.setAdminName(uname);
		user.setPassword(pwd);
		boolean flag = as.addAdmin(user);
		if(flag) {
			request.getRequestDispatcher("adminList?currentPage=1").forward(request, response);
		}else {
			request.getRequestDispatcher("Content/admin/adminForm.jsp?currentPage=1").forward(request, response);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
