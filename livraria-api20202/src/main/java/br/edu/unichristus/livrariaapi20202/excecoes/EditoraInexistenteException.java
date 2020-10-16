package br.edu.unichristus.livrariaapi20202.excecoes;

public class EditoraInexistenteException extends RuntimeException {

    public EditoraInexistenteException(String nome) {
        super("Editora " + nome + " não existe!");
    }

    

}
