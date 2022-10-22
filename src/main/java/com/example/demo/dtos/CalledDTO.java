package com.example.demo.dtos;

import java.io.Serializable;

import com.example.demo.entities.Called;
import com.example.demo.entities.Product;
import com.example.demo.entities.User;

public class CalledDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String titulo;
	private String descricao;
	private String imgUrl;
	private String situacao;
	private User user;
	private Product product;

	public CalledDTO() {

	}

	public CalledDTO(Called obj) {
		this.id = obj.getId();
		this.titulo = obj.getTitulo();
		this.descricao = obj.getDescricao();
		this.imgUrl = obj.getImgUrl();
		this.situacao = obj.getSituacao();
		this.user = obj.getUser();
		this.product = obj.getProduct();
	}

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

}
