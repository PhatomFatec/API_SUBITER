package com.example.demo.dtos;

import java.io.Serializable;
import java.time.Instant;

import com.example.demo.entities.Called;
import com.example.demo.entities.Product;
import com.example.demo.entities.User;
import com.fasterxml.jackson.annotation.JsonFormat;

public class CalledDTO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	private Long id;
	private String titulo;
	private String descricao;
	private String imgUrl;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "America/Sao_Paulo")
	private Instant dataChamado;
	private User user;
	private Product product;

	public CalledDTO(){
		
	}
	
public CalledDTO(Called obj){
		id = obj.getId();
		titulo = obj.getTitulo();
		descricao = obj.getDescricao();
		imgUrl = obj.getImgUrl();
		dataChamado = obj.getDataChamado();
		user = obj.getUser();
		product = obj.getProduct();
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

public Instant getDataChamado() {
	return dataChamado;
}

public void setDataChamado(Instant dataChamado) {
	this.dataChamado = dataChamado;
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


	
}
