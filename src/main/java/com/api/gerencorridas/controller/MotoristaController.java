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

import com.api.gerencorridas.model.Motorista;
import com.api.gerencorridas.service.MotoristaService;

@RestController
public class MotoristaController {

	@Autowired MotoristaService motoristaService;
	
	@PostMapping(value="/motoristas")
	public void salvar(@RequestBody Motorista motorista) {
		motoristaService.salvar(motorista);
	}
	
	@GetMapping(value="/motoristas/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Motorista buscarPorId(@PathVariable("id") int id){
		return motoristaService.buscar(id);
	}
	@GetMapping(value="/motoristas", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Motorista> buscarTodosMotoristas(){
		return motoristaService.buscarListaMotoristas();
	}
	@ResponseBody
	@DeleteMapping("/motoristas/{id}")
	public String deletarMotorista(@PathVariable("id") int id) {
		if (motoristaService.deletarMotorista(id))
			return "Deletado";
		else
			return "Não foi possível completar sua transacao";
	}
	
	@PutMapping(value="/motoristas", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Motorista alterarMotorista (@RequestBody Motorista motorista){
		return motoristaService.alterarMotorista(motorista);
	} 
	
	
}
