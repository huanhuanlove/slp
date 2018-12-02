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

@WebServlet("/admin/adminChangeMiMa")
public class AdminChangeMiMa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String adminName = request.getParameter("adminName");//用户名
		String adminPwd = request.getParameter("adminPwd");//新密码
		Admin user = new Admin();
		user.setAdminName(adminName);
		user.setPassword(adminPwd);
		AdminService as = new AdminServiceImpl();
		boolean flag = as.changeMiMa(user);
		if(flag) {
			request.getRequestDispatcher("adminList?currentPage=1").forward(request, response);
		}else {
			request.getRequestDispatcher("Content/admin/adminUpdateForm.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
