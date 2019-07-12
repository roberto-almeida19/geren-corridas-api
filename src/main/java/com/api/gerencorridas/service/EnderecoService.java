package com.api.gerencorridas.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.gerencorridas.model.Endereco;
import com.api.gerencorridas.repository.EnderecoRepository;

@Service
@Transactional
public class EnderecoService {

	@Autowired
	EnderecoRepository enderecoRepository;

	public void salvar(Endereco endereco) {
		enderecoRepository.save(endereco);
	}

	public Endereco buscar(int id) {
		if (enderecoRepository.existsById(id))
			return enderecoRepository.findById(id).get();
		else
			return new Endereco();
	}

	public List<Endereco> buscarListaEnderecos() {
		List<Endereco> lista = new ArrayList<>();
		enderecoRepository.findAll().forEach(x -> lista.add(x));
		return lista;
	}

	public Endereco alterarEndereco(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}

	public boolean deletarEndereco(int id) {
		if (enderecoRepository.existsById(id)) {
			enderecoRepository.deleteById(id);
			return true;
		} else
			return false;
	}

}
