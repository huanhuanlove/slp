package com.slp.sizeInfo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slp.service.SizeInfoService;
import com.slp.service.impl.SizeInfoServiceImpl;

@WebServlet("/sizeInfo/sizeInfoDel")
public class SizeInfoDel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("bid"));
		SizeInfoService ss = new SizeInfoServiceImpl();
		boolean flag = ss.sizeInfoDel(id);
		if(flag) {
			request.getRequestDispatcher("/sizeInfo/sizeInfoList?currentPage=1").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
