package com.slp.service.impl;

import java.util.List;

import com.slp.bean.Team;
import com.slp.dao.TeamDao;
import com.slp.dao.impl.TeamDaoImpl;
import com.slp.service.TeamService;

public class TeamServiceImpl implements TeamService {

	TeamDao td = new TeamDaoImpl();


	@Override
	public List<Team> teamList(int start, int end, String where) {
		return td.teamList(start, end, where);
	}


	@Override
	public int teamCount() {
		return td.teamCount();
	}


	@Override
	public boolean teamAdd(Team team) {
		int i = td.teamAdd(team);
		if(i>0) {
			return true;
		}
		return false;
	}


	@Override
	public boolean teamDel(Integer id) {
		int i = td.teamDel(id);
		if(i>0) {
			return true;
		}
		return false;
	}


	@Override
	public Team teamUpd(Integer id) {
		return td.teamUpd(id);
	}


	@Override
	public boolean teamUpd_inn(Team team) {
		int i = td.teamUpd_inn(team);
		if(i>0) {
			return true;
		}
		return false;
	}

}
