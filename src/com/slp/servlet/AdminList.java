package com.slp.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slp.bean.Admin;
import com.slp.service.AdminService;
import com.slp.service.impl.AdminServiceImpl;

@WebServlet("/admin/adminList")
public class AdminList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//模糊查询
		String search = request.getParameter("EX_search");
		String where;
		if(search==null || search.trim().equals("")) {
			where = " 1=1";
		}else {
			where = " adminName like '%"+search+"%'";
		}
		//分页
		int currentPage;
		int totalPage;
		int start;
		int end;
		int pageCount=3;
		int totalCount;
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
		start = (currentPage-1)*pageCount;
		end = currentPage*pageCount;
		AdminService as = new AdminServiceImpl();
		totalCount = as.countAdmin(where);
		if(totalCount%pageCount==0) {
			totalPage = totalCount/pageCount;
		}else {
			totalPage = totalCount/pageCount+1;
		}
		Map<String, Integer> map = new HashMap<>();


		List<Admin> adminList = as.adminList(start, end, where);
		map.put("currentPage", currentPage);
		map.put("totalPage", totalPage);
		map.put("pageCount", pageCount);
		map.put("totalCount", totalCount);
		request.setAttribute("search", search);
		request.setAttribute("adminList", adminList);
		request.setAttribute("adminMap", map);
		request.getRequestDispatcher("/Content/admin/adminList.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
