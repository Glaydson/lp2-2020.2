package br.edu.unichristus.livrariaapi20202.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.unichristus.livrariaapi20202.entidades.Editora;

public interface EditoraRepository extends JpaRepository<Editora, Long> {
    
    public Editora findByNome(String nome);

    public List<Editora> findByCidade(String cidade);

    public List<Editora> findByNomeStartingWithOrNomeStartingWith(String letra1, String letra2);

    public List<Editora> findByCidadeContainingOrCidadeContaining(String cidade1, String cidade2);

    public List<Editora> findByAnoFundacaoGreaterThan(int ano);
}
