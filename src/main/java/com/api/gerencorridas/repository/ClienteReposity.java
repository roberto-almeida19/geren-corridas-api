package com.api.gerencorridas.repository;

import org.springframework.data.repository.CrudRepository;

import com.api.gerencorridas.model.Cliente;

public interface ClienteReposity extends CrudRepository<Cliente, Integer>{}