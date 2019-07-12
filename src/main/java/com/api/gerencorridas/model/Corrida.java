package com.api.gerencorridas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Corrida {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToOne
	private Cliente cliente;
	@OneToOne
	private Motorista motorista;
	@OneToOne
	private Carro carro;
	public Corrida( Cliente cliente, Motorista motorista, Carro carro) {
		super();
		this.cliente = cliente;
		this.motorista = motorista;
		this.carro = carro;
	}
	public Corrida() {	}
	
	
	
	
	
}
