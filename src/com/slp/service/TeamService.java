package com.slp.service;

import java.util.List;

import com.slp.bean.Team;

public interface TeamService {

	public List<Team> teamList(int start, int end, String where);
	public int teamCount();
	public boolean teamAdd(Team team);
	public boolean teamDel(Integer id);
	public Team teamUpd(Integer id);
	public boolean teamUpd_inn(Team team);
}
