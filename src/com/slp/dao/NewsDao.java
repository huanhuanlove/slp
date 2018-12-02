package com.slp.dao;

import java.util.List;

import com.slp.bean.News;

public interface NewsDao {

	/**
	 * 列出所有的news
	 */
	public List<News> newsList();
}
