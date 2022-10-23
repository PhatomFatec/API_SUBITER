package com.example.demo.dtos;

import java.io.Serializable;

import com.example.demo.entities.Equip;

public class EquipDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String descricao;
	private String nome;
	private String numeroDeSerie;
	private Boolean disponibilidade;

	public EquipDTO() {

	}

	public EquipDTO(Equip obj) {
		this.id = obj.getId();
		this.descricao = obj.getDescricao();
		this.nome = obj.getNome();
		this.numeroDeSerie = obj.getNumeroDeSerie();
		this.disponibilidade = obj.getDisponibilidade();

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
