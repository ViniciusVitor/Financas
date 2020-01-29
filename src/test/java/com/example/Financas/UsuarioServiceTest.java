package com.example.Financas;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Financas.model.repository.UsuarioRepository;
import com.example.Financas.service.UsuarioService;

@SpringBootTest 
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
class UsuarioServiceTest {
	@Autowired
	UsuarioService service;
	@Autowired
	UsuarioRepository repository;
	

	@Test (expected = Test.None.class)
	void deveValidarEmail() {
		//cenário
		repository.deleteAll();
		
		//acao
		service.validarEmail("email@email.com");
		
	}

}


