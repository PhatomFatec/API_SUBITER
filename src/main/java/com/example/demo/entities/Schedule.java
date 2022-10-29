package com.example.demo.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Schedule implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sc_id")
	private Long id;
	private String servicoPrestado;
	private String horario;

	@Temporal(TemporalType.DATE)
	private Date data;

	private String endereco;
	private String cidade;
	private String cep;
	private String estado;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "America/Sao_Paulo")
	private Instant criacaoChamado;

	@OneToOne
	@MapsId
	private Called called;

	@ManyToMany
	@JoinTable(name = "equip_schedule", 
	joinColumns = @JoinColumn(name = "sc_id"), 
	inverseJoinColumns = @JoinColumn(name = "eq_id"))
	private Set<Equip> equipments = new HashSet<>();

	public Schedule() {
	}

	public Schedule(Long id, String servicoPrestado, String horario, Date data, String endereco, String cidade,
			String cep, String estado, Called called) {
		super();
		this.id = id;
		this.servicoPrestado = servicoPrestado;
		this.horario = horario;
		this.data = data;
		this.endereco = endereco;
		this.cidade = cidade;
		this.cep = cep;
		this.estado = estado;
		this.criacaoChamado = Instant.now();
		this.called = called;
	}

	public Called getCalled() {
		return called;
	}

	public void setCalled(Called called) {
		this.called = called;
	}

	public Set<Equip> getEquipment() {
		return equipments;
	}

	public void setEquipment(Set<Equip> equipment) {
		this.equipments = equipment;
	}

	public Instant getCriacaoChamado() {
		return criacaoChamado;
	}

	public void setCriacaoChamado(Instant criacaoChamado) {
		this.criacaoChamado = criacaoChamado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
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
		Schedule other = (Schedule) obj;
		return Objects.equals(id, other.id);
	}

	public String getServicoPrestado() {
		return servicoPrestado;
	}

	public void setServicoPrestado(String servicoPrestado) {
		this.servicoPrestado = servicoPrestado;
	}

}
