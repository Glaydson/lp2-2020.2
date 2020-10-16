package br.edu.unichristus.livrariaapi20202.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.unichristus.livrariaapi20202.entidades.Cliente;
import br.edu.unichristus.livrariaapi20202.repositorios.ClienteRepository;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository repo;

    public void salvar(Cliente c) {
        this.repo.save(c);
        System.out.println("Cliente " + c.getNome() + " gravado!");
    }

    public void removerTodos() {
        this.repo.deleteAll();
    }
}
