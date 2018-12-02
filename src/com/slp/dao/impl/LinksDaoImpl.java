package com.slp.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.slp.bean.Links;
import com.slp.dao.LinksDao;
import com.slp.util.Tool;

import oracle.jdbc.OracleTypes;

public class LinksDaoImpl implements LinksDao{

	@Override
	public List<Links> linkList(String tablename, int currentpage, int pagesize) {
		Connection conn = Tool.getConnect();
		List<Links> list = new ArrayList<>();
		int totalpage;
		int totalcount;
		String sql = "{call fenye_pack.fenye_pro(?,?,?,?,?,?) }";
		try {
			CallableStatement call = conn.prepareCall(sql);
			call.setString(1, tablename);
			call.setInt(2, currentpage);
			call.setInt(3, pagesize);
			call.registerOutParameter(4, OracleTypes.NUMBER);
			call.registerOutParameter(5, OracleTypes.NUMBER);
			call.registerOutParameter(6, OracleTypes.CURSOR);
			call.execute();
			totalcount = call.getInt(4);
			totalpage = call.getInt(5);
			ResultSet rs = (ResultSet)call.getObject(6);
			while (rs.next()) {
				Links links = new Links();
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String url = rs.getString("url");
				String linkimg = rs.getString("linkimg");
				links.setId(id);
				links.setName(name);
				links.setUrl(url);
				links.setLinkImg(linkimg);
				list.add(links);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

}
