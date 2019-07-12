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

import com.api.gerencorridas.model.Corrida;
import com.api.gerencorridas.service.ClienteService;
import com.api.gerencorridas.service.CorridaService;
import com.api.gerencorridas.service.EnderecoService;
import com.api.gerencorridas.service.MotoristaService;

@RestController
public class CorridaController {
	@Autowired CorridaService corridaService;
	@Autowired MotoristaService motoristaService;
	@Autowired ClienteService clienteService;
	@Autowired EnderecoService enderecoService; 

	
	@PostMapping(value="/corridas")
	public void salvar(@RequestBody Corrida corrida) {
		corridaService.salvar(corrida);
	}
	
	@GetMapping(value="/corridas/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Corrida buscarPorId(@PathVariable("id") int id){
		return corridaService.buscar(id);
	}
	@GetMapping(value="/corridas", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Corrida> buscarTodosCorridas(){
		return corridaService.buscarListaCorridas();
	}
	@ResponseBody
	@DeleteMapping("/corridas/{id}")
	public String deletarCorrida(@PathVariable("id") int id) {
		if (corridaService.deletarCorrida(id))
			return "Deletado";
		else
			return "Não foi possível completar sua transacao";
	}
	
	@PutMapping(value="/corridas", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Corrida alterarCorrida (@RequestBody Corrida corrida){
		return corridaService.alterarCorrida(corrida);
	} 

}
