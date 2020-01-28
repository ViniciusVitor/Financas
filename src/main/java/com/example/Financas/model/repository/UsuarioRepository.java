package com.example.Financas.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Financas.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	//Optional<Usuario> findByEmail(String email);
	boolean existsByEmail(String email);
}
