package com.api.gerencorridas.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.gerencorridas.model.Corrida;
import com.api.gerencorridas.repository.CorridaRepository;
import com.api.gerencorridas.repository.MotoristaRepository;

@Service
@Transactional
public class CorridaService {

	@Autowired	CorridaRepository corridaRepository;
	@Autowired MotoristaRepository motoristaRepo;
	public void salvar(Corrida corrida) {
		
		
		
		
		corridaRepository.save(corrida);
	}

	public Corrida buscar(int id) {
		if (corridaRepository.existsById(id))
			return corridaRepository.findById(id).get();
		else
			return new Corrida();
	}

	public List<Corrida> buscarListaCorridas() {
		List<Corrida> lista = new ArrayList<>();
		corridaRepository.findAll().forEach(x -> lista.add(x));
		return lista;
	}

	public Corrida alterarCorrida(Corrida cliente) {
		return corridaRepository.save(cliente);
	}

	public boolean deletarCorrida(int id) {
		if (corridaRepository.existsById(id)) {
			corridaRepository.deleteById(id);
			return true;
		} else
			return false;
	}

}
