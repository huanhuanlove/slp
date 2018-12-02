package com.slp.bean;

public class Team {

	private Integer id;
	private String name;
	private String position;
	private String photo;

	public Team() {

	}

	public Team(Integer id, String name, String position, String photo) {
		super();
		this.id = id;
		this.name = name;
		this.position = position;
		this.photo = photo;
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

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}




}
