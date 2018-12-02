package com.slp.team.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slp.bean.Team;
import com.slp.service.TeamService;
import com.slp.service.impl.TeamServiceImpl;

@WebServlet("/team/teamList")
public class TeamList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TeamService ts = new TeamServiceImpl();
		String search = request.getParameter("EX_search");
		String where;
		if(search==null || "".equals(search)) {
			where = "1=1";
		}else {
			where = "name like '%"+search+"%'";
		}

		int currentpage = Integer.parseInt(request.getParameter("currentPage"));
		int totalCount = ts.teamCount();
		int pageSize = 3;
		int start = (currentpage-1)*pageSize;
		int end = currentpage*pageSize;
		int totalPage;
		if(totalCount%pageSize==0) {
			totalPage=totalCount/pageSize;
		}else {
			totalPage=totalCount/pageSize+1;
		}
		Map<String, Integer> map = new HashMap<>();
		map.put("currentPage", currentpage);
		map.put("totalCount", totalCount);
		map.put("totalPage", totalPage);
		map.put("pageSize", pageSize);

		List<Team> list = ts.teamList(start, end, where);

		request.setAttribute("teamMap", map);
		request.setAttribute("search", search);
		request.setAttribute("teamList", list);
		request.getRequestDispatcher("/Content/team/teamList.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
