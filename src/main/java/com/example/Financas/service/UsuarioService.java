package com.example.Financas.service;

import com.example.Financas.model.entity.Usuario;

public interface UsuarioService {
	
	Usuario autenticar (String email, String senha);
	Usuario salvarUsuario (Usuario usuario);
	void validarEmail(String email);

}
