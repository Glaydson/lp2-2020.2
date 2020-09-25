package br.edu.unichristus.livrariaapi20202.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.unichristus.livrariaapi20202.entidades.Editora;
import br.edu.unichristus.livrariaapi20202.repositorios.EditoraRepository;

@Service
public class EditoraService {

    @Autowired
    private EditoraRepository repo;

    public void salvar(Editora editora) {
        this.repo.save(editora);
        System.out.println("Editora " + editora.getNome() + " gravada!");
    }

    public Editora buscarPeloNome(String nome) {
        return this.repo.findByNome(nome);
    }

    public List<Editora> buscarPelaSede(String cidade) {
        return this.repo.findByCidade(cidade);
    }

    public void remover(Editora editora) {
        this.repo.delete(editora);
        System.out.println("Editora " + editora.getNome() + " removida!");
    }

    public void removerTodos() {
        this.repo.deleteAll();
    }

    public List<Editora> buscarPeloNomeIniciandoPorLetra1OuLetra2(String letra1, String letra2) {
        return this.repo.findByNomeStartingWithOrNomeStartingWith(letra1, letra2);
    }

    public List<Editora> buscarPelaCidade1eCidade2(String cidade1, String cidade2) {
        return this.repo.findByCidadeContainingOrCidadeContaining(cidade1, cidade2);
    }

    public List<Editora> buscarPeloAnoFundacaoMaiorQue(int ano) {
        return this.repo.findByAnoFundacaoGreaterThan(ano);
    }
    
}
