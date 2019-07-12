package com.api.gerencorridas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.gerencorridas.model.Cliente;
@Repository
public interface ClienteReposity extends JpaRepository<Cliente, Integer>{}