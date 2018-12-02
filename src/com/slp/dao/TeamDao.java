package com.slp.dao;

import java.util.List;

import com.slp.bean.Team;

public interface TeamDao {

	public List<Team> teamList(int start, int end, String where);
	public int teamCount();
	public int teamAdd(Team team);
	public int teamDel(Integer id);
	public Team teamUpd(Integer id);
	public int teamUpd_inn(Team team);

}
