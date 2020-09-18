package br.edu.unichristus.livrariaapi20202.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.unichristus.livrariaapi20202.entidades.Editora;

public interface EditoraRepository extends JpaRepository<Editora, Long> {
    
}
