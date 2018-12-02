package com.slp.bean;

public class Links {

	private Integer id;
	private String name;
	private String url;
	private String linkImg;

	public Links() {

	}

	public Links(Integer id, String name, String url, String linkImg) {
		super();
		this.id = id;
		this.name = name;
		this.url = url;
		this.linkImg = linkImg;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getLinkImg() {
		return linkImg;
	}

	public void setLinkImg(String linkImg) {
		this.linkImg = linkImg;
	}


}
