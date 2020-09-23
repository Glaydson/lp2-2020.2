package br.edu.unichristus.livrariaapi20202;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.unichristus.livrariaapi20202.entidades.Editora;
import br.edu.unichristus.livrariaapi20202.entidades.Livro;
import br.edu.unichristus.livrariaapi20202.servicos.EditoraService;
import br.edu.unichristus.livrariaapi20202.servicos.LivroService;

@SpringBootApplication
public class LivrariaApi20202Application implements CommandLineRunner {

	@Autowired
	private LivroService servicoLivros;

	@Autowired
	private EditoraService servicoEditoras;

	public static void main(String[] args) {
		SpringApplication.run(LivrariaApi20202Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Livro livro = new Livro("Java Como Programar", LocalDate.of(2017, 8, 20), 250, new BigDecimal("15.00"));
		this.servicoLivros.salvar(livro);

		Livro livro2 = new Livro("Vue Js", LocalDate.of(2020, 8, 20), 150, new BigDecimal("150.00"));
		this.servicoLivros.salvar(livro2);

		Editora editora = new Editora("Campus", "Rio de Janeiro", 1978);
		this.servicoEditoras.salvar(editora);

		// Buscando um livro pelo seu ID
		Livro livro1 = this.servicoLivros.buscarPeloID(1L);
		System.out.println(livro1);

		// Buscar um livro pelo seu título
		List<Livro> livrosJava = this.servicoLivros.buscarPeloTitulo("Java");
		livrosJava.forEach(System.out::println);

		// Buscar os livros com uma quantidade de páginas dada
		List<Livro> livros300paginas = this.servicoLivros.buscarPeloNumeroPaginas(300);
		livros300paginas.forEach(System.out::println);

		// Buscar os livros publicados até uma determinada data
		List<Livro> livrosAntes2010 = this.servicoLivros.buscarLivrosPublicadosAntesDeUmaData(LocalDate.of(2010, 12, 31));
		livrosAntes2010.forEach(System.out::println);

	}

}
