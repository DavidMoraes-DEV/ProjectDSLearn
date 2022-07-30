package com.devsuperior.dslearnbds.services.exceptions;

//Esse tratamento é para o COD. 401 quando passa um token inválido ou em branco não sendo autorizado então a acessar o recurso
public class UnauthorizedException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public UnauthorizedException(String msg) {
		super(msg);
	}
}
