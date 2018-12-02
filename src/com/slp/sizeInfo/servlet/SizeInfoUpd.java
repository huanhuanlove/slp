package com.slp.sizeInfo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slp.bean.SizeInfo;
import com.slp.service.SizeInfoService;
import com.slp.service.impl.SizeInfoServiceImpl;

@WebServlet("/sizeInfo/sizeInfoUpd")
public class SizeInfoUpd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SizeInfoService ss = new SizeInfoServiceImpl();
		int id = Integer.parseInt(request.getParameter("bid"));
		SizeInfo sizeList = ss.sizeInfoUpd(id);
		request.setAttribute("sizeList", sizeList);
		request.getRequestDispatcher("/Content/siteinfo/siteinfoUpdateForm.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}