package br.edu.unichristus.livrariaapi20202.excecoes;

public class EditoraJaExistenteException extends RuntimeException {

    public EditoraJaExistenteException(String nome) {
        super("Editora " + nome + " já existente!");
    }

    
    
}
