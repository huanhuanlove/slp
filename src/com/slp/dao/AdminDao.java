package com.slp.dao;

import java.util.List;

import com.slp.bean.Admin;

public interface AdminDao {

	/**
	 * 登录验证
	 */
	public Admin adminLogin(Admin admin);


	/**
	 * 输出管理员(分页,模糊查询)
	 */
	public List<Admin> adminList(int start, int end, String where);


	/**
	 * 管理员添加
	 */
	public int addAdmin(Admin admin);


	/**
	 * 管理员删除
	 */
	public int delAdmin(Integer id);


	/**
	 * 管理员修改（查询）
	 */
	public Admin updAdmin(Integer id);


	/**
	 * 管理员修改（入库）
	 */
	public int updAdmin_inn(Admin admin);


	/**
	 * 管理员总数量(where用于分页)
	 */
	public int countAdmin(String where);


	/**
	 * 修改密码
	 */
	public int changeMiMa(Admin admin);

}
