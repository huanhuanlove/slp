package com.slp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.slp.bean.Banner;
import com.slp.dao.BannerDao;
import com.slp.util.Tool;

public class BannerDaoImpl implements BannerDao{

	/**
	 * 列出所有banner
	 */
	@Override
	public List<Banner> bannerList(int start, int end, String where) {
		List<Banner> list = new ArrayList<>();
		Connection conn = Tool.getConnect();
		String sql = "select * from (select * from (select rownum rn,s.* from SLP_BANNER s where "+ where +") where rn>?) where rn<=?";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setInt(1, start);
			ptmt.setInt(2, end);
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {
				Banner banner = new Banner();
				banner.setId(rs.getInt("id"));
				banner.setName(rs.getString("name"));
				banner.setUrl(rs.getString("url"));
				banner.setBannerImg(rs.getString("bannerImg"));
				list.add(banner);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 添加banner
	 */
	@Override
	public int addbanner(Banner banner) {
		int i = 0;
		Connection conn = Tool.getConnect();
		String sql = "insert into SLP_BANNER values(seq_banner.nextval,?,?,?)";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, banner.getName());
			ptmt.setString(2, banner.getUrl());
			ptmt.setString(3, banner.getBannerImg());
			i = ptmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	/**
	 * banner总数
	 */
	@Override
	public int bannerCount() {
		int i = 0;
		Connection conn = Tool.getConnect();
		String sql = "select count(*) from SLP_BANNER";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			rs.next();
			i = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	/**
	 * banner删除
	 */
	@Override
	public int delBanner(Integer id) {
		int i = 0;
		Connection conn = Tool.getConnect();
		String sql = "delete from SLP_BANNER where id="+id;
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			i = ptmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	/**
	 * banner修改（查询）
	 */
	@Override
	public Banner updBanner(Integer id) {
		Connection conn = Tool.getConnect();
		Banner banner = null;
		String sql = "select * from SLP_BANNER where id="+id;
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {
				banner = new Banner();
				banner.setId(id);
				banner.setName(rs.getString("name"));
				banner.setUrl(rs.getString("url"));
				banner.setBannerImg(rs.getString("bannerImg"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return banner;
	}


	/**
	 * banner修改（入库）
	 */
	@Override
	public int updBanner_inn(Banner banner) {
		int i = 0;
		Connection conn = Tool.getConnect();
		String sql = "update SLP_BANNER set name=?,url=?,bannerImg=? where id=?";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, banner.getName());
			ptmt.setString(2, banner.getUrl());
			ptmt.setString(3, banner.getBannerImg());
			ptmt.setInt(4, banner.getId());
			i = ptmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

}
