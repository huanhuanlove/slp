package com.slp.banner.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slp.bean.Banner;
import com.slp.service.BannerService;
import com.slp.service.impl.BannerServiceImpl;

@WebServlet("/banner/bannerList")
public class BannerList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BannerService bs = new BannerServiceImpl();
		String where;
		String search = request.getParameter("EX_search");
		if(search==null || "".equals(search)) {
			where =" 1=1";
		}else {
			where = " name like '%"+ search +"%'";
		}
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		int pageSize = 3;
		int start = (currentPage-1)*pageSize;
		int end = currentPage*pageSize;
		int totalData = bs.bannerCount();
		int totalPage = 0;
		if(totalData%pageSize==0) {
			totalPage = totalData/pageSize;
		}else {
			totalPage = totalData/pageSize+1;
		}
		Map<String, Integer> map = new HashMap<>();
		map.put("currentPage", currentPage);
		map.put("totalData", totalData);
		map.put("pageSize", pageSize);
		map.put("totalPage", totalPage);
		List<Banner> bannerList = bs.bannerList(start, end, where);
		request.setAttribute("search", search);
		request.setAttribute("bannerList", bannerList);
		request.setAttribute("bannerMap", map);
		request.getRequestDispatcher("/Content/banner/bannerList.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
