package com.slp.service.impl;

import java.util.List;

import com.slp.bean.Service;
import com.slp.dao.ServiceDao;
import com.slp.dao.impl.ServiceDaoImpl;
import com.slp.service.ServiceService;

public class ServiceServiceImpl implements ServiceService {

	/**
	 * 实例化service
	 */
	ServiceDao sd = new ServiceDaoImpl();

	/**
	 * 列出所有service
	 */
	@Override
	public List<Service> ServiceList(int start, int end, String where) {
		return sd.serviceList(start, end, where);
	}

	/**
	 * 添加service
	 */
	@Override
	public boolean addService(Service service) {
		int i = sd.serviceAdd(service);
		if(i>0) {
			return true;
		}
		return false;
	}

	/**
	 * service总数
	 */
	@Override
	public int ServiceCount(String where) {
		return sd.serviceCount(where);
	}

	/**
	 * service删除
	 */
	@Override
	public boolean delService(Integer id) {
		int i = sd.serviceDel(id);
		if(i>0) {
			return true;
		}
		return false;
	}

	/**
	 * service修改（查询）
	 */
	@Override
	public Service updService(Integer id) {
		return sd.serviceUpd(id);
	}

	/**
	 * service修改（入库）
	 */
	@Override
	public boolean updService_inn(Service service) {
		int i = sd.serviceUpd_inn(service);
		if(i>0) {
			return true;
		}
		return false;
	}

}
