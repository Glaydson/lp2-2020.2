package br.edu.unichristus.livrariaapi20202;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.unichristus.livrariaapi20202.entidades.Editora;
import br.edu.unichristus.livrariaapi20202.entidades.Livro;
import br.edu.unichristus.livrariaapi20202.servicos.EditoraService;
import br.edu.unichristus.livrariaapi20202.servicos.LivroService;

@SpringBootApplication
public class LivrariaApi20202ApplicationEditoras implements CommandLineRunner {

	@Autowired
	private LivroService servicoLivros;

	@Autowired
	private EditoraService servicoEditoras;

	public static void main(String[] args) {
		SpringApplication.run(LivrariaApi20202ApplicationEditoras.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		inserirDados();
		
		/* Alterar a cidade da editora Bookman para Porto Alegre
		Remover a editora Moderna
		Buscar as editoras com sede no Rio de Janeiro
		Buscar as editoras cujo nome inicie pelas letras ‘A’ ou ‘B’
		Buscar as editoras do Rio de Janeiro e de São Paulo */
		
		System.out.println("ALTERANDO A CIDADE DA EDITORA BOOKMAN");
		Editora bookman = this.servicoEditoras.buscarPeloNome("Bookman");
		bookman.setCidade("Porto Alegre");
		this.servicoEditoras.salvar(bookman);

		System.out.println("REMOVENDO A EDITORA MODERNA");
		Editora moderna = this.servicoEditoras.buscarPeloNome("Moderna");
		this.servicoEditoras.remover(moderna);

		System.out.println("BUSCA EDITORAS COM SEDE NO RIO");
		this.servicoEditoras.buscarPelaSede("Rio de Janeiro").forEach(System.out::println);

		System.out.println("EDITORAS CUJO NOME INICIA POR A OU POR B");
		this.servicoEditoras.buscarPeloNomeIniciandoPorLetra1OuLetra2("A", "B").forEach(System.out::println);

		System.out.println("EDITORAS DO RIO DE JANEIRO E SÃO PAULO");
		this.servicoEditoras.buscarPelaCidade1eCidade2("Rio de Janeiro", "São Paulo");
		this.servicoEditoras.buscarPelaSede("Rio de Janeiro").forEach(System.out::println);
		this.servicoEditoras.buscarPelaSede("São Paulo").forEach(System.out::println);

		System.out.println("EDITORAS FUNDADAS DEPOIS DE 2005");
		this.servicoEditoras.buscarPeloAnoFundacaoMaiorQue(2005).forEach(System.out::println);
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
	}

}
