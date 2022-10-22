package com.example.demo.dtos;

import java.io.Serializable;
import java.util.Date;

import com.example.demo.entities.Called;
import com.example.demo.entities.Schedule;

public class ScheduleDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String servicoPrestado;
	private String horario;
	private Date data;
	private String endereco;
	private String cidade;
	private String cep;
	private String estado;
	private Called called;

	public ScheduleDTO() {

	}

	public ScheduleDTO(Schedule obj) {
		this.id = obj.getId();
		this.servicoPrestado = obj.getServicoPrestado();
		this.horario = obj.getHorario();
		this.data = obj.getData();
		this.endereco = obj.getEndereco();
		this.cidade = obj.getCidade();
		this.cep = obj.getCep();
		this.estado = obj.getEstado();

		this.called = obj.getCalled();
	}

	public Called getCalled() {
		return called;
	}

	public void setCalled(Called called) {
		this.called = called;
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

	public String getServicoPrestado() {
		return servicoPrestado;
	}

	public void setServicoPrestado(String servicoPrestado) {
		this.servicoPrestado = servicoPrestado;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}



}
