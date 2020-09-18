package br.edu.unichristus.livrariaapi20202.servicos;

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
    }
    
}
