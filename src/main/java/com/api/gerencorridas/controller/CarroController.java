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

import com.api.gerencorridas.model.Carro;
import com.api.gerencorridas.service.CarroService;

@RestController()
public class CarroController {
	@Autowired CarroService carroService;
	
	@PostMapping(value="/carros")
	public void salvar(@RequestBody Carro carro) {
		carroService.salvar(carro);
	}
	
	@GetMapping(value="/carros/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Carro buscarPorId(@PathVariable("id") int id){
		return carroService.buscar(id);
	}
	@GetMapping(value="/carros", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Carro> buscarTodosCarros(){
		return carroService.buscarListaCarros();
	}
	@ResponseBody
	@DeleteMapping("/carros/{id}")
	public String deletarCarro(@PathVariable("id") int id) {
		if (carroService.deletarCarro(id))
			return "Deletado";
		else
			return "Não foi possível completar sua transacao";
	}
	
	@PutMapping(value="/carros", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Carro alterarCarro (@RequestBody Carro carro){
		return carroService.alterarCarro(carro);
	} 
	
	
}
