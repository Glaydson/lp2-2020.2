package br.edu.unichristus.livrariaapi20202.entidades;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "TB_EDITORAS")
public class Editora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EDITORA_ID")
    private Long editoraID;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "CIDADE")
    private String cidade;

    @Column(name = "ANO_FUNDACAO")
    private int anoFundacao;

    @OneToMany(mappedBy = "editora", fetch = FetchType.EAGER)
    private List<Livro> livros;

    public Editora() {
    }

    public Editora(String nome, String cidade, int anoFundacao) {
        this.nome = nome;
        this.cidade = cidade;
        this.anoFundacao = anoFundacao;
    }

    @Override
    public String toString() {
        return "Editora [anoFundacao=" + anoFundacao + ", cidade=" + cidade + ", editoraID=" + editoraID + ", nome="
                + nome + "]";
    }

}
