package br.edu.unichristus.livrariaapi20202.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unichristus.livrariaapi20202.entidades.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    
}
