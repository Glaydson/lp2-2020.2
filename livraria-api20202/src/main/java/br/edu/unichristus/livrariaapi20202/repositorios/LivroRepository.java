package br.edu.unichristus.livrariaapi20202.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unichristus.livrariaapi20202.entidades.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    
}
