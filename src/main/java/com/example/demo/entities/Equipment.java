package com.example.demo.entities;

import java.sql.Date;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Equipment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "America/Sao_Paulo")
	private Instant dataCadastro;

	private Date dataFabricacao;
	private String descricao;
	private String numeroDeSerie;
	private Boolean disponibilidade;

	@JsonIgnore
	@ManyToMany(mappedBy = "equipment")
	private Set<Schedule> schedule = new HashSet<>();

	public Equipment() {

	}

	public Equipment(Long id, String nome,  Date dataFabricacao, String descricao,
			String numeroDeSerie, Boolean disponibilidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataCadastro = Instant.now();
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
