package br.edu.unichristus.livrariaapi20202.excecoes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LivroNaoEncontradoException extends RuntimeException {

	
	public LivroNaoEncontradoException(Long id) {
		super("Livro com o ID " + id + " não encontrado.");

	}

}
