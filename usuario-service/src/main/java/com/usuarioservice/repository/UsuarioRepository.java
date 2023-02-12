package com.usuarioservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usuarioservice.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
