package br.edu.unichristus.livrariaapi20202.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unichristus.livrariaapi20202.entidades.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    public List<Autor> findByNomeContaining(String nome);

    public List<Autor> findByPais(String pais);

    public List<Autor> findByLivrosTituloContaining(String nome);

    public List<Autor> findByLivrosEditoraNome(String nome);
    
}
