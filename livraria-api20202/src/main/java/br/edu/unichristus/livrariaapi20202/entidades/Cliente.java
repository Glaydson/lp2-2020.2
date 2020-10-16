package br.edu.unichristus.livrariaapi20202.entidades;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Cliente {
    
    @Id
    private String id;
    private String nome;
    private String email;
    private LocalDate data;
    private List<Endereco> enderecos;

    public Cliente(String nome, String email, LocalDate data, List<Endereco> enderecos) {
        this.nome = nome;
        this.email = email;
        this.data = data;
        this.enderecos = enderecos;
    }

    
}
