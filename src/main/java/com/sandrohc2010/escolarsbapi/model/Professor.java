package com.sandrohc2010.escolarsbapi.model;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "professor")
// @JsonIgnoreProperties(value= {"data_registro, data_modificacao"}, allowGetters = true)
@EntityListeners(AuditingEntityListener.class)
public class Professor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pro_id")
	private Long id;

	@Column(name = "pro_nome", nullable = false)
	private String nome;

	@Column(name = "prodt_nascimento", nullable = false)
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date nascimento;

	@Column(name = "prodt_registro", nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date dt_registro;

	@Column(name = "prodt_modificacao", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date dt_modificacao;

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

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public Date getDt_registro() {
		return dt_registro;
	}

	public void setDt_registro(Date dt_registro) {
		this.dt_registro = dt_registro;
	}

	public Date getDt_modificacao() {
		return dt_modificacao;
	}

	public void setDt_modificacao(Date dt_modificacao) {
		this.dt_modificacao = dt_modificacao;
	}
}
