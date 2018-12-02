package com.slp.service;

import java.util.List;

import com.slp.bean.SizeInfo;

public interface SizeInfoService {

	public List<SizeInfo> sizeInfoList(int start, int end, String where);
	public int sizeInfoCount();
	public boolean sizeInfoAdd(SizeInfo sizeInfo);
	public boolean sizeInfoDel(Integer id);
	public SizeInfo sizeInfoUpd(Integer id);
	public boolean sizeInfoUpd_inn(SizeInfo sizeInfo);

}
