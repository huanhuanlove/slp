package com.slp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.slp.bean.News;
import com.slp.dao.NewsDao;
import com.slp.util.Tool;

public class NewsDaoImpl implements NewsDao {

	@Override
	public List<News> newsList() {
		Connection conn = Tool.getConnect();
		List<News> list = new ArrayList<>();
		String sql = "select * from SLP_NEWS";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {
				News news = new News();
				news.setId(rs.getInt("id"));
				news.setNewTitle(rs.getString("newTitle"));
				news.setCateId(rs.getInt("cateId"));
				news.setNewsDate(rs.getString("newsDate"));
				news.setNewsContent(rs.getString("newsContent"));
				news.setNewsImg(rs.getString("newsImg"));
				list.add(news);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
