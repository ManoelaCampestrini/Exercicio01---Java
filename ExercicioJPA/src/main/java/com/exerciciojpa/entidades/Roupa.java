package com.exerciciojpa.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Roupa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 50, nullable = false, unique = true)
	private String modelo;
	@Column(length = 30)
	private String cor;
	@Column(length = 50, nullable = false)
	private String tecido;
	
	public Roupa() {
	}
	public Roupa(String modelo, String cor, String tecido) {
		this.modelo = modelo;
		this.cor = cor;
		this.tecido = tecido;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getTecido() {
		return tecido;
	}
	public void setTecido(String tecido) {
		this.tecido = tecido;
	}
	
	
}
