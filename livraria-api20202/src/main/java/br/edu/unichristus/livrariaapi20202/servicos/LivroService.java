package br.edu.unichristus.livrariaapi20202.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.unichristus.livrariaapi20202.entidades.Livro;
import br.edu.unichristus.livrariaapi20202.repositorios.LivroRepository;

@Service
public class LivroService {

    @Autowired
    private LivroRepository repo;

    public void salvar(Livro livro) {
        this.repo.save(livro);
    }

    public Livro buscarPeloID(long idLivro) {
        return this.repo.findById(idLivro).get();
    }

}
