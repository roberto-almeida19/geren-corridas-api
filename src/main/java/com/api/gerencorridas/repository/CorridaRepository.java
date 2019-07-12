package com.api.gerencorridas.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.gerencorridas.model.Corrida;

@Repository
public interface CorridaRepository extends CrudRepository<Corrida, Integer>{}
