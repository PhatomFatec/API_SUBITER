package com.example.demo.dtos;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

import com.example.demo.entities.Schedule;
import com.fasterxml.jackson.annotation.JsonFormat;

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
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "America/Sao_Paulo")
	private Instant criacaoChamado;

	public ScheduleDTO() {

	}


	public ScheduleDTO(Long id, String servicoPrestado, String horario, Date data, String endereco, String cidade,
			String cep, String estado, Instant criacaoChamado) {
		super();
		this.id = id;
		this.servicoPrestado = servicoPrestado;
		this.horario = horario;
		this.data = data;
		this.endereco = endereco;
		this.cidade = cidade;
		this.cep = cep;
		this.estado = estado;
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


	public Instant getCriacaoChamado() {
		return criacaoChamado;
	}


	public void setCriacaoChamado(Instant criacaoChamado) {
		this.criacaoChamado = criacaoChamado;
	}

}
