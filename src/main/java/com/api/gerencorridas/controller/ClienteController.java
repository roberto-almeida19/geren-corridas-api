package com.api.gerencorridas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.gerencorridas.model.Cliente;
import com.api.gerencorridas.service.ClienteService;
import com.api.gerencorridas.service.EnderecoService;

@RestController
public class ClienteController {

	@Autowired	ClienteService clienteService;
	@Autowired EnderecoService enderecoService; 

	@PostMapping(value="/clientes")
	public void salvar(@RequestBody Cliente cliente) {
		enderecoService.salvar(cliente.getEndereco());
		clienteService.salvar(cliente);
	}
	
	@GetMapping(value="/clientes/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Cliente buscarPorId(@PathVariable("id") int id){
		return clienteService.buscar(id);
	}
	@GetMapping(value="/clientes", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Cliente> buscarTodosClientes(){
		return clienteService.buscarListaClientes();
	}
	@ResponseBody
	@DeleteMapping("/clientes/{id}")
	public String deletarCliente(@PathVariable("id") int id) {
		if (clienteService.deletarCliente(id))
			return "Deletado";
		else
			return "Não foi possível completar sua transacao";
	}
	
	@PutMapping(value="/clientes", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Cliente alterarCliente (@RequestBody Cliente cliente){
		return clienteService.alterarCliente(cliente);
	} 
	
}
