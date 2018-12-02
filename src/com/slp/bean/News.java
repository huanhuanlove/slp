package com.slp.bean;

public class News {

	private Integer id;
	private String newTitle;
	private int cateId;
	private String newsDate;
	private String newsContent;
	private String newsImg;


	public News() {

	}


	public News(Integer id, String newTitle, int cateId, String newsDate, String newsContent, String newsImg) {
		super();
		this.id = id;
		this.newTitle = newTitle;
		this.cateId = cateId;
		this.newsDate = newsDate;
		this.newsContent = newsContent;
		this.newsImg = newsImg;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNewTitle() {
		return newTitle;
	}


	public void setNewTitle(String newTitle) {
		this.newTitle = newTitle;
	}


	public int getCateId() {
		return cateId;
	}


	public void setCateId(int cateId) {
		this.cateId = cateId;
	}


	public String getNewsDate() {
		return newsDate;
	}


	public void setNewsDate(String newsDate) {
		this.newsDate = newsDate;
	}


	public String getNewsContent() {
		return newsContent;
	}


	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}


	public String getNewsImg() {
		return newsImg;
	}


	public void setNewsImg(String newsImg) {
		this.newsImg = newsImg;
	}




}
