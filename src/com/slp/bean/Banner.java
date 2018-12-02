package com.slp.bean;

public class Banner {

	private Integer id;
	private String name;
	private String url;
	private String bannerImg;

	public Banner() {

	}

	public Banner(Integer id, String name, String url, String bannerImg) {
		super();
		this.id = id;
		this.name = name;
		this.url = url;
		this.bannerImg = bannerImg;
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

	public String getBannerImg() {
		return bannerImg;
	}

	public void setBannerImg(String bannerImg) {
		this.bannerImg = bannerImg;
	}



}
