package com.example.demo.dtos;

import com.example.demo.entities.Comment;
import com.example.demo.entities.Request;
import com.example.demo.entities.User;

public class CommentDTO {

	private Long id;
	private String comment;
	private User user;
	private Request request;

	public CommentDTO() {
	}

	public CommentDTO(Comment obj) {
		this.id = obj.getId();
		this.comment = obj.getComment();
		this.user = obj.getUser();
		this.request = obj.getRequest();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

}
