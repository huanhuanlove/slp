package com.slp.links.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slp.bean.Links;
import com.slp.service.LinksService;
import com.slp.service.impl.LinksServiceImpl;

@WebServlet("/links/linksList")
public class LinksList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LinksService ls = new LinksServiceImpl();
		int pagesize = 3;
		int currentpage = Integer.parseInt(request.getParameter("currentPage"));
		String tablename = "LINKS";
		List<Links> linksList = ls.linksList(tablename, currentpage, pagesize);
		request.setAttribute("linksList", linksList);
		request.getRequestDispatcher("/Content/links/LinksList.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
