package br.edu.unichristus.livrariaapi20202.repositorios;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.edu.unichristus.livrariaapi20202.entidades.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, String> {
    
}
