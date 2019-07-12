package com.api.gerencorridas.main;

import java.util.HashSet;
import java.util.Set;

import com.api.gerencorridas.model.Carro;
import com.api.gerencorridas.model.Cliente;
import com.api.gerencorridas.model.Corrida;
import com.api.gerencorridas.model.Endereco;
import com.api.gerencorridas.model.Motorista;
import com.google.gson.Gson;

public class MainTeste {
	public static void main(String[] args) {
		Corrida corrida = new Corrida();
		Motorista motorista = new Motorista();
		Cliente cliente = new Cliente();
		Carro carro = new Carro();
		corrida.setCarro(carro);
		corrida.setCliente(cliente);
		corrida.setMotorista(motorista);
		System.out.println(new Gson().toJson(corrida));
		montarMotorista();
	}

	
	
	
	
	private static void montarMotorista() {
		Motorista motorista = new Motorista();
		motorista.setNome("Roberto Almeida");
		Endereco endereco = new Endereco("Rua anisio de abreu", 384, "03817020", "São Paulo", "SP", "Brazil");
		motorista.setEndereco(endereco);
		Carro carro = new Carro();
		carro.setMarca("VOLVO");
		carro.setModelo("JETTA");
		Set<Carro> carros = new HashSet<>();
		carros.add(carro);
		motorista.setCarros(carros);
		System.out.println(new Gson().toJson(motorista));
	}
}
