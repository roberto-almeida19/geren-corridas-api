package com.api.gerencorridas.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.gerencorridas.model.Carro;
import com.api.gerencorridas.repository.CarroRepository;

@Service
@Transactional
public class CarroService {
	@Autowired
	CarroRepository carroRepository;

	public void salvar(Carro carro) {
		carroRepository.save(carro);
	}

	public Carro buscar(int id) {
		if (carroRepository.existsById(id))
			return carroRepository.findById(id).get();
		else
			return new Carro();
	}

	public List<Carro> buscarListaCarros() {
		List<Carro> lista = new ArrayList<>();
		carroRepository.findAll().forEach(x -> lista.add(x));
		return lista;
	}

	public Carro alterarCarro(Carro carro) {
		return carroRepository.save(carro);
	}

	public boolean deletarCarro(int id) {
		if (carroRepository.existsById(id)) {
			carroRepository.deleteById(id);
			return true;
		} else
			return false;
	}

}
