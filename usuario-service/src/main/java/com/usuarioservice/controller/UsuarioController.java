package com.usuarioservice.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usuarioservice.entity.Usuario;
import com.usuarioservice.modelos.Carro;
import com.usuarioservice.modelos.Moto;
import com.usuarioservice.servicio.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	public ResponseEntity<List<Usuario>>listarUsuarios(){
		
		List<Usuario> usuarios = usuarioService.getAll();
		if(usuarios.isEmpty()) {
			return ResponseEntity.noContent().build();
			
		}
		return ResponseEntity.ok(usuarios);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> ObetenerUser(@PathVariable("id") int id){
		Usuario usuario = usuarioService.getUsuarioById(id);
		if (usuario == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(usuario);
	}
	
	@PostMapping
	public ResponseEntity<Usuario>saveUser(@RequestBody Usuario usuario){
		Usuario usuarioNew = usuarioService.save(usuario);
		return ResponseEntity.ok(usuarioNew);
	}
	
	@GetMapping("/carros/{usuarioId}")
	
	public ResponseEntity<List<Carro>> listarCarros(@PathVariable("usuarioId") int usuarioId){
		Usuario usuario = usuarioService.getUsuarioById(usuarioId);
		
		if (usuario == null) {
			
			return ResponseEntity.notFound().build();
		}
		
		List<Carro> carros  = usuarioService.getCarros(usuarioId);
		
		return ResponseEntity.ok(carros);
	}
	
	@GetMapping("/motos/{usuarioId}")
	
	public ResponseEntity<List<Moto>> listarMotos(@PathVariable("usuarioId") int usuarioId){
		Usuario usuario = usuarioService.getUsuarioById(usuarioId);
		
		if (usuario == null) {
			return ResponseEntity.notFound().build();
		}
		
		List<Moto> motos = usuarioService.getMotos(usuarioId);
		
		return ResponseEntity.ok(motos);
	}
	
	@PostMapping("/carro/{usuarioId}")
	public ResponseEntity<Carro> guardarCarro(@PathVariable("usuarioId") int usuarioId, @RequestBody Carro carro){
		Carro nuevoCarro = usuarioService.saveCarro(usuarioId, carro);
		
		return ResponseEntity.ok(nuevoCarro);
	}
	
	@PostMapping("/moto/{usuarioId}")
	public ResponseEntity<Moto> guardarMoto(@PathVariable("usuarioId") int usuarioId, @RequestBody Moto moto){
		Moto nuevaMoto = usuarioService.saveMoto(usuarioId, moto);
		
		return ResponseEntity.ok(nuevaMoto);
	}
	
	@GetMapping("/todos/{usuarioId}")
	public ResponseEntity<Map<String, Object>>ListarTodosLosVehiculos(@PathVariable("usuarioId") int usuarioId){
		Map<String, Object> resultado = usuarioService.getUsuariosAndVehiculos(usuarioId);
		return ResponseEntity.ok(resultado);
	}
	

}
