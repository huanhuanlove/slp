package com.slp.service;

import java.util.List;

import com.slp.bean.Service;

public interface ServiceService {

	/**
	 * 列出所有Service
	 */
	public List<Service> ServiceList(int start, int end, String where);

	/**
	 * 添加Service
	 */
	public boolean addService(Service service);

	/**
	 * Service总数
	 */
	public int ServiceCount(String where);

	/**
	 * Service删除
	 */
	public boolean delService(Integer id);

	/**
	 * Service修改（查询）
	 */
	public Service updService(Integer id);


	/**
	 * Service修改（入库）
	 */
	public boolean updService_inn(Service service);
}
