package com.example.demo.dtos;

import java.io.Serializable;

import com.example.demo.entities.Product;

public class ProductDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String modelo;
	private String numeroDeSerie;
	private String descricao;
	private String dataFabricacao;

	public ProductDTO() {

	}

	public ProductDTO(Product obj) {
		this.id = obj.getId();
		this.modelo = obj.getModelo();
		this.numeroDeSerie = obj.getNumeroDeSerie();
		this.descricao = obj.getDescricao();
		this.dataFabricacao = obj.getDataFabricacao();

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

	public String getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(String dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

}
