package br.edu.unichristus.livrariaapi20202.excecoes;

public class LivroNaoEncontradoException extends RuntimeException {

	public LivroNaoEncontradoException(Long id) {
		super("Livro com o ID " + id + " não encontrado.");

	}

}
