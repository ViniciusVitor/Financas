package com.example.Financas;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.example.Financas.model.entity.Usuario;
import com.example.Financas.model.repository.UsuarioRepository;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
class FinancasApplicationTests {

	@Autowired
	UsuarioRepository repository;
	
	@Test
	 void deveVerificarAExistenciaDeUmEmail() {
		//cenário
		Usuario usuario = Usuario.builder().nome("usuario").email("usuario@email.com").build();
		repository.save(usuario);
		
		//ação/execução
		boolean result = repository.existsByEmail("usuario@email.com");
		
		//verificação

		Assertions.assertThat(result).isTrue();
	
		
	}
	@Test
	void deveRetornarFalsoQuandoNaoHouverUsuarioCadastradoComOEmail() {
		//cenário
		repository.deleteAll();
		
		//acao
		boolean result = repository.existsByEmail("usuario@email.com");
		
		//verificacao
		Assertions.assertThat(result).isFalse();
	}


}
