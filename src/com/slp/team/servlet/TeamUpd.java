package com.slp.team.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slp.bean.Team;
import com.slp.service.TeamService;
import com.slp.service.impl.TeamServiceImpl;

@WebServlet("/team/teamUpd")
public class TeamUpd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TeamService ts = new TeamServiceImpl();
		int id = Integer.parseInt(request.getParameter("bid"));
		Team team = ts.teamUpd(id);
		request.setAttribute("teamList", team);
		request.getRequestDispatcher("/Content/team/teamUpdateForm.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
