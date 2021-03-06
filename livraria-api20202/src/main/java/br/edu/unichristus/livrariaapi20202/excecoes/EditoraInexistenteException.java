package br.edu.unichristus.livrariaapi20202.excecoes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EditoraInexistenteException extends RuntimeException {

    public EditoraInexistenteException(String nome) {
        super("Editora " + nome + " não existe!");
    }

    

}
