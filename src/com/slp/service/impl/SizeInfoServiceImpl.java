package com.slp.service.impl;

import java.util.List;

import com.slp.bean.SizeInfo;
import com.slp.dao.SizeInfoDao;
import com.slp.dao.impl.SizeInfoDaoImpl;
import com.slp.service.SizeInfoService;

public class SizeInfoServiceImpl implements SizeInfoService {
	SizeInfoDao si = new SizeInfoDaoImpl();

	@Override
	public List<SizeInfo> sizeInfoList(int start, int end, String where) {
		return si.sizeInfoList(start, end, where);
	}

	@Override
	public int sizeInfoCount() {
		return si.sizeInfoCount();
	}

	@Override
	public boolean sizeInfoAdd(SizeInfo sizeInfo) {
		int i = si.sizeInfoAdd(sizeInfo);
		if(i>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean sizeInfoDel(Integer id) {
		int i =  si.sizeInfoDel(id);
		if(i>0) {
			return true;
		}
		return false;
	}

	@Override
	public SizeInfo sizeInfoUpd(Integer id) {
		return si.sizeInfoUpd(id);
	}

	@Override
	public boolean sizeInfoUpd_inn(SizeInfo sizeInfo) {
		int i = si.sizeInfoUpd_inn(sizeInfo);
		if(i>0) {
			return true;
		}
		return false;
	}


}
