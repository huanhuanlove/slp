package com.slp.service;

import java.util.List;

import com.slp.bean.Banner;

public interface BannerService {

	/**
	 * 列出所有banner
	 */
	public List<Banner> bannerList(int start, int end, String where);

	/**
	 * 添加banner
	 */
	public boolean addbanner(Banner banner);

	/**
	 * banner总数
	 */
	public int bannerCount();

	/**
	 * banner删除
	 */
	public boolean delbanner(Integer id);

	/**
	 * banner修改（查询）
	 */
	public Banner updBanner(Integer id);


	/**
	 * banner修改（入库）
	 */
	public boolean updBanner_inn(Banner banner);
}
