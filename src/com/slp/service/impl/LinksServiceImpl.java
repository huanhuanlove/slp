package com.slp.service.impl;

import java.util.List;

import com.slp.bean.Links;
import com.slp.dao.LinksDao;
import com.slp.dao.impl.LinksDaoImpl;
import com.slp.service.LinksService;

public class LinksServiceImpl implements LinksService {

	LinksDao ld = new LinksDaoImpl();


	@Override
	public List<Links> linksList(String tablename, int currentpage, int pagesize) {
		return ld.linkList(tablename, currentpage, pagesize);
	}

}
