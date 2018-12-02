package com.slp.sizeInfo.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slp.bean.SizeInfo;
import com.slp.service.SizeInfoService;
import com.slp.service.impl.SizeInfoServiceImpl;

@WebServlet("/sizeInfo/sizeInfoList")
public class SizeInfoList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SizeInfoService ss = new SizeInfoServiceImpl();
		String where;
		String search = request.getParameter("EX_search");
		if(search==null || search.equals("")) {
			where = " 1=1";
		}else {
			where = " name like '%"+search+"%'";
		}

		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		int pageSize = 3;
		int start = (currentPage-1)*pageSize;
		int end = currentPage*pageSize;
		int totalCount = ss.sizeInfoCount();
		int totalPage;
		if(totalCount%pageSize==0) {
			totalPage = totalCount/pageSize;
		}else {
			totalPage = totalCount/pageSize+1;
		}
		Map<String, Integer> map = new HashMap<>();
		map.put("currentPage", currentPage);
		map.put("pageSize", pageSize);
		map.put("totalCount", totalCount);
		map.put("totalPage", totalPage);
		List<SizeInfo> list = ss.sizeInfoList(start, end, where);
		request.setAttribute("map", map);
		request.setAttribute("search", search);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/Content/siteinfo/siteinfoList.jsp").forward(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
