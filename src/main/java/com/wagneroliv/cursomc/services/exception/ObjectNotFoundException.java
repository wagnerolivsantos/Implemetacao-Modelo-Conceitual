package com.wagneroliv.cursomc.services.exception;

public class ObjectNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundException(String mensagem) {
		super(mensagem);
	}
	
	// Construtor que recebe a causa que aconteceu antes.
	public ObjectNotFoundException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
