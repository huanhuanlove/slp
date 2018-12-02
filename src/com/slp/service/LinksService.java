package com.slp.service;

import java.util.List;

import com.slp.bean.Links;

public interface LinksService {

	public List<Links> linksList(String tablename, int currentpage, int pagesize);
}
