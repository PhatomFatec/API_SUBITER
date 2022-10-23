package com.example.demo.dtos;

import java.io.Serializable;
import java.util.Date;

import com.example.demo.entities.Equipment;

public class EquipmentDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nome;
	private Date dataFabricacao;
	private String descricao;
	private String numeroDeSerie;
	private Boolean disponibilidade;

	public EquipmentDTO(Equipment obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.dataFabricacao = obj.getDataFabricacao();
		this.descricao = obj.getDescricao();
		this.numeroDeSerie = obj.getNumeroDeSerie();
		this.disponibilidade = obj.getDisponibilidade();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(Date dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNumeroDeSerie() {
		return numeroDeSerie;
	}

	public void setNumeroDeSerie(String numeroDeSerie) {
		this.numeroDeSerie = numeroDeSerie;
	}

	public Boolean getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(Boolean disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

}
