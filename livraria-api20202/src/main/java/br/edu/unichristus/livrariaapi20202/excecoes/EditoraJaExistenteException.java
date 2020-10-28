package br.edu.unichristus.livrariaapi20202.excecoes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class EditoraJaExistenteException extends RuntimeException {

    public EditoraJaExistenteException(String nome) {
        super("Editora " + nome + " já existente!");
    }

    
    
}
