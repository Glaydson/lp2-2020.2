package br.edu.unichristus.livrariaapi20202.servicos;

import java.time.LocalDate;
import java.util.List;

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
        System.out.println("LIVRO " + livro.getTitulo() + " SALVO");
    }

    public Livro buscarPeloID(long idLivro) {
        return this.repo.findById(idLivro).get();
    }

    public List<Livro> buscarPeloTitulo(String titulo) {
        return this.repo.findByTitulo(titulo);
    }

    public List<Livro> buscarPeloNumeroPaginas(int paginas) {
        return this.repo.findByNumeroPaginasEquals(paginas);
    }

    public List<Livro> buscarLivrosPublicadosAntesDeUmaData(LocalDate data) {
        return this.repo.findByDataPublicacaoBefore(data);
    }

}
