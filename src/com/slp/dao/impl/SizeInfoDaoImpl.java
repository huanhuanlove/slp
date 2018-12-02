package com.slp.dao.impl;

import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.slp.bean.SizeInfo;
import com.slp.dao.SizeInfoDao;
import com.slp.util.Tool;

public class SizeInfoDaoImpl implements SizeInfoDao {

	@Override
	public List<SizeInfo> sizeInfoList(int start, int end, String where) {
		List<SizeInfo> list = new ArrayList<>();
		Connection conn = Tool.getConnect();
		String sql = "select * from (select * from (select s.*,rownum rn from SLP_SITEINFO s where "+ where +" ) where rn>?) where rn<=?";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setInt(1, start);
			ptmt.setInt(2, end);
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {
				SizeInfo size = new SizeInfo();
				size.setId(rs.getInt("id"));
				size.setName(rs.getString("name"));

				/*
				 * 获取大文本clob
				 */
//				Clob clob = rs.getClob("content");
//				Reader reader = clob.getCharacterStream();
//				char[] a = new char[(int) clob.length()];
//				reader.read(a);
//				size.setContent(new String(a));
//				String img = rs.getString("infoImg");
				size.setInfoImg(rs.getString("infoImg"));
				list.add(size);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int sizeInfoCount() {
		int i = 0;
		Connection conn = Tool.getConnect();
		String sql = "select count(*) from SLP_SITEINFO";
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

	@Override
	public int sizeInfoAdd(SizeInfo sizeInfo) {
		int i = 0;
		Connection conn = Tool.getConnect();
		String sql = "insert into SLP_SITEINFO values(seq_admin.nextval,?,?,?)";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, sizeInfo.getName());

			//方法一：将数据写入clob()
//			String content = sizeInfo.getContent();
//			StringReader con = new StringReader(content);
//			ptmt.setCharacterStream(2, con, content.length());

			//方法二：将数据写入clob()
			ptmt.setString(2, sizeInfo.getContent());

			ptmt.setString(3, sizeInfo.getInfoImg());
			i = ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int sizeInfoDel(Integer id) {
		int i = 0;
		Connection conn = Tool.getConnect();
		String sql = "delete from SLP_SITEINFO where id="+id;
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			i = ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public SizeInfo sizeInfoUpd(Integer id) {
		Connection conn = Tool.getConnect();
		SizeInfo size = new SizeInfo();
		String sql = "select * from SLP_SITEINFO where id="+id;
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			if(rs.next()) {
				size.setId(id);
				size.setName(rs.getString("name"));

				//读取出clob数据
				Clob clob = rs.getClob("content");
				Reader is = clob.getCharacterStream();
				char[] c = new char[(int) clob.length()];
				is.read(c);
				size.setContent(new String(c));
				is.close();

				size.setInfoImg(rs.getString("infoImg"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return size;
	}

	@Override
	public int sizeInfoUpd_inn(SizeInfo sizeInfo) {
		int i = 0;
		Connection conn = Tool.getConnect();
		String sql = "update SLP_SITEINFO set name=?,content=?,infoImg=? where id=?";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, sizeInfo.getName());
			ptmt.setString(2, sizeInfo.getContent());
			ptmt.setString(3, sizeInfo.getInfoImg());
			ptmt.setInt(4, sizeInfo.getId());
			i = ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

}
