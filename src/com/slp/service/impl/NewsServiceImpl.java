package com.slp.service.impl;

import java.util.List;

import com.slp.bean.News;
import com.slp.dao.NewsDao;
import com.slp.dao.impl.NewsDaoImpl;
import com.slp.service.NewsService;

public class NewsServiceImpl implements NewsService {

	/**
	 * 实例化newsdao
	 */
	NewsDao nd = new NewsDaoImpl();

	/**
	 * 列出所有news
	 */
	@Override
	public List<News> newsList() {
		return nd.newsList();
	}

}
