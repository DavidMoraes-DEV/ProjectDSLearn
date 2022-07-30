package com.devsuperior.dslearnbds.services.exceptions;

//Utilizada para retornar o erro 403 que é o erro quando o usuário esta logado e o token é válido porém o perfil dele não esta autorizado a acessar aquele recurso.
//Obs.: Se diferencia do Cod. 401 que é quando é passado um token INVÁLIDO
public class ForbiddenException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ForbiddenException(String msg) {
		super(msg);
	}
}
