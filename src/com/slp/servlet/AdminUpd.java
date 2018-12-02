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

@WebServlet("/admin/adminUpd")
public class AdminUpd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bid = request.getParameter("id");
		int id = Integer.parseInt(bid);
		AdminService as = new AdminServiceImpl();
		Admin user = as.updAdmin(id);
		request.setAttribute("user", user);
		request.getRequestDispatcher("/Content/admin/adminForm.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
