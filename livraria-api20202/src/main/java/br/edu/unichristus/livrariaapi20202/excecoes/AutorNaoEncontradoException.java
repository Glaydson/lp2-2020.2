package br.edu.unichristus.livrariaapi20202.excecoes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AutorNaoEncontradoException extends RuntimeException {

	public AutorNaoEncontradoException(Long id) {
		super("O autor com o ID " + id + " não foi encontrado.");
	}

	
}
