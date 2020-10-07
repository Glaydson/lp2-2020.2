package br.edu.unichristus.livrariaapi20202.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.unichristus.livrariaapi20202.repositorios.AutorRepository;

@Service
public class AutorService {

    @Autowired
    private AutorRepository repo;
    
}
