package com.api.gerencorridas.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.gerencorridas.model.Cliente;
import com.api.gerencorridas.repository.ClienteReposity;

@Service
@Transactional
public class ClienteService {

	@Autowired ClienteReposity clienteReposity;
	
	public void salvar(Cliente cliente) {
		clienteReposity.save(cliente);
	}
	
	public Cliente buscar(int id) {
			if (clienteReposity.existsById(id)) 
				return clienteReposity.findById(id).get();
			else
				return new Cliente();
		}
	
	public List<Cliente> buscarListaClientes(){
		List<Cliente> lista = new ArrayList<>();
		clienteReposity.findAll().forEach(x -> lista.add(x));
		return lista;
	}
	
	public Cliente alterarCliente(Cliente cliente) {
		return clienteReposity.save(cliente);
	}
	
	public boolean deletarCliente(int id) {
		if (clienteReposity.existsById(id)) {
			clienteReposity.deleteById(id);
			return true;
		}
		else
			return false;
	}
	
}
