package br.edu.unichristus.livrariaapi20202.repositorios;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unichristus.livrariaapi20202.entidades.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

    public List<Livro> findByTitulo(String titulo);


    // Livros com uma quantidade exata de paginas
    public List<Livro> findByNumeroPaginasEquals(int paginas);

    // Livros publicados até uma determinada data
    public List<Livro> findByDataPublicacaoBefore(LocalDate data);
    
}
