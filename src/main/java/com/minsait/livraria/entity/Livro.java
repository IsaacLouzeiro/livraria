package com.minsait.livraria.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotEmpty(message = "Titulo nao pode ser nulo.")
	private String titulo;
	private Integer ano; 
	
	private Integer quantidade;
	
	public Livro() {
	}
	

	public Livro(long id, String titulo, Integer ano, Integer quantidade) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.ano = ano;
		this.quantidade = quantidade;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public Integer getAno() {
		return ano;
	}


	public void setAno(Integer ano) {
		this.ano = ano;
	}


	public Integer getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	
	
}
