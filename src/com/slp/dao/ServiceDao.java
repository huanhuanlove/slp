package com.slp.dao;

import java.util.List;

import com.slp.bean.Service;

public interface ServiceDao {

	public List<Service> serviceList(int start, int end, String where);
	public int serviceAdd(Service service);
	public int serviceDel(Integer id);
	public Service serviceUpd(Integer id);
	public int serviceUpd_inn(Service service);
	public int serviceCount(String where);

}
