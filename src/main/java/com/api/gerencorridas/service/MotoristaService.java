package com.api.gerencorridas.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.gerencorridas.model.Motorista;
import com.api.gerencorridas.repository.EnderecoRepository;
import com.api.gerencorridas.repository.MotoristaRepo;

@Service
@Transactional
public class MotoristaService {

	@Autowired MotoristaRepo motoristaRepo;
	@Autowired EnderecoRepository enderecoRepository;
	public void salvar(Motorista motorista) {
		enderecoRepository.save(motorista.getEndereco());
		motoristaRepo.save(motorista);
	}

	public Motorista buscar(int id) {
		if (motoristaRepo.existsById(id))
			return motoristaRepo.findById(id).get();
		else
			return new Motorista();
	}

	public List<Motorista> buscarListaMotoristas() {
		List<Motorista> lista = new ArrayList<>();
		motoristaRepo.findAll().forEach(x -> lista.add(x));
		return lista;
	}

	public Motorista alterarMotorista(Motorista motorista) {
		return motoristaRepo.save(motorista);
	}

	public boolean deletarMotorista(int id) {
		if (motoristaRepo.existsById(id)) {
			motoristaRepo.deleteById(id);
			return true;
		} else
			return false;
	}
}
