package br.edu.unichristus.livrariaapi20202;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.unichristus.livrariaapi20202.entidades.Autor;
import br.edu.unichristus.livrariaapi20202.entidades.Editora;
import br.edu.unichristus.livrariaapi20202.entidades.Livro;
import br.edu.unichristus.livrariaapi20202.servicos.AutorService;
import br.edu.unichristus.livrariaapi20202.servicos.EditoraService;
import br.edu.unichristus.livrariaapi20202.servicos.LivroService;

@SpringBootApplication
public class OperacoesInsercaoApplication implements CommandLineRunner {

	@Autowired
	private LivroService servicoLivros;

	@Autowired
	private EditoraService servicoEditoras;

	@Autowired
	private AutorService servicoAutores;

	public static void main(String[] args) {
		SpringApplication.run(OperacoesInsercaoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//inserirDados();
		
		// Inserindo uma nova editora e um livro associado
		Editora cultura = new Editora("Cultura", "São Paulo", 2020);
		Livro livro1 = new Livro("JPA Avançado", LocalDate.of(2020, 10, 8), 190, new BigDecimal(50) );
		livro1.setEditora(cultura);

		this.servicoEditoras.salvar(cultura);
		this.servicoLivros.salvar(livro1);

		// Inserir um novo livro com um único autor
		Autor jose = new Autor("José da Silva", "Brasil");
		Autor maria = new Autor("Maria", "Argentina");
		Livro livro2 = new Livro("Spring Boot", LocalDate.of(2020, 10, 8), 100, new BigDecimal(10) );
		List<Autor> autores = new ArrayList<>();
		autores.add(jose);
		autores.add(maria);

		livro2.setAutores(autores);

		this.servicoAutores.salvar(jose);
		this.servicoAutores.salvar(maria);
		this.servicoLivros.salvar(livro2);

		// TODOS OS LIVROS DE UMA EDITORA
		List<Livro> livrosCultura = this.servicoLivros.buscarPeloNomeDaEditora("Cultura");
		livrosCultura.forEach(System.out::println);

	}

	public void inserirDados() {
		
		this.servicoLivros.salvar(new Livro("Sobre Mouses e Homens", LocalDate.of(1954, 11, 8), 100, new BigDecimal("11.00")));
		this.servicoLivros.salvar(new Livro("Um Estranho no Ninho", LocalDate.of(1973, 11, 8), 200, new BigDecimal("51.00")));
		this.servicoLivros.salvar(new Livro("Por Quem os Sinos Dobram", LocalDate.of(1932, 11, 8), 100, new BigDecimal("13.00")));
		this.servicoLivros.salvar(new Livro("Guerra e Paz", LocalDate.of(1955, 11, 8), 140, new BigDecimal("15.00")));
		this.servicoLivros.salvar(new Livro("As Vinhas da Ira", LocalDate.of(1955, 11, 8), 300, new BigDecimal("16.00")));
		this.servicoLivros.salvar(new Livro("Padrões de Design", LocalDate.of(1996, 11, 8), 180, new BigDecimal("14.00")));
		this.servicoLivros.salvar(new Livro("Um Conto de Duas Cidades", LocalDate.of(1943, 11, 8), 400, new BigDecimal("15.00")));
		
		this.servicoEditoras.salvar(new Editora("Campus", "Rio de Janeiro", 2000));
		this.servicoEditoras.salvar(new Editora("Saraiva", "São Paulo", 1950));
		this.servicoEditoras.salvar(new Editora("Moderna", "Rio de Janeiro", 1964));
		this.servicoEditoras.salvar(new Editora("Bookman", "Florianópolis", 2002));
		this.servicoEditoras.salvar(new Editora("Atlas", "Porto Alegre", 1994));
		this.servicoEditoras.salvar(new Editora("Pearson", "São Paulo", 2010));

		this.servicoAutores.salvar(new Autor("Orson Welles", "Inglaterra"));
		this.servicoAutores.salvar(new Autor("Aldous Huxley", "Inglaterra"));
		this.servicoAutores.salvar(new Autor("Leo Tolstoi", "Rússia"));
		this.servicoAutores.salvar(new Autor("Sérgio Iudicibus", "Brasil"));
		this.servicoAutores.salvar(new Autor("Harvey Deitel", "Estados Unidos"));
		this.servicoAutores.salvar(new Autor("Paul Deitel", "Estados Unidos"));

		

		
		
		

	}

}
