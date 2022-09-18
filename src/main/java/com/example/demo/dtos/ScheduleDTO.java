package com.example.demo.dtos;

import java.io.Serializable;

import com.example.demo.entities.Schedule;

public class ScheduleDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String horario;
	private String endereco;
	private String cidade;
	private String cep;
	private String estado;

	public ScheduleDTO() {

	}

	public ScheduleDTO(Schedule obj) {
		id = obj.getId();
		horario = obj.getHorario();
		endereco = obj.getEndereco();
		cidade = obj.getCidade();
		cep = obj.getCep();
		estado = obj.getEstado();

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

}
