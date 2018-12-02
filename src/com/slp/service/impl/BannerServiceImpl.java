package com.slp.service.impl;

import java.util.List;

import com.slp.bean.Banner;
import com.slp.dao.BannerDao;
import com.slp.dao.impl.BannerDaoImpl;
import com.slp.service.BannerService;

public class BannerServiceImpl implements BannerService {
	/**
	 * 实例化bannerDao
	 */
	BannerDao bd = new BannerDaoImpl();

	/**
	 * 列出所有banner
	 */
	@Override
	public List<Banner> bannerList(int start, int end, String where) {
		return bd.bannerList(start, end, where);
	}

	/**
	 * 添加banner
	 */
	@Override
	public boolean addbanner(Banner banner) {
		BannerDao bd = new BannerDaoImpl();
		int i = bd.addbanner(banner);
		if(i>0) {
			return true;
		}
		return false;
	}

	/**
	 * banner总数
	 */
	@Override
	public int bannerCount() {
		return bd.bannerCount();
	}

	/**
	 * banner删除
	 */
	@Override
	public boolean delbanner(Integer id) {
		int i = bd.delBanner(id);
		if(i>0) {
			return true;
		}
		return false;
	}

	/**
	 * banner修改（查询）
	 */
	@Override
	public Banner updBanner(Integer id) {
		return bd.updBanner(id);
	}

	/**
	 * banner修改（入库）
	 */
	@Override
	public boolean updBanner_inn(Banner banner) {
		int i = bd.updBanner_inn(banner);
		if(i>0) {
			return true;
		}
		return false;
	}



}
