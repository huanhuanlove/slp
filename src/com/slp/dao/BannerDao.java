package com.slp.dao;

import java.util.List;

import com.slp.bean.Banner;

public interface BannerDao {

	/**
	 * 列出所有banner
	 */
	public List<Banner> bannerList(int start, int end, String where);


	/**
	 * 添加banner
	 */
	public int addbanner(Banner banner);

	/**
	 * 算出所有banner
	 */
	public int bannerCount();


	/**
	 * banner删除
	 */
	public int delBanner(Integer id);


	/**
	 * banner修改（查询）
	 */
	public Banner updBanner(Integer id);


	/**
	 * banner修改（入库）
	 */
	public int updBanner_inn(Banner banner);


}
