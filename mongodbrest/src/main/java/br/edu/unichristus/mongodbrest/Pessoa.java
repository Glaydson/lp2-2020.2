package br.edu.unichristus.mongodbrest;

import org.springframework.data.annotation.Id;

public class Pessoa {

    @Id
    private String id;

    private String primeiroNome;

    private String ultimoNome;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getUltimoNome() {
        return ultimoNome;
    }

    public void setUltimoNome(String ultimoNome) {
        this.ultimoNome = ultimoNome;
    }

    
    
}
