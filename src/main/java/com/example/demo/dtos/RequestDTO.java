package com.example.demo.dtos;

import java.io.Serializable;

import com.example.demo.entities.Request;
import com.example.demo.entities.User;

public class RequestDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String title;
	private String description;
	private String imgUrl;
	private String status;
	private User user;

	public RequestDTO() {

	}

	public RequestDTO(Request obj) {
		this.id = obj.getId();
		this.title = obj.getTitle();
		this.description = obj.getDescription();
		this.imgUrl = obj.getImgUrl();
		this.status = obj.getStatus();
		this.setUser(obj.getUser());

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
