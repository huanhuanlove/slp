package com.slp.service;

import java.util.List;

import com.slp.bean.News;

public interface NewsService {

	/**
	 * 列出所有news
	 */
	public List<News> newsList();
}
