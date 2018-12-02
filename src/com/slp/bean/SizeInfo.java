package com.slp.bean;

/**
 *  站点信息
 */
public class SizeInfo {

	private Integer id;
	private String name;
	private String content;
	private String infoImg;


	public SizeInfo() {

	}


	public SizeInfo(Integer id, String name, String content, String infoImg) {
		super();
		this.id = id;
		this.name = name;
		this.content = content;
		this.infoImg = infoImg;
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


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getInfoImg() {
		return infoImg;
	}


	public void setInfoImg(String infoImg) {
		this.infoImg = infoImg;
	}



}
