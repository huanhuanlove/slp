package com.slp.banner.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slp.service.BannerService;
import com.slp.service.impl.BannerServiceImpl;


@WebServlet("/banner/bannerDel")
public class BannerDel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("bid"));
		BannerService bs = new BannerServiceImpl();
		boolean flag = bs.delbanner(id);
		if(flag) {
			request.getRequestDispatcher("/banner/bannerList?currentPage=1").forward(request, response);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
