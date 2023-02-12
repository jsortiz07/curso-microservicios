package com.carroservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carroservice.entity.Carro;

public interface CarroRepository extends JpaRepository<Carro, Integer> {
	
	List<Carro> findByUsuarioId(int usuarioId);

}
