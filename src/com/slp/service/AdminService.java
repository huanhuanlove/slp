package com.slp.service;

import java.util.List;

import com.slp.bean.Admin;

public interface AdminService {

	/**
	 * 实现登录
	 */
	public boolean adminLogin(Admin admin);


	/**
	 * 列出管理员
	 */
	public List<Admin> adminList(int start, int end, String where);


	/**
	 * 添加管理员
	 */
	public boolean addAdmin(Admin admin);


	/**
	 * 删除管理员
	 */
	public boolean delAdmin(Integer id);


	/**
	 * 修改管理员（查询）
	 */
	public Admin updAdmin(Integer id);


	/**
	 * 管理员修改（入库）
	 */
	public boolean updAdmin_inn(Admin admin);


	/**
	 * 管理员总数量(where用于分页)
	 */
	public int countAdmin(String where);


	/**
	 * 修改密码
	 */
	public boolean changeMiMa(Admin admin);

}
