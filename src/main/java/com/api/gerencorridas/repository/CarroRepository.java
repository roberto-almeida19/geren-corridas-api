package com.api.gerencorridas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.gerencorridas.model.Carro;
@Repository
public interface CarroRepository extends JpaRepository<Carro, Integer> {

}
