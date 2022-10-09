package com.example.demo.dtos;

import java.sql.Date;
import java.time.Instant;

import com.example.demo.entities.Equipment;

public class EquipmentDTO {
	private Long id;
	private String nome;
	private Instant dataCadastro;
	private Date dataFabricacao;
	private String descricao;
	private String numeroDeSerie;
	private Boolean disponibilidade;

	public EquipmentDTO(Equipment obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.dataCadastro = obj.getDataCadastro();
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

	public Instant getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Instant dataCadastro) {
		this.dataCadastro = dataCadastro;
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

	public void setDisponilidade(Boolean disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

}
