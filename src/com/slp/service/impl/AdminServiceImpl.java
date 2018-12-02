package com.slp.service.impl;

import java.util.List;

import com.slp.bean.Admin;
import com.slp.dao.AdminDao;
import com.slp.dao.impl.AdminDaoImpl;
import com.slp.service.AdminService;

public class AdminServiceImpl implements AdminService {
	/**
	 * 登录
	 */
	AdminDao ad = new AdminDaoImpl();
	@Override
	public boolean adminLogin(Admin admin) {
		Admin user = ad.adminLogin(admin);
		if(user!=null) {
			return true;
		}
		return false;
	}


	/**
	 * 列出管理员
	 */
	@Override
	public List<Admin> adminList(int start, int end, String where) {
		List<Admin> list = ad.adminList(start, end, where);
		return list;
	}


	/**
	 * 添加管理员
	 */
	@Override
	public boolean addAdmin(Admin admin) {
		int i = ad.addAdmin(admin);
		if(i>0) {
			return true;
		}
		return false;
	}


	/**
	 * 删除管理员
	 */
	@Override
	public boolean delAdmin(Integer id) {
		int i = ad.delAdmin(id);
		if(i>0) {
			return true;
		}
		return false;
	}


	/**
	 * 修改管理员（查询）
	 */
	@Override
	public Admin updAdmin(Integer id) {
		Admin user = ad.updAdmin(id);
		return user;
	}


	/**
	 * 管理员修改（入库）
	 */
	@Override
	public boolean updAdmin_inn(Admin admin) {
		int i = ad.updAdmin_inn(admin);
		if(i>0) {
			return true;
		}
		return false;
	}


	/**
	 * 管理员总数量(where用于分页)
	 */
	@Override
	public int countAdmin(String where) {
		int count = ad.countAdmin(where);
		return count;
	}


	/**
	 * 修改密码
	 */
	@Override
	public boolean changeMiMa(Admin admin) {
		int i = ad.changeMiMa(admin);
		if(i>0) {
			return true;
		}
		return false;
	}
}
