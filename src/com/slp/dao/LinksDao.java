package com.slp.dao;

import java.util.List;

import com.slp.bean.Links;

public interface LinksDao {

	public List<Links> linkList(String tablename, int currentpage, int pagesize);
}
