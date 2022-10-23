package com.example.demo.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Equip implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String descricao;
	private String nome;
	private String numeroDeSerie;
	private Instant dataCadastro;
	private Boolean disponibilidade;

	@ManyToMany
	@JoinTable(name = "equip_schedule", joinColumns = @JoinColumn(name = "equip_id"), inverseJoinColumns = @JoinColumn(name = "schedule_id"))
	private Set<Schedule> schedules = new HashSet<>();

	public Equip() {
	}

	public Equip(Long id, String descricao, String nome, String numeroDeSerie, Boolean disponibilidade) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.nome = nome;
		this.numeroDeSerie = numeroDeSerie;
		this.dataCadastro = Instant.now();
		this.disponibilidade = disponibilidade;
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

	public Instant getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Instant dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Boolean getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(Boolean disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equip other = (Equip) obj;
		return Objects.equals(id, other.id);
	}

}
