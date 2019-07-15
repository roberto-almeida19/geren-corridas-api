package com.api.gerencorridas.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Motorista {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	@OneToOne
	private Endereco endereco;
	@Column(columnDefinition="text")
	private String urlFoto;
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Carro> carros;
	@OneToMany
	private Set<Corrida> corridas;

	public String getUrlFoto() {
		return urlFoto;
	}

	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}

	public Set<Corrida> getCorridas() {
		return corridas;
	}

	public void setCorridas(Set<Corrida> corridas) {
		this.corridas = corridas;
	}


	public Motorista(String nome) {
		super();
		this.nome = nome;
	}

	public Motorista() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public Set<Carro> getCarros() {
		return carros;
	}

	public void setCarros(Set<Carro> carros) {
		this.carros = carros;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	

}
