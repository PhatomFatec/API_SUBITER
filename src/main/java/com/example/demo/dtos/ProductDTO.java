package com.example.demo.dtos;

import java.io.Serializable;
import java.time.Instant;

import com.example.demo.entities.Product;
import com.example.demo.entities.User;
import com.fasterxml.jackson.annotation.JsonFormat;

public class ProductDTO implements Serializable {
private static final long serialVersionUID = 1L;

	private Long id;
	private String modelo;
	private String numeroDeSerie;
	private String descricao;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant dataFabricacao;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "America/Sao_Paulo")
	private Instant dataCadastro;
	private User user;

	public ProductDTO() {

	}

	public ProductDTO(Product obj) {
		id = obj.getId();
		modelo = obj.getModelo();
		numeroDeSerie = obj.getNumeroDeSerie();
		descricao = obj.getDescricao();
		user = obj.getUser();

	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getNumeroDeSerie() {
		return numeroDeSerie;
	}

	public void setNumeroDeSerie(String numeroDeSerie) {
		this.numeroDeSerie = numeroDeSerie;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Instant getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(Instant dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	public Instant getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Instant dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
