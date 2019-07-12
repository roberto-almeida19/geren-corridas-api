package com.api.gerencorridas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.gerencorridas.model.Motorista;

@Repository
public interface MotoristaRepository extends JpaRepository<Motorista, Integer>{
	
}
