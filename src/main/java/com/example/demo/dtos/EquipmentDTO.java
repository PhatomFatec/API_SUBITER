package com.example.demo.dtos;

import java.sql.Date;
import java.time.Instant;

public class EquipmentDTO {
	private Long id;
	private String nome;
	private Instant dataCadastro;
	private Date dataFabricacao;
	private String descricao;
	private String numeroDeSerie;
	private Boolean disponibilidade;
	
	

	
	public EquipmentDTO(Long id, String nome, Instant dataCadastro, Date dataFabricacao, String descricao, String numeroDeSerie,
			Boolean disponibilidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataCadastro = dataCadastro;
		this.dataFabricacao = dataFabricacao;
		this.descricao = descricao;
		this.numeroDeSerie = numeroDeSerie;
		this.disponibilidade = disponibilidade;
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



