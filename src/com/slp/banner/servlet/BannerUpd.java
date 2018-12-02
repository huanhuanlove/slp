package com.slp.banner.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slp.bean.Banner;
import com.slp.service.BannerService;
import com.slp.service.impl.BannerServiceImpl;

@WebServlet("/banner/bannerUpd")
public class BannerUpd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("bid"));
		BannerService bs = new BannerServiceImpl();
		Banner banner = bs.updBanner(id);
		request.setAttribute("bannerData", banner);
		request.getRequestDispatcher("/Content/banner/bannerUpdateForm.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
