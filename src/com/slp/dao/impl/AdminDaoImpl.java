package com.slp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.slp.bean.Admin;
import com.slp.dao.AdminDao;
import com.slp.util.Tool;

public class AdminDaoImpl implements AdminDao{
	/**
	 * 实现登录
	 */
	@Override
	public Admin adminLogin(Admin admin) {
		Connection conn = Tool.getConnect();
		String sql = "select * from SLP_ADMIN where adminName=? and password=?";
		Admin user = null;
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, admin.getAdminName());
			ptmt.setString(2, admin.getPassword());
			ResultSet rs = ptmt.executeQuery();
			if(rs.next()) {
				user = new Admin();
				user.setAdminName(rs.getString("adminName"));
				user.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	/**
	 * 列出管理员
	 */
	@Override
	public List<Admin> adminList(int start, int end, String where) {
		Connection conn = Tool.getConnect();
		List<Admin> list = new ArrayList<>();
		String sql = "select * from (select * from (select s.*,rownum rn from SLP_ADMIN s where "+where+") where rn>?) where rn<=?";
		Admin user = null;
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setInt(1, start);
			ptmt.setInt(2, end);
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {
				user = new Admin();
				user.setId(rs.getInt("id"));
				user.setAdminName(rs.getString("adminName"));
				user.setPassword(rs.getString("password"));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}


	/**
	 * 添加管理员
	 */
	@Override
	public int addAdmin(Admin admin) {
		int i = 0;
		Connection conn = Tool.getConnect();
		String sql = "insert into SLP_ADMIN values(seq_admin.nextval,?,?)";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, admin.getAdminName());
			ptmt.setString(2, admin.getPassword());
			i = ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}


	/**
	 * 管理员删除
	 */
	@Override
	public int delAdmin(Integer id) {
		int i = 0;
		Connection conn = Tool.getConnect();
		String sql = "delete from SLP_ADMIN where id=?";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setInt(1, id);
			i = ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}


	/**
	 * 管理员修改（查询）
	 */
	@Override
	public Admin updAdmin(Integer id) {
		Connection conn = Tool.getConnect();
		Admin user = new Admin();
		String sql = "select * from SLP_ADMIN where id=?";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setInt(1, id);
			ResultSet rs = ptmt.executeQuery();
			rs.next();
			user.setId(rs.getInt("id"));
			user.setAdminName(rs.getString("adminName"));
			user.setPassword(rs.getString("password"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}


	/**
	 * 管理员修改（入库）
	 */
	@Override
	public int updAdmin_inn(Admin admin) {
		int i = 0;
		Connection conn = Tool.getConnect();
		String sql = "update SLP_ADMIN set adminName=?,password=? where id=?";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, admin.getAdminName());
			ptmt.setString(2, admin.getPassword());
			ptmt.setInt(3, admin.getId());
			i = ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}


	/**
	 * 管理员总数量(where用于分页)
	 */
	@Override
	public int countAdmin(String where) {
		int i = 0;
		Connection conn = Tool.getConnect();
		String sql = "select count(*) from SLP_ADMIN where"+where;
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


	/**
	 * 修改密码
	 */
	@Override
	public int changeMiMa(Admin admin) {
		int i = 0;
		Connection conn = Tool.getConnect();
		String sql = "update SLP_ADMIN set password=? where adminName=?";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, admin.getPassword());
			ptmt.setString(2, admin.getAdminName());
			i = ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}



}
