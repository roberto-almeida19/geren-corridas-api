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
		montarCliente();
		montarMotorista();
		montarCorrida();
	}
	private static void montarCorrida() {
		Corrida corrida = new Corrida();
		Cliente cliente = new Cliente();
		cliente.setId(1);
		corrida.setCliente(cliente);
		Motorista motorista =  new Motorista();
		motorista.setId(1);
		corrida.setMotorista(motorista);
		System.out.println(new Gson().toJson(corrida));
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
		motorista.setUrlFoto("TESTE");
		System.out.println(new Gson().toJson(motorista));
	}
	
	private static void montarCliente() {
		Cliente cliente = new Cliente();
		cliente.setNome("José Bundão");
		Endereco endereco = new Endereco("Rua anisio de abreu", 384, "03817020", "São Paulo", "SP", "Brazil");
		cliente.setEndereco(endereco);
		System.out.println(new Gson().toJson(cliente));
	}
}
