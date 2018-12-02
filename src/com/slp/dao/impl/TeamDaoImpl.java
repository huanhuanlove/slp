package com.slp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.slp.bean.Team;
import com.slp.dao.TeamDao;
import com.slp.util.Tool;

public class TeamDaoImpl implements TeamDao {

	@Override
	public List<Team> teamList(int start, int end, String where) {
		Connection conn = Tool.getConnect();
		List<Team> list = new ArrayList<>();
		String sql = "select * from (select * from (select rownum rn,s.* from SLP_TEAM s where "+where+" ) where rn>?) where rn <=?";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setInt(1, start);
			ptmt.setInt(2, end);
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {
				Team team = new Team();
				team.setId(rs.getInt("id"));
				team.setName(rs.getString("name"));
				team.setPosition(rs.getString("position"));
				team.setPhoto(rs.getString("photo"));
				list.add(team);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int teamCount() {
		int i = 0;
		Connection conn = Tool.getConnect();
		String sql = "select count(*) from SLP_TEAM";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			rs.next();
			i = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int teamAdd(Team team) {
		int i = 0;
		Connection conn = Tool.getConnect();
		String sql = "insert into SLP_TEAM values(seq_team.nextval,?,?,?)";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, team.getName());
			ptmt.setString(2, team.getPosition());
			ptmt.setString(3, team.getPhoto());
			i = ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int teamDel(Integer id) {
		int i = 0;
		Connection conn = Tool.getConnect();
		String sql = "delete from SLP_TEAM where id ="+id;
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			i = ptmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public Team teamUpd(Integer id) {
		Connection conn = Tool.getConnect();
		String sql = "select * from SLP_TEAM where id = ?";
		Team team = new Team();
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setInt(1, id);
			ResultSet rs = ptmt.executeQuery();
			if(rs.next()) {
				team.setId(id);
				team.setName(rs.getString("name"));
				team.setPosition(rs.getString("position"));
				team.setPhoto(rs.getString("photo"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return team;
	}

	@Override
	public int teamUpd_inn(Team team) {
		int i = 0;
		Connection conn = Tool.getConnect();
		String sql = "update SLP_TEAM set name=?,position=?,photo=? where id=?";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, team.getName());
			ptmt.setString(2, team.getPosition());
			ptmt.setString(3, team.getPhoto());
			ptmt.setInt(4, team.getId());
			i = ptmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

}
