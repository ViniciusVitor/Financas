package com.example.Financas;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.Financas.model.entity.Usuario;
import com.example.Financas.model.repository.UsuarioRepository;
import com.example.Financas.service.UsuarioService;


@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
class UsuarioSTest {

	@Autowired
	UsuarioRepository repository;
	@Autowired
	UsuarioService service;
	
	@Test 
	 void deveValidarEmail() {
		//cenário
		repository.deleteAll();
		
		//ação/execução
		service.validarEmail("email@email.com");
		
	}
	
	@Test 
	public void deveLancarErroAoValidarEmailQuandoExistirEmailCadastrado() {
		//cenário
		Usuario usuario = Usuario.builder().nome("usuario").email("email@email.com").build();
		repository.save(usuario);
		
		//acao
		service.validarEmail("email@email.com");
	}

}
