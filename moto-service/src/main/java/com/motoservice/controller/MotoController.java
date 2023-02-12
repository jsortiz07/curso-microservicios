package com.motoservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.motoservice.entity.Moto;
import com.motoservice.servicio.MotoService;

@RestController
@RequestMapping("/moto")
public class MotoController {

	
	@Autowired
	private MotoService motoService;
	
	
	// se consultan todas las motos registradas
	@GetMapping
	public ResponseEntity<List<Moto>>listarCarros(){
		List<Moto> motos = motoService.getAll();
		if (motos.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(motos);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Moto> obtenerMoto(@PathVariable("id") int id){
		Moto moto = motoService.getMotoById(id);
		if (moto == null) {
			
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(moto);
	}
	
	@PostMapping
	public ResponseEntity<Moto> guardarMoto(@RequestBody Moto moto){
		Moto newMoto= motoService.save(moto);
		
		return ResponseEntity.ok(newMoto);
	}
	
	
	//buscar moto por id de usuario
	@GetMapping("/usuario/{usuarioId}")
	
	public ResponseEntity<List<Moto>> listarMotos(@PathVariable("usuarioId") int usuarioId){
		List<Moto> motos = motoService.byUsuarioId(usuarioId);
		
		if (motos.isEmpty()) {
			
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(motos);
	}
	
	
}
