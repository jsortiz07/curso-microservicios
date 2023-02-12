package com.carroservice.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.carroservice.entity.Carro;
import com.carroservice.repository.CarroRepository;

@Service

public class CarroService {

	@Autowired
	private CarroRepository carroRepository;
	
	public List<Carro> getAll(){
		return carroRepository.findAll();
		
	}
	
	public Carro getCarroById(int id) {
		
		return carroRepository.findById(id).orElse(null);
		
	}
	
	public Carro save(Carro car) {
		
		Carro carroNew = carroRepository.save(car);
		
		return carroNew;
	}
	
	public List<Carro> byUsuarioId(int usuarioId){
		
		return carroRepository.findByUsuarioId(usuarioId);
	}
	
}
