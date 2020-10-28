package br.edu.unichristus.livrariaapi20202.excecoes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.PRECONDITION_FAILED)
public class AutorJaPossuiLivrosException extends RuntimeException {

	public AutorJaPossuiLivrosException(Long id) {
		super("O autor com o id " + id + " não pode ser removido porque possui livros!");
	}

}
