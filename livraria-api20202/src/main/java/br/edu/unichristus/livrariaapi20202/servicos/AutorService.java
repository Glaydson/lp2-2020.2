package br.edu.unichristus.livrariaapi20202.servicos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.unichristus.livrariaapi20202.entidades.Autor;
import br.edu.unichristus.livrariaapi20202.excecoes.AutorJaPossuiLivrosException;
import br.edu.unichristus.livrariaapi20202.excecoes.AutorNaoEncontradoException;
import br.edu.unichristus.livrariaapi20202.repositorios.AutorRepository;

@Service
public class AutorService {

	@Autowired
	private AutorRepository repo;

	public Autor salvar(Autor autor) {
		Autor a = this.repo.save(autor);
		System.out.println("Autor " + autor.getNome() + " salvo!");
		return a;
	}

	public List<Autor> buscarTodos() {
		System.out.println("OBTENDO A LISTA COMPLETA DE AUTORES");
		return this.repo.findAll();
	}

	public Autor buscarPeloID(Long idAutor) {
		System.out.println("OBTENDO O AUTOR COM O ID = " + idAutor);
		if (this.repo.findById(idAutor).isPresent()) {
			return this.repo.findById(idAutor).get();
		} else {
			throw new AutorNaoEncontradoException(idAutor);
		}
	}

	public List<Autor> buscarPelosIDs(ArrayList<Long> idsAutores) {
		System.out.println("OBTENDO OS AUTORES COM OS IDS " + idsAutores.toString());
		return this.repo.findAllById(idsAutores);
	}

	public void remover(Long idAutor) {
		Autor autorARemover = this.buscarPeloID(idAutor);
		if (autorARemover.getLivros().size() != 0) {
			throw new AutorJaPossuiLivrosException(idAutor);
		} else {
			this.repo.deleteById(idAutor);
			System.out.println("REMOVIDO O AUTOR COM ID = " + idAutor);
		}
	}

	public void remover(Autor autor) {
		this.remover(autor.getAutorID());
		System.out.println("REMOVIDO O AUTOR COM ID = " + autor.getAutorID());
	}

}
