package com.slp.news.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slp.bean.News;
import com.slp.service.NewsService;
import com.slp.service.impl.NewsServiceImpl;

@WebServlet("/news/newsList")
public class NewsList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NewsService ns = new NewsServiceImpl();
		List<News> newslist = ns.newsList();


		request.setAttribute("newslist", newslist);
		request.getRequestDispatcher("/Content/news/newsList.jsp").forward(request, response);


	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
