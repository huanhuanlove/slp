package com.slp.dao;

import java.util.List;

import com.slp.bean.SizeInfo;

public interface SizeInfoDao {

	public List<SizeInfo> sizeInfoList(int start, int end, String where);
	public int sizeInfoCount();
	public int sizeInfoAdd(SizeInfo sizeInfo);
	public int sizeInfoDel(Integer id);
	public SizeInfo sizeInfoUpd(Integer id);
	public int sizeInfoUpd_inn(SizeInfo sizeInfo);

}
