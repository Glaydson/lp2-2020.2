package br.edu.unichristus.livrariaapi20202.entidades;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name = "TB_LIVROS")
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LIVRO_ID")
	private Long livroID;

	@NotNull
	@Size(min = 2, message = "O título deve ter pelo menos 2 caracteres")
	@Column(name = "TITULO")
	private String titulo;

	@Column(name = "DATA_PUBLICACAO")
	private LocalDate dataPublicacao;

	@Min(value = 50, message = "O livro deve ter pelo menos 50 páginas")
	@Column(name = "NUMERO_PAGINAS")
	private int numeroPaginas;

	@Column(name = "PRECO")
	private BigDecimal preco;

	@ManyToOne // sem mappedBy, pois é o dono da relação
	@JoinColumn(name = "EDITORA_ID")
	@JsonIgnoreProperties("livros")
	private Editora editora;

	@ManyToMany
	@JoinTable(name = "TB_LIVROS_AUTORES")
	@JsonIgnoreProperties("livros")
	private List<Autor> autores;

	public Livro() {
	}

	public Livro(String titulo, LocalDate dataPublicacao, int numeroPaginas, BigDecimal preco) {
		this.titulo = titulo;
		this.dataPublicacao = dataPublicacao;
		this.numeroPaginas = numeroPaginas;
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Livro [dataPublicacao=" + dataPublicacao + ", livroID=" + livroID + ", numeroPaginas=" + numeroPaginas
				+ ", preco=" + preco + ", titulo=" + titulo + "]";
	}

}
