package com.slp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slp.service.AdminService;
import com.slp.service.impl.AdminServiceImpl;

@WebServlet("/admin/adminDel")
public class AdminDel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminService as = new AdminServiceImpl();
		String bid = request.getParameter("bid");//用户id
		int id = Integer.parseInt(bid);
		boolean flag = as.delAdmin(id);
		if(flag) {
			request.getRequestDispatcher("adminList?currentPage=1").forward(request, response);
		}else {
			request.getRequestDispatcher("/Content/admin/adminList.jsp").forward(request, response);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
