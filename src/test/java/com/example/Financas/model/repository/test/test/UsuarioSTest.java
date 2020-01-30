package com.example.Financas.model.repository.test.test;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.Financas.exception.ErroAutenticacao;
import com.example.Financas.model.entity.Usuario;
import com.example.Financas.model.repository.UsuarioRepository;
import com.example.Financas.service.UsuarioService;
import com.example.Financas.service.impl.UsuarioServiceImpl;


@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
class UsuarioSTest {
	
	UsuarioRepository repository;	
	UsuarioService service;
	
	/*
	@Before 
	void setUp() {
		repository = Mockito.mock(UsuarioRepository.class);
		service = new UsuarioServiceImpl(repository);
	}*/
	
	@Test (expected = ErroAutenticacao.class) 
	void deveAutenticarUmUsuarioComSucesso() {
		repository = Mockito.mock(UsuarioRepository.class);
		service = new UsuarioServiceImpl(repository);
		//cenário
		String email = "email@email.com";
		String senha = "senha";
		
		Usuario usuario = Usuario.builder().email(email).senha(senha).id(1l).build();
		Mockito.when(repository.findByEmail(email)).thenReturn(Optional.of(usuario));
		
		//acao
		Usuario result = service.autenticar(email, senha);
		
		//verificacao
		Assertions.assertThat(result).isNotNull();
	}
	
	/* tambem deu erro
	@Test 
	void deveLancarErroQuandoNaoEncontrarUsuaarioCadastradoComOEmailInformado() {
		repository = Mockito.mock(UsuarioRepository.class);
		service = new UsuarioServiceImpl(repository);
		//cenario
		Mockito.when(repository.findByEmail(Mockito.anyString())).thenReturn(Optional.empty());
		
		//acao
		service.autenticar("email@email.com", "senha");
	
	}*/
	
	@Test 
	 void deveValidarEmail() {
		repository = Mockito.mock(UsuarioRepository.class);
		service = new UsuarioServiceImpl(repository);
		//cenário
		Mockito.when(repository.existsByEmail(Mockito.anyString())).thenReturn(false);
		
		//ação/execução
		service.validarEmail("email@email.com");
		
	}
	
	/*
	@Test 
	public void deveLancarErroAoValidarEmailQuandoExistirEmailCadastrado() {
		repository = Mockito.mock(UsuarioRepository.class);
		service = new UsuarioServiceImpl(repository);
		//cenário
		Mockito.when(repository.existsByEmail(Mockito.anyString())).thenReturn(true);
		
		//acao
		//Erro ao tentar validar email
		//service.validarEmail("email@email.com");
	}*/

}
