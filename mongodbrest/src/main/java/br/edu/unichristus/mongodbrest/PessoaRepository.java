package br.edu.unichristus.mongodbrest;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

public interface PessoaRepository extends MongoRepository<Pessoa, String> {
    
    List<Pessoa> findByUltimoNome(@Param("nome") String nome);

    List<Pessoa> findByPrimeiroNome(@Param("nome") String nome);
    

}
