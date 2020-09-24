package br.edu.unichristus.livrariaapi20202.servicos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.unichristus.livrariaapi20202.entidades.Livro;
import br.edu.unichristus.livrariaapi20202.repositorios.LivroRepository;

@Service
public class LivroService {

    @Autowired
    private LivroRepository repoLivros;

    public void salvar(Livro livro) {
        this.repoLivros.save(livro);
        System.out.printf("Livro %s gravado!%n", livro.getTitulo());
    }

    public Livro buscarPeloID(long idLivro) {
        Optional<Livro> livro = this.repoLivros.findById(idLivro);
        return livro.get();

    }

    public List<Livro> buscarPelosIDs(ArrayList<Long> idsLivros) {
        return this.repoLivros.findAllById(idsLivros);
    }

    public List<Livro> buscarTodos() {
        System.out.println("OBTENDO TODOS OS LIVROS");
        return this.repoLivros.findAll();
    }

    public void remover(Long idLivro) {
        Livro livroBD = this.buscarPeloID(idLivro);
        this.repoLivros.deleteById(idLivro);
        System.out.println("Livro " + livroBD.getTitulo() + " removido");
    }

    public void remover(Livro livro) {
        Livro livroBD = this.buscarPeloID(livro.getLivroID());
        this.repoLivros.delete(livroBD);
        System.out.println("Livro " + livroBD.getTitulo() + " removido");
    }

    public Livro buscarPeloTitulo(String titulo) {
        return this.repoLivros.findByTitulo(titulo);
    }

    public List<Livro> buscarPeloTituloLike(String titulo) {
        return this.repoLivros.findByTituloLike(titulo);
    }

    public List<Livro> buscarPeloTituloContendo(String titulo) {
        return this.repoLivros.findByTituloContaining(titulo);
    }

    public List<Livro> buscarPeloTituloComecandoCom(String titulo) {
        return this.repoLivros.findByTituloStartingWith(titulo);
    }

    public List<Livro> buscarPeloTituloTerminandoCom(String titulo) {
        return this.repoLivros.findByTituloEndingWith(titulo);
    }

    public List<Livro> buscarPeloTituloIgnorandoCaixa(String titulo) {
        return this.repoLivros.findByTituloIgnoreCase(titulo);
    }

    public List<Livro> buscarPeloNumeroDePaginas(int numeroPaginas) {
        return this.repoLivros.findByNumeroPaginasEquals(numeroPaginas);
    }

    public List<Livro> buscarPeloNumeroDePaginasMaiorQue(int numeroPaginas) {
        return this.repoLivros.findByNumeroPaginasGreaterThan(numeroPaginas);
    }

    public List<Livro> buscarPeloNumeroDePaginasIntervalo(int min, int max) {
        return this.repoLivros.findByNumeroPaginasBetween(min, max);
    }

    public List<Livro> buscarPeloTituloContendoOu(String titulo1, String titulo2) {
        return this.repoLivros.findByTituloContainingOrTituloContaining(titulo1, titulo2);
    }

    public List<Livro> buscarPeloTituloDiferenteDe(String titulo) {
        return this.repoLivros.findByTituloNot(titulo);
    }

    public List<Livro> buscarPeloTituloContendoENumeroPaginasMaior(String titulo, int numeroPaginas) {
        return this.repoLivros.findByTituloContainingAndNumeroPaginasGreaterThan(titulo, numeroPaginas);
    }

    public List<Livro> buscarDataPublicacaoAntesDe(LocalDate data) {
        return this.repoLivros.findByDataPublicacaoBefore(data);
    }

    public List<Livro> buscarDataPublicacaoDepoisDe(LocalDate data) {
        return this.repoLivros.findByDataPublicacaoAfter(data);
    }

    public List<Livro> buscarDataPublicacaoEntre(LocalDate data1, LocalDate data2) {
        return this.repoLivros.findByDataPublicacaoBetween(data1, data2);
    }

    public List<Livro> buscarLivrosPeloTituloContendoOrdemCrescente(String titulo) {
        return this.repoLivros.findByTituloContainingOrderByTituloAsc(titulo);
    }

}
