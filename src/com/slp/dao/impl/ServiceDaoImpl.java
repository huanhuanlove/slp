package com.slp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.slp.bean.Service;
import com.slp.dao.ServiceDao;
import com.slp.util.Tool;

public class ServiceDaoImpl implements ServiceDao {

	@Override
	public List<Service> serviceList(int start, int end, String where) {
		Connection conn = Tool.getConnect();
		List<Service> list = new ArrayList<>();
		String sql = "select * from (select * from (select s.*,rownum rn from SLP_SERVICE s where "+where+") where rn>?) where rn<=?";

		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setInt(1, start);
			ptmt.setInt(2, end);
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {
				Service service = new Service();
				service.setId(rs.getInt("id"));
				service.setServiceName(rs.getString("serviceName"));
				service.setServiceTitle(rs.getString("serviceTitle"));
				service.setServiceContent(rs.getString("serviceContent"));
				service.setServiceImg(rs.getString("serviceImg"));
				list.add(service);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int serviceAdd(Service service) {
		int i = 0;
		Connection conn = Tool.getConnect();
		String sql = "insert into SLP_SERVICE values(seq_service.nextval,?,?,?,?)";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, service.getServiceName());
			ptmt.setString(2, service.getServiceTitle());
			ptmt.setString(3, service.getServiceContent());
			ptmt.setString(4, service.getServiceImg());
			i = ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int serviceDel(Integer id) {
		int i = 0;
		Connection conn = Tool.getConnect();
		String sql = "delete from SLP_SERVICE where id=?";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setInt(1, id);
			i = ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public Service serviceUpd(Integer id) {
		Connection conn = Tool.getConnect();
		Service service = new Service();
		String sql = "select * from SLP_SERVICE where id=?";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setInt(1, id);
			ResultSet rs = ptmt.executeQuery();
			rs.next();
			service.setId(id);
			service.setServiceName(rs.getString("serviceName"));
			service.setServiceTitle(rs.getString("serviceTitle"));
			service.setServiceContent(rs.getString("serviceContent"));
			service.setServiceImg(rs.getString("serviceImg"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return service;
	}

	@Override
	public int serviceUpd_inn(Service service) {
		int i = 0;
		Connection conn = Tool.getConnect();
		String sql = "update SLP_SERVICE set servicename=?,servicetitle=?,servicecontent=?,serviceImg=? where id=?";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, service.getServiceName());
			ptmt.setString(2, service.getServiceTitle());
			ptmt.setString(3, service.getServiceContent());
			ptmt.setString(4, service.getServiceImg());
			ptmt.setInt(5, service.getId());
			i = ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int serviceCount(String where) {
		int i = 0;
		Connection conn = Tool.getConnect();
		String sql = "select count(*) from SLP_SERVICE where"+where;
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

}
