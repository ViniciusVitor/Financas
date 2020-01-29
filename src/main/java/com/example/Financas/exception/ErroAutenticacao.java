package com.example.Financas.exception;

public class ErroAutenticacao extends RuntimeException{
	public ErroAutenticacao(String mensagem) {
		super(mensagem);
	}
}
