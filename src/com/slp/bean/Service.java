package com.slp.bean;

public class Service {

	private Integer id;
	private String serviceName;
	private String serviceTitle;
	private String serviceContent;
	private String serviceImg;

	public Service() {

	}

	public Service(Integer id, String serviceName, String serviceTitle, String serviceContent, String serviceImg) {
		super();
		this.id = id;
		this.serviceName = serviceName;
		this.serviceTitle = serviceTitle;
		this.serviceContent = serviceContent;
		this.serviceImg = serviceImg;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getServiceTitle() {
		return serviceTitle;
	}

	public void setServiceTitle(String serviceTitle) {
		this.serviceTitle = serviceTitle;
	}

	public String getServiceContent() {
		return serviceContent;
	}

	public void setServiceContent(String serviceContent) {
		this.serviceContent = serviceContent;
	}

	public String getServiceImg() {
		return serviceImg;
	}

	public void setServiceImg(String serviceImg) {
		this.serviceImg = serviceImg;
	}



}
